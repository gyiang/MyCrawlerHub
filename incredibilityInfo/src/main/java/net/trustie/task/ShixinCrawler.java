package net.trustie.task;

import com.mongodb.*;
import com.mongodb.util.JSON;
import org.apache.log4j.Logger;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import java.util.List;

/**
 * Created by yiang on 2015/2/13.
 */
public class ShixinCrawler {

  private Logger logger=Logger.getLogger(ShixinCrawler.class);

  public void crawl(String url) {
      final Site site = Site.me().setSleepTime(10000).setTimeOut(5000).setRetryTimes(3)
              .setCycleRetryTimes(1).setDomain("baidu.com")
              .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) " +
                      "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36");

      // 页面数据处理过程，保存到mongodb，同时保存到磁盘文件./shixinJson
      Spider spider=Spider.create(new PageProcessor() {
          @Override
          public void process(Page page) {
              logger.info("Process#" + page.getRequest().getUrl());
              try {
                  // 驱动连接mongodb数据库
                  Mongo mongo = new Mongo();
                  DB db = mongo.getDB("shixinTest");
                  DBCollection q=db.getCollection("shixinTest1");
                  // new BasicDBObject();
                  // 通过JSON.parse构造DBObject
                  DBObject query = (BasicDBObject) JSON.parse(page.getRawText()
                          .substring("/**/jQuery110209281960396866472_1423821870903(".length()));
                  // query.put("data", "s");
                  logger.info(query.get("data"));

                  // 解析成100条
                  String[] querys= query.get("data").toString()
                          .substring("[ { \"result\" : [ ".length()).split("} ,");

                  // 一条一条数据插入
                  for(String s:querys ) {

                      int i1=s.indexOf("\"loc\" : \"");
                      int i2=s.indexOf("\" , \"lastmod\"");
                      logger.info("loc:"+s.substring(i1+"\"loc\" : \"".length(),i2));
                      List result=q.find(new BasicDBObject("loc",
                              s.substring(i1+"\"loc\" : \"".length(),i2))).toArray();
                      logger.info("DBCursor:"+q.find(new BasicDBObject("loc",
                              s.substring(i1+"\"loc\" : \"".length(),i2))).toArray());
                      // 判断是否已经存在，loc存在且唯一
                      if(result.size()==0)
                      {
                         DBObject query2 = (BasicDBObject) JSON.parse(s+"}");
                         q.save(query2);
                         logger.info("Insert new data!");
                         logger.info("----------------------");
                       }else
                       {
                           logger.info("Already exist");
                           logger.info("----------------------");
                       }
                  }
              } catch (Exception e) {
                  logger.error("----------------");
                  logger.error(e.toString());
              }
              //System.out.println(page.getRawText().substring(0,100));
              // 将页面提交给Pipeline处理
              page.putField("page", page.getRawText());
          }
          @Override
          public Site getSite() {
              return site;
          }
      }).addPipeline(new FilePipeline("./shixinjson")).thread(1);
      spider.addUrl(url).run();
  }
    public static void main(String[] args) throws InterruptedException {

        // 爬虫种子url
        String prefix="http://opendata.baidu.com/api.php?resource_id=6899&query=http%3A%2F%2Fshixin.court.gov.cn&pn=";
        String suffix="&ie=utf-8&oe=utf-8&format=json";
        String suffix2="&cb=jQuery110209281960396866472_1423821870903";
        int pn=0;
        String url="";
        // 循环请求页面
        for (int pni=0;pni<=2000;pni+=100)
        {
            url=prefix+pn+suffix+suffix2;
            new ShixinCrawler().crawl(url);
            pn+=100;
            Thread.sleep(10000);
        }
    }
}
