package net.trustie.task.dao;


import net.trustie.task.model.Bugzilla;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by gyiang on 2014/11/6.
 */
public interface BugzillaDAO {
    @Insert("insert into bugzilla_info " +
            "(`bugID`,`summary`,`status`,`whiteboard`,`keywords`,`product`,`component`,`version`,`platform`,`importance`,`targetMilestone`,`assignedTo`,`qaContact`,`mentors`,`urlAssociated`,`duplicates`,`dependsOn`,`blocks`,`reportedPT`,`modifiedPT`,`ccList`,`seeAlso`,`crashSignature`,`qaWhiteboard`,`iteration`,`points`,`trackingFlags`,`projectFlags`,`reportedUser`,`reportedUserUrl`,`description`,`pageMD5`,`url`,`urlMD5`,`history`,`crawledTime`)" +
            " values (#{bugID},#{summary},#{status},#{whiteboard},#{keywords},#{product},#{component},#{version},#{platform},#{importance},#{targetMilestone},#{assignedTo},#{qaContact},#{mentors},#{urlAssociated},#{duplicates},#{dependsOn},#{blocks},#{reportedPST},#{modifiedPST},#{ccList},#{seeAlso},#{crashSignature},#{qaWhiteboard},#{iteration},#{points},#{trackingFlags},#{projectFlags},#{reportedUser},#{reportedUserUrl},#{description},#{pageMD5},#{url},#{urlMD5},#{history},#{crawledTime})")
    public int addInfo(Bugzilla bugzilla);

    @Insert("insert into bugzilla_comments " +
        "(`bugID`,`commentUser`,`commentUserUrl`,`commentText`,`commentPT`) " +
        "values (#{bugID},#{commentUser},#{commentUserUrl},#{commentText},#{commentPST})")
    public int addComment(Bugzilla bugzilla);

    @Insert("insert into bugzilla_html " +
            "(`bugID`,`pageMD5`,`pageHTML`) " +
            "values (#{bugID},#{pageMD5},#{pageHtml})")
    public int addHtml(Bugzilla bugzilla);

    @Insert("insert into bugzilla_attachments " +
            "(`bugID`,`html`) " +
            "values (#{bugID},#{attachmentsHtml})")
    public int addAttachment(Bugzilla bugzilla);

}
