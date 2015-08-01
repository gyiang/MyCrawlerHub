package net.trustie.task.model;

import net.trustie.task.Utils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;


import java.util.List;


/**
 * Created by yiang on 2015/4/9.
 */
/*@HelpUrl("http://cn.indeed.com/%E5%B7%A5%E4%BD%9C\\?q=*\\&start=*")
@TargetUrl("http://cn.indeed.com/%E5%B7%A5%E4%BD%9C\\?q=*\\&start=*")*/
public class IndeedList implements AfterExtractor {

    @ExtractBy("//td[@id='resultsCol']/div[@itemtype='http://schema.org/JobPosting']/h2/a/@title")
    private List<String> jobTitle;

    @ExtractBy("//td[@id='resultsCol']/div[@itemtype='http://schema.org/JobPosting']/span[1]/span/text()")
    private List<String> company;

    @ExtractBy("//td[@id='resultsCol']/div[@itemtype='http://schema.org/JobPosting']/span[2]/span/span/text()")
    private List<String> location;

    @ExtractBy("//td[@id='resultsCol']/div[@itemtype='http://schema.org/JobPosting']/table/tbody/tr/td/div/span[@class='summary']/allText()")
    private List<String> jobSummary;

    @ExtractBy("//td[@id='resultsCol']/div[@itemtype='http://schema.org/JobPosting']/h2/a/@href")
    private List<String> jobSrcUrl;

    @ExtractBy("//td[@id='resultsCol']/div[@itemtype='http://schema.org/JobPosting']/table/tbody/tr/td/div/div/span[@class='date']/text()")
    private List<String> date;

    //@ExtractBy("//td[@id='resultsCol']/div[@itemtype='http://schema.org/JobPosting']/table/tbody/tr/td/div/div/span[@class='result-link-source']/text()")
    private List<String> jobSrc;

    //@ExtractByUrl("http://cn.indeed.com/%E5%B7%A5%E4%BD%9C\\?q=(.*)&sort=date&start=")
    @ExtractByUrl("www.indeed.com/jobs\\?q=(.*)&sort=date&start=")
    private String tag;

    @ExtractBy("//td[@id='resultsCol']/div/div/a[@class='jobtitle']/text()")
    private List<String> jobTitleTg;
    @ExtractBy("//td[@id='resultsCol']/div/div/div/span[@class='company']/text()")
    private List<String> companyTg;
    @ExtractBy("//td[@id='resultsCol']/div/div/div/span[@class='location']/text()")
    private List<String> locationTg;
    @ExtractBy("//td[@id='resultsCol']/div/div/table/tbody/tr/td/span[@class='summary']/allText()")
    private List<String> jobSummaryTg;
    @ExtractBy("//td[@id='resultsCol']/div/div/span[@class='sdn']/b/text()")
    private List<String> jobSrcTg;
    @ExtractBy("//td[@id='resultsCol']/div/div/a[@class='jobtitle']/@href")
    private List<String> jobSrcUrlTg;
    @ExtractBy("//td[@id='resultsCol']/div/div/span[@class='date']/text()")
    private List<String> dateTg;

    private String collectedTime;


    @Override
    public void afterProcess(Page page) {

        // 处理来源
        jobSrc=page.getHtml().regex("srcname:'([^']+)',cmp").all();
        for (int i=0;i<jobSrc.size();i++){
            jobSrc.set(i, Utils.decodeUnicode(jobSrc.get(i)));
        }
        collectedTime=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new java.util.Date());

        // 爬取中国网页时候才需要
        /*jobTitle.addAll(jobTitleTg);
        jobSrc.addAll(jobSrcTg);
        jobSrcUrl.addAll(jobSrcUrlTg);
        jobSummary.addAll(jobSummaryTg);
        company.addAll(companyTg);
        location.addAll(locationTg);
        date.addAll(dateTg);*/
    }

    public List<String> getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(List<String> jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<String> getCompany() {
        return company;
    }

    public void setCompany(List<String> company) {
        this.company = company;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    public List<String> getJobSummary() {
        return jobSummary;
    }

    public void setJobSummary(List<String> jobSummary) {
        this.jobSummary = jobSummary;
    }

    public List<String> getJobSrcUrl() {
        return jobSrcUrl;
    }

    public void setJobSrcUrl(List<String> jobSrcUrl) {
        this.jobSrcUrl = jobSrcUrl;
    }

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    public List<String> getJobSrc() {
        return jobSrc;
    }

    public void setJobSrc(List<String> jobSrc) {
        this.jobSrc = jobSrc;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCollectedTime() {
        return collectedTime;
    }

    public void setCollectedTime(String collectedTime) {
        this.collectedTime = collectedTime;
    }
}
