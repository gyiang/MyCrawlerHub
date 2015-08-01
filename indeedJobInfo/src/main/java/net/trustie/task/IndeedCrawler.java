package net.trustie.task;

import net.trustie.task.dao.IndeedDao;
import net.trustie.task.model.IndeedDetail;
import net.trustie.task.model.IndeedList;
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
 * Created by yiang on 2015/4/9.
 */
@Component
public class IndeedCrawler {
    private static int beginId=0;
    private static int endid=10000;
    private int threadNum=10;

    @Qualifier("IndeedListPipeline")
    @Autowired
    private PageModelPipeline indeedListPipeline;


    @Qualifier("IndeedDetailPipeline")
    @Autowired
    private PageModelPipeline indeedDetailPipeline;

    @Resource
    private IndeedDao indeedDao;

    private static Site site=Site.me().setTimeOut(20000).setSleepTime(5000)
            .setUserAgent("Mozilla/5.0 (compatible; Baiduspider/2.0; " +
                    "+http://www.baidu.com/search/spider.html)");


    // 列表页爬取
    public void crawlList() {

        while(true) {
            //取标签
            String tag = indeedDao.getTags();
            if (tag==null || tag.equals("")){
                break;
            }
            int num=indeedDao.getTagNum(tag);
            //int endid=(int)num/10;
            if (num>1000){
                endid=1000;
            }else{
                endid=num;
            }

            List<String> urls = new ArrayList<String>();
            for (int id = beginId; id <= endid; id += 10) {
                urls.add("http://www.indeed.com/jobs?q=" + tag + "&sort=date&start=" + id);
                //urls.add("http://cn.indeed.com/%E5%B7%A5%E4%BD%9C?q=" + tag + "&sort=date&start=" + id);
            }
            OOSpider.create(site
                    , indeedListPipeline
                    , IndeedList.class
            ).startUrls(urls).setSpawnUrl(false).thread(threadNum).run();

            //时间戳标记
            indeedDao.setTimestamp(tag);
        }
    }

    // 详情页爬取
    public void crawlDeatil() {
        while(true) {

            List<String> l=indeedDao.getTargetUrls();
            if(l==null){
                break;
            }
            OOSpider.create(site
                    , indeedDetailPipeline
                    , IndeedDetail.class
            ).startUrls(l).thread(threadNum).setSpawnUrl(false).run();
        }

    }


    public static void main(String[] args) {
        // 加载配置
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
        final IndeedCrawler indeedCrawler= applicationContext.getBean(IndeedCrawler.class);

        indeedCrawler.crawlList();
        //indeedCrawler.crawlDeatil();

    }
}
