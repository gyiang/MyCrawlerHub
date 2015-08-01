package net.trustie.task;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by yiang on 2015/2/14.
 */
public class ShixinCrawlerTest {

    public static void main(String[] args) {

        final Site site =Site.me().setSleepTime(10000).setTimeOut(1200000).setDomain("http://shixin.court.gov.cn/")
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36");

       Spider.create(new PageProcessor() {
            @Override
            public void process(Page page) {
                System.out.println(page.getRawText());
            }

            @Override
            public Site getSite() {
                return site;
            }
        // }).thread(1).addUrl("http://zhixing.court.gov.cn/search/detail?id=7339573").run();
       // }).thread(1).addUrl("http://shixin.court.gov.cn/personMore.do?currentPage=1").run();
        }).thread(1).addUrl("http://shixin.court.gov.cn/unitMore.do?currentPage=1").run();

    }

}
