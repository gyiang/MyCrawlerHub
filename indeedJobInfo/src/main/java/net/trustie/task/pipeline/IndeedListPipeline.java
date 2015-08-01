package net.trustie.task.pipeline;

import net.trustie.task.dao.IndeedDao;
import net.trustie.task.model.IndeedList;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by yiang on 2015/4/9.
 */
@Component("IndeedListPipeline")
public class IndeedListPipeline implements PageModelPipeline<IndeedList> {
    private Logger logger=Logger.getLogger(IndeedListPipeline.class);
    @Resource
    private IndeedDao indeedDao;

    @Override
    public void process(IndeedList indeed, Task task) {
        for (int i=0;i<indeed.getCompany().size();i++){
            try {
                // maybe has unexpected
                indeedDao.add(indeed.getTag(),
                        indeed.getJobTitle().get(i),
                        indeed.getCompany().get(i),
                        indeed.getLocation().get(i),
                        indeed.getJobSummary().get(i),
                        indeed.getJobSrc().get(i),
                        indeed.getDate().get(i),
                        indeed.getJobSrcUrl().get(i),
                        indeed.getCollectedTime(),
                        DigestUtils.md5Hex(indeed.getJobSrcUrl().get(i)));
                indeedDao.addUrlInfo(DigestUtils.md5Hex(indeed.getJobSrcUrl().get(i)),
                        indeed.getJobSrcUrl().get(i));
            } catch (Exception e) {
                logger.error(e.toString());
            }



        }
    }
}
