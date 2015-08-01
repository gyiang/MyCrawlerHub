package net.trustie.task;

import net.trustie.task.model.Bugzilla;
import net.trustie.task.utils.AutoUpdate;
import net.trustie.task.utils.LoadConf;
import net.trustie.task.utils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;


/**
 * Created by yiang on 2015/03/19.
 */
@Component
public class BugzillaCrawler {

        @Qualifier("BugzillaDaoPipeline")
        @Autowired
        private PageModelPipeline bugzillaDaoPipeline;

        public void crawl() {
            LoadConf conf = new LoadConf("bugzilla");
            Spider spider=
                    OOSpider.create(Site.me()
                                    .setRetryTimes(conf.getRetryTimes())
                                    .setCycleRetryTimes(conf.getCycleRetryTimes())
                                    .setTimeOut(conf.getTimeOut())
                                    .setSleepTime(conf.getSleepTimeThread())
                                    .setDomain(conf.getDomain())
                                    .setUserAgent(UserAgent.Google)
                            , bugzillaDaoPipeline
                            , Bugzilla.class
                    )//.setScheduler(new FileCacheQueueScheduler("./cursor"))
                            .thread(conf.getThreadNum()).setSpawnUrl(false);
            AutoUpdate.go(spider, conf.getStartPageIndex(), conf.getEndInPageIndex(), conf.getPageF(),
                    "https://bugzilla.mozilla.org/show_bug.cgi?id=", "",
                    conf.getSleepTimeSpider(), conf.getThreadNum(), bugzillaDaoPipeline, Bugzilla.class);
        }
        public static void main(String[] args) {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
            final BugzillaCrawler webMagicCrawler = applicationContext.getBean(BugzillaCrawler.class);
            webMagicCrawler.crawl();
        }
    }

