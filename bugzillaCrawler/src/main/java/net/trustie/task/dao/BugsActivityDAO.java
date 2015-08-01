package net.trustie.task.dao;


import net.trustie.task.model.BugsActivity;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by gyiang on 2014/8/30.
 */
public interface BugsActivityDAO {

    @Insert("insert into firefox_bugs_activity " +
            "(`bugId`,`who`,`when`,`what`,`removed`,`added`,`crawledTime`) " +
            "values (#{bugId},#{who},#{when},#{what},#{removed},#{added},#{crawledTime})")
    public int add(BugsActivity fireFoxBugsActivity);

    @Insert("insert into firefox_bugs_activity_html (`bugId`,`html`) " +"values (#{bugId},#{html})")
    public int addHtml(BugsActivity fireFoxBugsActivity);
}
