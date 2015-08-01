# sgsPunishCrawler
网络垂直爬虫实例，使用了Webmagic+Mybatis-Spring

**处理流程**:download（下载页面,使用HttpClient）->model(解析并封装，使用Xsoup，@ExtractBy+XPath)->pipeline（持久化，使用Mybatis）->db(MySQL)

数据源：某工商行政管理局公开的数据

开发环境：IDEA




