package net.trustie.task.utils;

import us.codecraft.webmagic.Spider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyiang on 2014/8/5.
 */
public class OrderSpider {

    public static List<String> orderUrl(String purl,String surl,int per,int incIndex,int startIndex)
    {
        List<String> urls = new ArrayList<String>();
        for (int g = startIndex; g < startIndex+per; g++) {
            int pageindex=g+incIndex;
            String url = purl + pageindex+ surl;
            urls.add(url);
        }
        return urls;
    }
    /*
    * @startIndex起始页
    * @endIndex结束页
    * @per每次生成几个链接
    * @purl 前缀
    * @furl 后缀
    *（p、f是什么意思？）
    * 调用方式：
    * OrderSpider.startSpider(spider, 1, 4,2 , "http://www.oschina.net/project/list?prefix=&sort=view&p=", "");
    * */

    public static void startSpider(Spider spider,int startIndex,int endIndex,int per,String purl,String furl)
    {
        for (int i = startIndex; i < endIndex; i+=per)
        {
            // 采用startUrls ，配合0.5.1支持sourceRegion
            spider.startUrls(orderUrl(purl,furl,per,0,i));

            // 爬虫监控用，不需要
         /*   try {
            MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName objName = new ObjectName("WebMagic" + ":name=" + spider.getSite().getDomain());
            if (mbeanServer.isRegistered(objName))
                mbeanServer.unregisterMBean(objName);
            spider.setUUID(spider.getSite().getDomain());
            SpiderMonitor.instance().register(spider);
        } catch (JMException e) {
            e.printStackTrace();
        }*/
            spider.run();
        }
    }
}
