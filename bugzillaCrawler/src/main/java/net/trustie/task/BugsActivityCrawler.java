package net.trustie.task;


import net.trustie.task.model.BugsActivity;
import net.trustie.task.utils.LoadConf;
import net.trustie.task.utils.UserAgent;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/11/6.
 */
@Component
public class BugsActivityCrawler {

    @Qualifier("FireFoxBugsActivityDAOPipeline")
    @Autowired
    private PageModelPipeline bugzillaDaoPipeline;


    public void crawl() {
        LoadConf conf = new LoadConf("bugzilla");
        int start=conf.getStartPageIndex();
        int end=conf.getEndInPageIndex();
        int per=conf.getPageF();
        List<String> startUrl=new ArrayList<String>();
        for (int startline=start;startline<end;startline+=10) {
            for(int i=startline;i<startline+per;i++)
            {
                startUrl.add("https://bugzilla.mozilla.org/show_activity.cgi?id=" + i);
            }
            OOSpider.create(Site.me()
                            .setRetryTimes(conf.getRetryTimes())
                            .setCycleRetryTimes(conf.getCycleRetryTimes())
                            .setTimeOut(conf.getTimeOut())
                            .setSleepTime(conf.getSleepTimeThread())
                            .setDomain(conf.getDomain())
                            .setUserAgent(UserAgent.Google)
                    , bugzillaDaoPipeline
                    , BugsActivity.class
            ).thread(conf.getThreadNum()).setSpawnUrl(false).startUrls(startUrl).run();
            // 清洗
            startUrl.clear();
        }
 }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
        final BugsActivityCrawler webMagicCrawler = applicationContext.getBean(BugsActivityCrawler.class);
        webMagicCrawler.crawl();
    }
}
