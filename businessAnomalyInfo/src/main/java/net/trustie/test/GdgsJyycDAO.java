package net.trustie.test;

import net.trustie.test.model.JyycList;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by yiang on 2015/3/19.
 */
public interface GdgsJyycDAO {

    @Insert("insert into GdgsJyyc " +"(`entName`,`entNameUrl`,`regNO`,`auditingFileNo`,`abnTime`,`decOrg`,`entNo`,`entType`,`speCause`,`unuAbnId`)"
            + "values (#{entName},#{entNameUrl},#{regNO},#{auditingFileNo},#{abnTime},#{decOrg},#{entNo},#{entType},#{speCause},#{unuAbnId})")
    public int addList(JyycList jyycList);

}
