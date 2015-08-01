package net.trustie.test;

import net.trustie.test.model.SgsPunishDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by yiang on 2015/3/14.
 */
public interface SgsPunishDAO {
    @Insert("insert into sgsPunish " +"(`causeTitle`,`detailUrl`)" + "values (#{causeTitle},#{detailUrl})")
    public int addList(@Param("causeTitle") String causeTitle, @Param("detailUrl") String detailUrl);

    @Select("select detailUrl from sgsPunish where timestamp is null")
    public List<String> getTargetUrls();

    @Update("update sgsPunish set " +
            "`punishFileNo`=#{punishFileNo},`unitTitle`=#{unitTitle},`unitRegNo`=#{unitRegNo}," +
            "`unitPerson`=#{unitPerson},`actType`=#{actType},`punishOffice`=#{punishOffice}," +
            "`punishContent`=#{punishContent},`punishDate`=#{punishDate},`punishDocUrl`=#{punishDocUrl} where detailUrl=#{detailUrl}")
    public int addDeatil(SgsPunishDetail sgsPunishDetail);

    @Update("update sgsPunish set timestamp=#{timestamp} where detailUrl=#{detailUrl}")
    public int setTimestamp(@Param("detailUrl")String detailUrl,@Param("timestamp") String timestamp);

}
