package net.trustie.task.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gan on 2014/11/24.
 */
public class BugsActivity implements AfterExtractor {
    @ExtractByUrl("id=([0-9]+)")
    private String bugId;
    private String who;
    private String when;
    private String what;
    private String removed;
    private String added;
    private String crawledTime;
    private String html;
    private String url;

    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getRemoved() {
        return removed;
    }

    public void setRemoved(String removed) {
        this.removed = removed;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }


    public String getCrawledTime() {
        return crawledTime;
    }

    public void setCrawledTime(String crawledTime) {
        this.crawledTime = crawledTime;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }


    private List<BugsActivity> fireFoxBugsActivities = new ArrayList<BugsActivity>();

    public List<BugsActivity> getFireFoxBugsActivities() {
        return fireFoxBugsActivities;
    }

    public void setFireFoxBugsActivities(List<BugsActivity> fireFoxBugsActivities) {
        this.fireFoxBugsActivities = fireFoxBugsActivities;
    }

    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    public void afterProcess(Page page) {
        this.html = page.getHtml().toString();
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.crawledTime = bartDateFormat.format(new Date());

        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByTag("tr");

        BugsActivity fireFoxBugsActivity;
        //对每个tr进行处理
        for (Element element : elements) {
            // 没个tr下有td，分为5个td和3个td
            Elements es = element.getElementsByTag("td");
            if (es.size() == 5) {
                this.who = es.get(0).text().trim();
                this.when = es.get(1).text().trim();
                this.what = es.get(2).text().trim();
                this.removed = es.get(3).text().trim();
                this.added = es.get(4).text().trim();
            }else if (es.size() == 3) {
                this.what = es.get(0).text().trim();
                this.removed = es.get(1).text().trim();
                this.added = es.get(2).text().trim();
            }
            // 封装一条
            fireFoxBugsActivity=new BugsActivity();
            fireFoxBugsActivity.setBugId(this.bugId);
            fireFoxBugsActivity.setWho(this.who);
            fireFoxBugsActivity.setWhen(this.when);
            fireFoxBugsActivity.setWhat(this.what);
            fireFoxBugsActivity.setRemoved(this.removed);
            fireFoxBugsActivity.setAdded(this.added);
            fireFoxBugsActivity.setCrawledTime(this.crawledTime);
            fireFoxBugsActivity.setHtml(this.html);
            fireFoxBugsActivities.add(fireFoxBugsActivity);
        }
        SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        this.timestamp = timestampFormat.format(new Date());
    }
}
