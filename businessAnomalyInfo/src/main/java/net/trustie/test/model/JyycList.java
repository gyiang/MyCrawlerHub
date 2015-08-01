package net.trustie.test.model;

import us.codecraft.webmagic.selector.Html;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by yiang on 2015/3/19.
 */
public class JyycList {
    private String abnTime;
    private String auditingFileNo;
    private String entName;
    private String entNameUrl;
    private String regNO;

    private String decOrg;
    private String entNo;
    private String entType;
    private String speCause;
    private String unuAbnId;

    public String getAbnTime() {
        return abnTime;
    }

    public void setAbnTime(String abnTime) {
        // 时间格式转换 Mar 13, 2015 12:00:00 AM -》2015-03-13
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa", Locale.ENGLISH);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.abnTime= sdf.format(formatter.parse(abnTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getEntNameUrl() {
        return entNameUrl;
    }

    public void setEntNameUrl(String entNameUrl) {
        // 提取链接
        this.entNameUrl ="http://gsxt.gdgs.gov.cn/"+Html.create(entNameUrl).links().get();
    }

    public String getAuditingFileNo() {
        return auditingFileNo;
    }

    public void setAuditingFileNo(String auditingFileNo) {
        this.auditingFileNo = auditingFileNo;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getRegNO() {
        return regNO;
    }

    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }


    public String getDecOrg() {
        return decOrg;
    }

    public void setDecOrg(String decOrg) {
        this.decOrg = decOrg;
    }

    public String getEntNo() {
        return entNo;
    }

    public void setEntNo(String entNo) {
        this.entNo = entNo;
    }

    public String getEntType() {
        return entType;
    }

    public void setEntType(String entType) {
        this.entType = entType;
    }

    public String getSpeCause() {
        return speCause;
    }

    public void setSpeCause(String speCause) {
        this.speCause = speCause;
    }

    public String getUnuAbnId() {
        return unuAbnId;
    }

    public void setUnuAbnId(String unuAbnId) {
        this.unuAbnId = unuAbnId;
    }
}
