package net.trustie.test;

import net.trustie.test.model.GdgsJyycList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;

import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yiang on 2015/3/19;
 */

@Component
public class GdgsJyycCrawler {
    private static int beginId=1;
    private static int endid=327; //327
    private int threadNum=5;

    @Qualifier("GdgsJyycListPipeline")
    @Autowired
    private PageModelPipeline GdgsJyycListPipeline;


    @Resource
    private  GdgsJyycDAO gdgsJyycDAO;

    private static Site site=Site.me().setTimeOut(30000).setSleepTime(2000).setCharset("UTF-8")
    .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) " +
            "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36");

    // 列表页爬取
    public void crawlList() {
        List<String> urls=new ArrayList<String>();
        for (int id=beginId;id<=endid;id++){
            urls.add("http://gsxt.gdgs.gov.cn/main/abnInfoPage?pageNo="+id);
        }
        OOSpider.create(site
                , GdgsJyycListPipeline
                , GdgsJyycList.class
        ).startUrls(urls).thread(threadNum).setSpawnUrl(false).run();
    }

    // 详情页爬取
    public void crawlDeatil() {

    }


    public static void main(String[] args) {
        // 加载配置
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
        final GdgsJyycCrawler gdgsJyycCrawler= applicationContext.getBean(GdgsJyycCrawler.class);
        gdgsJyycCrawler.crawlList();
    }


}
