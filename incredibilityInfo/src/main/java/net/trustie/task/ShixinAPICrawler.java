package net.trustie.task;

import com.mongodb.*;
import com.mongodb.util.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yiang on 2015/2/16.
 */
public class ShixinAPICrawler {
    // 15-02-18 03:43:01,346 已爬至 id=1209349（已公开的所有数据）
    // TODO: 设置爬取范围
    private static int beginId=1050000+1;
    private static int endid=1209349;
    private final static int inc=100000;
    // 并发线程数，建议不要过高
    private int threadNum=64;
    // 线程休眠时间，单位毫秒
    private int threadSleepTime=5000;

    private static Log logger= LogFactory.getLog("extProfile");

    public void crawl(List urls) throws UnknownHostException {
        final Site site = Site.me().setSleepTime(this.threadSleepTime).setTimeOut(5000).setRetryTimes(3)
                .setCycleRetryTimes(1).setDomain("shixin.court.gov.cn")
                .setUserAgent("Mozilla/5.0 (compatible; " +
                        "Baiduspider/2.0; +http://www.baidu.com/search/spider.html)");

        Spider spider = Spider.create(new PageProcessor() {
            // 驱动连接mongodb数据库
            Mongo mongo = new Mongo();
            DB db = mongo.getDB("shixinDB");
            DBCollection qUnit=db.getCollection("shixinUnit");
            DBCollection qPerson=db.getCollection("shixinPerson");
            DBObject query;
            @Override
            public void process(Page page) {
                logger.info(page.getRawText());
                query = (BasicDBObject) JSON.parse(page.getRawText());

                // ！2015/02/17 16:45 Before id=800000
                // TODO：修正数据库分错Collection的6494条数据 （已修正 @2015/02/18 ）
                // 使用businessEntity判断是Person/Unit有问题
                // if(page.getRawText().contains("businessEntity"))

                // partyTypeName=580为Person，=581为Unit
                // After id=800000
                // TODO: 缺少判断重复的逻辑
                if(page.getRawText().contains("\"partyTypeName\":\"580\""))
                {
                    // 自然人信息分至shixinPerson集合
                    qPerson.save(query);
                }else
                {
                    // 法人或其他组织信息分至shixinUnit集合
                    qUnit.save(query);
                }
            }
            @Override
            public Site getSite() {
                return site;
            }
        });
        spider.startUrls(urls).thread(this.threadNum).run();
    }
    public static void main(String[] args) throws UnknownHostException {
        Long startTime=System.currentTimeMillis();

        // 爬虫种子urls集合
        List<String> urls=new ArrayList<String>();

        // 按照规则生成种子url
        for (int id=beginId;id<=endid;id++){
            urls.add("http://shixin.court.gov.cn/detail?id="+id);
        }
        // 爬取
        new ShixinAPICrawler().crawl(urls);

        Long endTime=System.currentTimeMillis();
        logger.info((endTime-startTime)/1000.0);
        System.out.println((endTime-startTime)/1000.0);
    }
}
