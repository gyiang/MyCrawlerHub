package net.trustie.task.model;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;

/**
 * Created by yiang on 2015/4/9.
 */
public class IndeedDetail  implements AfterExtractor {
    private String html;
    @ExtractByUrl()
    private String urlTrue;
    @Override
    public void afterProcess(Page page) {
        this.html=page.getRawText();
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getUrlTrue() {
        return urlTrue;
    }

    public void setUrlTrue(String urlTrue) {
        this.urlTrue = urlTrue;
    }
}
