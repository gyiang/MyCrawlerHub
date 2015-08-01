package net.trustie.task.pipeline;

import net.trustie.task.dao.BugzillaDAO;
import net.trustie.task.model.Bugzilla;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by yiang on 2014/11/6.
 */
@Component("BugzillaDaoPipeline")
public class BugzillaPipeline implements PageModelPipeline<Bugzilla> {

    Logger logger = Logger.getLogger(BugzillaPipeline.class);
    @Resource
    private BugzillaDAO bugzillaDAO;

    public void process(Bugzilla bugzilla, Task task) {

        if (bugzilla.isErrorPage())
        {
            return;
        }
        String[] t;
        bugzillaDAO.addInfo(bugzilla);
        for (int i = 0; i < bugzilla.getCommentsNum(); i++) {
            t=bugzilla.getComments().get(i);
            bugzilla.setCommentUser(t[0]);
            bugzilla.setCommentPST(t[1]);
            bugzilla.setCommentText(t[2]);
            bugzilla.setCommentUserUrl(t[3]);
            bugzillaDAO.addComment(bugzilla);
        }
        if (!bugzilla.getAttachmentsHtml().contentEquals("")){
            bugzillaDAO.addAttachment(bugzilla);
        }
        bugzillaDAO.addHtml(bugzilla);
    }
}
