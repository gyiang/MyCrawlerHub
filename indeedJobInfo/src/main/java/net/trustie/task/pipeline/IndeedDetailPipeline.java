package net.trustie.task.pipeline;

import net.trustie.task.dao.IndeedDao;
import net.trustie.task.model.IndeedDetail;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by yiang on 2015/4/9.
 */
@Component("IndeedDetailPipeline")
public class IndeedDetailPipeline implements PageModelPipeline<IndeedDetail> {
    private Logger logger=Logger.getLogger(IndeedDetailPipeline.class);
    @Resource
    private IndeedDao indeedDao;
    @Override
    public void process(IndeedDetail indeedDetail, Task task) {

        indeedDao.updateHtml(indeedDetail.getHtml(), DigestUtils.md5Hex(indeedDetail.getUrlTrue()));

    }
}
