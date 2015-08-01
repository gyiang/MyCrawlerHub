package net.trustie.test.pipeline;

import net.trustie.test.SgsPunishDAO;
import net.trustie.test.model.SgsPunishDetail;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by yiang on 2015/3/15.
 */
@Component("SgsPunishDetailPipeline")
public class SgsPunishDetailPipeline implements PageModelPipeline<SgsPunishDetail> {
    private Logger logger = Logger.getLogger(SgsPunishDetailPipeline.class);
    @Resource
    private SgsPunishDAO sgsPunishDAO;

    @Override
    public void process(SgsPunishDetail sgsPunishDetail, Task task) {
        try {
            sgsPunishDAO.addDeatil(sgsPunishDetail);
            sgsPunishDAO.setTimestamp(sgsPunishDetail.getDetailUrl(), System.currentTimeMillis() / 1000 + "");
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }
}
