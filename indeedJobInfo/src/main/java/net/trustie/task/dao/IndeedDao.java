package net.trustie.task.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by yiang on 2015/4/9.
 */
public interface IndeedDao {

    @Insert("insert into indeed " +"(`tag`,`jobTitle`,`company`,`location`,`jobSummary`,`jobSrc`,`date`,`jobSrcUrl`,`collectedTime`,`urlMd5`)"
            + " values (#{tag},#{jobTitle},#{company},#{location},#{jobSummary},#{jobSrc},#{date},#{jobSrcUrl},#{collectedTime},#{urlMd5})")
    public int add(@Param("tag") String tag,
                       @Param("jobTitle") String jobTitle,
                       @Param("company") String company,
                       @Param("location") String location,
                       @Param("jobSummary") String jobSummary,
                       @Param("jobSrc") String jobSrc,
                       @Param("date") String date,
                       @Param("jobSrcUrl") String jobSrcUrl,
                       @Param("collectedTime") String collectedTime,
                       @Param("urlMd5") String urlMd5);
    @Insert("insert ignore into indeed_html " +"(`urlMd5`,`url`)"+" values (#{urlMd5},#{url})")
    public int addUrlInfo( @Param("urlMd5") String urlMd5, @Param("url") String url);

    @Select("select tag from indeed_tag where timestamp is null limit 0,1")
    public String getTags();


    @Update("update indeed_tag set timestamp=UNIX_TIMESTAMP() where tag=#{tag}")
    public int setTimestamp(@Param("tag") String tag);

    @Select("select url from indeed_html where html is null limit 0,1000")
    public List<String> getTargetUrls();

    @Update("update indeed_html set html=#{html},timestamp=UNIX_TIMESTAMP() where urlMd5=#{urlMd5}")
    public int updateHtml(@Param("html") String html,@Param("urlMd5")String urlMd5);

    @Select("select num from indeed_tag where tag=#{tag}")
    public int getTagNum(@Param("tag") String tag);

}
