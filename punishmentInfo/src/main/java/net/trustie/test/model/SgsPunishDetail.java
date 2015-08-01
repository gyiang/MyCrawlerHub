package net.trustie.test.model;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;

/**
 * Created by yiang on 2015/3/15.
 */
public class SgsPunishDetail implements AfterExtractor {

    @ExtractBy("//table[@id='punishTable']/tbody/tr[3]/td/text()")
    private String punishFileNo=""; //行政处罚决定书文号

    @ExtractBy("//table[@id='punishTable']/tbody/tr[4]/td/text()")
    private String unitTitle=""; //单位名称

    @ExtractBy("//table[@id='punishTable']/tbody/tr[5]/td/text()")
    private String unitRegNo=""; //单位注册号

    @ExtractBy("//table[@id='punishTable']/tbody/tr[6]/td/text()")
    private String unitPerson=""; //单位法定代表人（负责人）姓名

    @ExtractBy("//table[@id='punishTable']/tbody/tr[7]/td/text()")
    private String actType=""; //违法行为类型

    @ExtractBy("//table[@id='punishTable']/tbody/tr[8]/td/text()")
    private String punishContent=""; //行政处罚内容

    @ExtractBy("//table[@id='punishTable']/tbody/tr[9]/td/text()")
    private String punishOffice=""; //作出行政处罚决定机关名称

    @ExtractBy("//table[@id='punishTable']/tbody/tr[10]/td/text()")
    private String punishDate=""; //作出行政处罚决定日期

    @ExtractBy("//table[@id='punishTable']/tbody/tr[11]/td/a/@href")
    private String punishDocUrl=""; //行政处罚决定书的下载地址url

    @ExtractByUrl()
    private String detailUrl;

    @Override
    public void afterProcess(Page page) {
        // TODO:
    }

    public String getPunishFileNo() {
        return punishFileNo;
    }

    public void setPunishFileNo(String punishFileNo) {
        this.punishFileNo = punishFileNo;
    }

    public String getUnitTitle() {
        return unitTitle;
    }

    public void setUnitTitle(String unitTitle) {
        this.unitTitle = unitTitle;
    }

    public String getUnitRegNo() {
        return unitRegNo;
    }

    public void setUnitRegNo(String unitRegNo) {
        this.unitRegNo = unitRegNo;
    }

    public String getUnitPerson() {
        return unitPerson;
    }

    public void setUnitPerson(String unitPerson) {
        this.unitPerson = unitPerson;
    }

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType;
    }

    public String getPunishOffice() {
        return punishOffice;
    }

    public void setPunishOffice(String punishOffice) {
        this.punishOffice = punishOffice;
    }

    public String getPunishContent() {
        return punishContent;
    }

    public void setPunishContent(String punishContent) {
        this.punishContent = punishContent;
    }

    public String getPunishDate() {
        return punishDate;
    }

    public void setPunishDate(String punishDate) {
        this.punishDate = punishDate;
    }

    public String getPunishDocUrl() {
        return punishDocUrl;
    }

    public void setPunishDocUrl(String punishDocUrl) {
        this.punishDocUrl = punishDocUrl;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }
}
