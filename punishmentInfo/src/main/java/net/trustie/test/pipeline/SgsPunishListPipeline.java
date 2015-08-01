package net.trustie.test.pipeline;

import net.trustie.test.SgsPunishDAO;
import net.trustie.test.model.SgsPunishList;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by yiang on 2015/3/14.
 */
@Component("SgsPunishListPipeline")
public class SgsPunishListPipeline implements PageModelPipeline<SgsPunishList> {
    private Logger logger=Logger.getLogger(SgsPunishListPipeline.class);
    @Resource
    private SgsPunishDAO sgsPunishDAO;

    @Override
    public void process(SgsPunishList sgsPunish, Task task) {
            for(int i=0;i<sgsPunish.getCauseTitle().size();i++) {
                try {
                    // maybe has unexpected
                    sgsPunishDAO.addList(sgsPunish.getCauseTitle().get(i), sgsPunish.getDetailUrl().get(i));
                } catch (Exception e) {
                    logger.error(e.toString());
                }
            }
    }
}
