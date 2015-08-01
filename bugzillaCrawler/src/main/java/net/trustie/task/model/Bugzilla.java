package net.trustie.task.model;

import net.trustie.task.utils.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gyiang on 2014/11/6.
 */
//@TargetUrl(value = "https://bugzilla.mozilla.org/show_bug.cgi\\?id=[0-9]+", sourceRegion = "//*[@id='changeform']/div[1]")
public class Bugzilla implements AfterExtractor {
    @ExtractByUrl("[0-9]+")
    private int bugID;
    @ExtractBy("//span[@id='short_desc_nonedit_display']/text()")
    private String summary = "";
    @ExtractBy("//span[@id='static_bug_status']/allText()")
    private String status = "";
    @ExtractBy("//td[@id='bz_show_bug_column_1']/table/tbody/tr[2]/td/text()")
    private String whiteboard = "";
    @ExtractBy("//td[@id='bz_show_bug_column_1']/table/tbody/tr[3]/td/text()")
    private String keywords = "";
    @ExtractBy("//td[@id='field_container_product']/text()")
    private String product = "";
    @ExtractBy("//td[@id='field_container_component']/text()")
    private String component = "";
    @ExtractBy("//td[@id='bz_show_bug_column_1']/table/tbody/tr[8]/td/text()")
    private String version = "";
    @ExtractBy("//td[@id='bz_show_bug_column_1']/table/tbody/tr[9]/td/text()")
    private String platform = "";
    @ExtractBy("//td[@id='bz_show_bug_column_1']/table/tbody/tr[11]/td/text()")
    private String importance = "";
    @ExtractBy("//td[@id='bz_show_bug_column_1']/table/tbody/tr[12]/td/text()")
    private String targetMilestone = "";
    @ExtractBy("//td[@id='bz_show_bug_column_1']/table/tbody/tr[13]/td/span/span/text()")
    private String assignedTo = "";
    @ExtractBy("//td[@id='bz_show_bug_column_1']/table/tbody/tr[14]/td/span/span/text()")
    private String qaContact = "";
    @ExtractBy("//td[@id='bz_show_bug_column_1']/table/tbody/tr[15]/td/allText()")
    private String mentors = "";
    @ExtractBy("//span[@id='bz_url_input_area']/a/text()")
    private String urlAssociated = "";
    @ExtractBy("//td[@id='bz_show_bug_column_1']/table/tbody/tr[19]/td/allText()")
    private String dependsOn = "";
    @ExtractBy("//th[@id='field_label_dependson']/a/text()")
    private  String dependsOnLabel="";
    @ExtractBy("//td[@id='bz_show_bug_column_1']/table/tbody/tr[20]/td/allText()")
    private String blocks = "";
    @ExtractBy("//td[@id='bz_show_bug_column_2']/table/tbody/tr[1]/td/text()")
    private String reportedPST = "";
    @ExtractBy("//td[@id='bz_show_bug_column_2']/table/tbody/tr[2]/td/text()")
    private String modifiedPST = "";
    @ExtractBy("//td[@id='bz_show_bug_column_2']/table/tbody/tr[3]/td/text()")
    private String ccList = "";
    @ExtractBy("//td[@id='field_container_see_also']/allText()")
    private String seeAlso = "";
    @ExtractBy("//td[@id='field_container_cf_crash_signature']/allText()")
    private String crashSignature = "";
    @ExtractBy("//td[@id='field_container_cf_qa_whiteboard']/allText()")
    private String qaWhiteboard = "";
    @ExtractBy("//td[@id='field_container_cf_fx_iteration']/text()")
    private String iteration = "";
    @ExtractBy("//td[@id='field_container_cf_fx_points']/text()")
    private String points = "";
    @ExtractBy("//td[@id='bz_show_bug_column_2']/table/tbody/tr[11]/td[2]/text()")
    private String projectFlags = "";
    @ExtractBy("//td[@id='bz_show_bug_column_2']/table/tbody/tr[12]/td[2]/text()")
    private String trackingFlags = "";
    @ExtractBy("//div[@id='c0']/div/span[2]/span/span/text()")
    private String reportedUser = "";
    @ExtractBy("//div[@id='c0']/div/span[2]/a/@href")
    private String reportedUserUrl="";
    @ExtractBy("//div[@id='c0']/pre/allText()")
    private String description = "";
    private String pageMD5 = "";
    @ExtractByUrl()
    private String url = "";
    private String urlMD5 = "";
    private int history = 0;
    private String crawledTime = "0000-00-00 00:00:00";

    @ExtractBy("//tr[@id='a1']/td[1]")
    private String attachmentsHas = "";
   // @ExtractBy("//table[@id='attachment_table']/html()")
    private String attachmentsHtml = "";

    @ExtractBy("//*[@id='field_label_blocked']/a/text()")
    private String blockedLabel = "";


    @ExtractBy("//form[@id='changeform']/div[1]/span[1]/a/@href/regex('#c([0-9]+)')")
    private String commentsNumTemp;
    private int commentsNum = 0;

    private String pageHtml = "";

    private String commentUser = "";
    private String commentUserUrl="";
    private String commentText = "";
    private String commentPST = "0000-00-00 00:00:00";
    private List<String[]> comments = new ArrayList<String[]>();

    @ExtractBy("//td[@id='bz_show_bug_column_1']/table/tbody/tr[19]/th/label/text()")
    private String duplicatesLabel = "";
    private String duplicates = "";

    private boolean errorPage=false;
    @ExtractBy("//td[@id='error_msg']/text()")
    private String errorLabel="";

    public List<String[]> getComments() {
        return comments;
    }

    public void setComments(List<String[]> comments) {
        this.comments = comments;
    }

    public int getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(int commentsNum) {
        this.commentsNum = commentsNum;
    }

    public int getBugID() {
        return bugID;
    }

    public void setBugID(int bugID) {
        this.bugID = bugID;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWhiteboard() {
        return whiteboard;
    }

    public void setWhiteboard(String whiteboard) {
        this.whiteboard = whiteboard;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public String getTargetMilestone() {
        return targetMilestone;
    }

    public void setTargetMilestone(String targetMilestone) {
        this.targetMilestone = targetMilestone;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getQaContact() {
        return qaContact;
    }

    public void setQaContact(String qaContact) {
        this.qaContact = qaContact;
    }

    public String getMentors() {
        return mentors;
    }

    public void setMentors(String mentors) {
        this.mentors = mentors;
    }

    public String getUrlAssociated() {
        return urlAssociated;
    }

    public void setUrlAssociated(String urlAssociated) {
        this.urlAssociated = urlAssociated;
    }

    public String getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(String dependsOn) {
        this.dependsOn = dependsOn;
    }

    public String getDependsOnLabel() {
        return dependsOnLabel;
    }

    public void setDependsOnLabel(String dependsOnLabel) {
        this.dependsOnLabel = dependsOnLabel;
    }

    public String getBlocks() {
        return blocks;
    }

    public void setBlocks(String blocks) {
        this.blocks = blocks;
    }

    public String getReportedPST() {
        return reportedPST;
    }

    public void setReportedPST(String reportedPST) {
        this.reportedPST = reportedPST;
    }

    public String getProjectFlags() {
        return projectFlags;
    }

    public void setProjectFlags(String projectFlags) {
        this.projectFlags = projectFlags;
    }

    public String getReportedUserUrl() {
        return reportedUserUrl;
    }

    public void setReportedUserUrl(String reportedUserUrl) {
        this.reportedUserUrl = reportedUserUrl;
    }

    public String getBlockedLabel() {
        return blockedLabel;
    }

    public void setBlockedLabel(String blockedLabel) {
        this.blockedLabel = blockedLabel;
    }

    public String getModifiedPST() {
        return modifiedPST;
    }

    public void setModifiedPST(String modifiedPST) {
        this.modifiedPST = modifiedPST;
    }

    public String getCcList() {
        return ccList;
    }

    public void setCcList(String ccList) {
        this.ccList = ccList;
    }

    public String getSeeAlso() {
        return seeAlso;
    }

    public void setSeeAlso(String seeAlso) {
        this.seeAlso = seeAlso;
    }

    public String getCrashSignature() {
        return crashSignature;
    }

    public void setCrashSignature(String crashSignature) {
        this.crashSignature = crashSignature;
    }

    public String getQaWhiteboard() {
        return qaWhiteboard;
    }

    public void setQaWhiteboard(String qaWhiteboard) {
        this.qaWhiteboard = qaWhiteboard;
    }

    public String getIteration() {
        return iteration;
    }

    public void setIteration(String iteration) {
        this.iteration = iteration;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getTrackingFlags() {
        return trackingFlags;
    }

    public void setTrackingFlags(String trackingFlags) {
        this.trackingFlags = trackingFlags;
    }

    public String getReportedUser() {
        return reportedUser;
    }

    public void setReportedUser(String reportedUser) {
        this.reportedUser = reportedUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPageMD5() {
        return pageMD5;
    }

    public void setPageMD5(String pageMD5) {
        this.pageMD5 = pageMD5;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlMD5() {
        return urlMD5;
    }

    public void setUrlMD5(String urlMD5) {
        this.urlMD5 = urlMD5;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public String getCrawledTime() {
        return crawledTime;
    }

    public void setCrawledTime(String crawledTime) {
        this.crawledTime = crawledTime;
    }

    public String getAttachmentsHtml() {
        return attachmentsHtml;
    }

    public void setAttachmentsHtml(String attachmentsHtml) {
        this.attachmentsHtml = attachmentsHtml;
    }

    public String getAttachmentsHas() {
        return attachmentsHas;
    }

    public void setAttachmentsHas(String attachmentsHas) {
        this.attachmentsHas = attachmentsHas;
    }

    public String getPageHtml() {
        return pageHtml;
    }

    public void setPageHtml(String pageHtml) {
        this.pageHtml = pageHtml;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }

    public String getCommentUserUrl() {
        return commentUserUrl;
    }

    public void setCommentUserUrl(String commentUserUrl) {
        this.commentUserUrl = commentUserUrl;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentPST() {
        return commentPST;
    }

    public void setCommentPST(String commentPST) {
        this.commentPST = commentPST;
    }

    public String getCommentsNumTemp() {
        return commentsNumTemp;
    }

    public void setCommentsNumTemp(String commentsNumTemp) {
        this.commentsNumTemp = commentsNumTemp;
    }

    public String getDuplicatesLabel() {
        return duplicatesLabel;
    }

    public void setDuplicatesLabel(String duplicatesLabel) {
        this.duplicatesLabel = duplicatesLabel;
    }

    public String getDuplicates() {
        return duplicates;
    }

    public void setDuplicates(String duplicates) {
        this.duplicates = duplicates;
    }

    public boolean isErrorPage() {
        return errorPage;
    }

    public void setErrorPage(boolean errorPage) {
        this.errorPage = errorPage;
    }

    public void afterProcess(Page page) {
        if (!errorLabel.equals("")) {
            errorPage = true;
            return;
        } else {
        }
        // 多抽取了" () ",注意数据库的坑
        this.component=this.component.substring(0,component.length()-" () ".length()).trim();

        this.urlMD5 = DigestUtils.md5Hex(this.url);
        this.pageMD5 = DigestUtils.md5Hex(url + modifiedPST);
        this.pageHtml = page.getHtml().get();

        this.reportedPST = reportedPST.trim().substring(0, "0000-00-00 00:00 PPP".length());
        this.modifiedPST = modifiedPST.trim().substring(0, "0000-00-00 00:00 PPP".length());

        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.crawledTime = bartDateFormat.format(new Date());

        this.ccList = StringUtils.getNumber(ccList);
        
        if (blockedLabel.equals("Blocks:")) {
            this.blockedLabel = page.getHtml().xpath("//td[@id='bz_show_bug_column_1']/table/tbody/tr[21]/td/text()").get();
        } else {
        }

        if (duplicatesLabel.equals("Duplicates")) {
            this.duplicates = page.getHtml().xpath("//*[@id='duplicates']/allText()").get();
            this.dependsOn=page.getHtml().xpath("//td[@id='bz_show_bug_column_1']/table/tbody/tr[20]/td/text()").get();
            this.blocks=page.getHtml().xpath("//td[@id='bz_show_bug_column_1']/table/tbody/tr[21]/td/text()").get();
        } else {
        }

        if (!attachmentsHas.equals("")) {
            attachmentsHtml = page.getHtml().xpath("//table[@id='attachment_table']/html()").get();
        } else {
        }

        // System.err.println("commentsNumTemp:#"+commentsNumTemp);
        commentsNum = Integer.parseInt(StringUtils.getNumber(commentsNumTemp));
        String[] tempComment = new String[4];
        for (int i = 1; i <= commentsNum; i++) {
            // System.err.println("bugid:"+bugID+" bugCommentNum:"+commentsNum+" i:"+i);
            //user
            try {
                tempComment = new String[4];
                tempComment[0] = page.getHtml().xpath("//div[@id='c" + i + "']/div/span[2]/span/span/text()").get();
                //pst
                tempComment[1] = page.getHtml().xpath("//div[@id='c" + i + "']/div/span[4]/text()").get().trim().substring(0, "0000-00-00 00:00:00 DDD".length());
                //desc
                tempComment[2] = page.getHtml().xpath("//div[@id='c" + i + "']/pre/allText()").get();
                //user_url
                tempComment[3] = page.getHtml().xpath("//div[@id='c" + i + "']/div/span[2]/a/@href").get();
                comments.add(tempComment);
            } catch (Exception e) {
                // 抛异常会导致这个bug不能入库，如35,39
                Logger logger= Logger.getLogger(Bugzilla.class);
                logger.error(e.toString());
            }
        }
    }
}
