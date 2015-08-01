package net.trustie.task.pipeline;


import net.trustie.task.dao.BugsActivityDAO;
import net.trustie.task.model.BugsActivity;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by gyiang on 2014/8/30.
 */
@Component("FireFoxBugsActivityDAOPipeline")
public class BugsActivityPipeline implements PageModelPipeline<BugsActivity> {
    @Resource
    private BugsActivityDAO fireFoxBugsActivityDAO;


    public void process(BugsActivity fireFoxBugsActivity, Task task) {
        // 1st
        for (BugsActivity f : fireFoxBugsActivity.getFireFoxBugsActivities()) {
            if (f.getWho()!=null && f.getWhat()!=null && f.getWhen()!=null){
                fireFoxBugsActivityDAO.add(f);
            }
        }

        // 2nd
     /*   if(fireFoxBugsDAO.find(fireFoxBugs)==0) {
            fireFoxBugsDAO.add(fireFoxBugs);
            fireFoxBugsDAO.addHtml(fireFoxBugs);
            fireFoxBugsDAO.update(fireFoxBugs);
        }*/

    }


}
