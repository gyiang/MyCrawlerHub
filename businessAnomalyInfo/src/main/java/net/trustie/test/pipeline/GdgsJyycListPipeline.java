package net.trustie.test.pipeline;

import net.trustie.test.GdgsJyycDAO;
import net.trustie.test.model.GdgsJyycList;
import net.trustie.test.model.JyycList;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by yiang on 2015/3/19.
 */
@Component("GdgsJyycListPipeline")
public class GdgsJyycListPipeline implements PageModelPipeline<GdgsJyycList> {
    private Logger logger = Logger.getLogger(GdgsJyycListPipeline.class);
    @Resource
    private GdgsJyycDAO gdgsJyycDAO;

    @Override
    public void process(GdgsJyycList sgsPunish, Task task) {
        for (JyycList j : sgsPunish.getGdgsJyycLists()) {
            try {
                // maybe has unexpected
                gdgsJyycDAO.addList(j);
            } catch (Exception e) {
                logger.error(e.toString());
            }
        }
    }
}
