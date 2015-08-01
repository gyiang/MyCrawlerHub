package net.trustie.test;

import net.trustie.test.model.SgsPunishDetail;
import net.trustie.test.model.SgsPunishList;
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
 * Created by yiang on 2015/3/14.
 */

@Component
public class SgsPunishCrawler {
    private static int beginId=1;
    private static int endid=88;
    private int threadNum=10;

    @Qualifier("SgsPunishListPipeline")
    @Autowired
    private PageModelPipeline sgsPunishListPipeline;

    @Qualifier("SgsPunishDetailPipeline")
    @Autowired
    private PageModelPipeline sgsPunishDetailPipeline;

    @Resource
    private  SgsPunishDAO sgsPunishDAO;

    private static Site site=Site.me().setTimeOut(20000).setSleepTime(2000)
            .setUserAgent("Mozilla/5.0 (compatible; Baiduspider/2.0; " +
                    "+http://www.baidu.com/search/spider.html)");

    // 列表页爬取
    public void crawlList() {
        List<String> urls=new ArrayList<String>();
        for (int id=beginId;id<=endid;id++){
            urls.add("http://www.sgs.gov.cn/shaic/punish!getList.action?p="+id);
        }
        OOSpider.create(site
                , sgsPunishListPipeline
                , SgsPunishList.class
        ).startUrls(urls).thread(threadNum).setSpawnUrl(false).run();
    }

    // 详情页爬取
    public void crawlDeatil() {
        OOSpider.create(site
                , sgsPunishDetailPipeline
                , SgsPunishDetail.class
        ).startUrls(sgsPunishDAO.getTargetUrls()).thread(threadNum).setSpawnUrl(false).run();
    }


    public static void main(String[] args) {
        // 加载配置
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
        final SgsPunishCrawler sgsPunishCrawler= applicationContext.getBean(SgsPunishCrawler.class);

        // sgsPunishCrawler.crawlList();

        // 处理流程:
        // download（下载页面）
        // ->model(解析并封装，使用ExtractBy+XPath)
        // ->pipeline（持久化，使用Mybatis）
        // ->db(MySQL)
        sgsPunishCrawler.crawlDeatil();

    }
}
