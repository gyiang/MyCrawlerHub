package net.trustie.test.model;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;

import java.util.HashMap;
import java.util.List;
/**
 * Created by yiang on 2015/3/14.
 */
public class SgsPunishList implements AfterExtractor {

    @ExtractBy("//div[@id='container']/div[2]/table/tbody/tr/td[2]/text()")
    private List<String> causeTitle; //案件名称
    @ExtractBy("//div[@id='container']/div[2]/table/tbody/tr/td[3]/a/@href")
    private List<String> detailUrl;  //详情页

    @Override
    public void afterProcess(Page page) {

    }
    public List<String> getCauseTitle() {
        return causeTitle;
    }

    public void setCauseTitle(List<String> causeTitle) {
        this.causeTitle = causeTitle;
    }

    public List<String> getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(List<String> detailUrl) {
        this.detailUrl = detailUrl;
    }

}
