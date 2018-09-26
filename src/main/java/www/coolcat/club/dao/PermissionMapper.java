package www.coolcat.club.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import www.coolcat.club.domain.Permission;
import www.coolcat.club.domain.PermissionCriteria;

public interface PermissionMapper {
    int countByExample(PermissionCriteria example);

    int deleteByExample(PermissionCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExampleWithRowbounds(PermissionCriteria example, RowBounds rowBounds);

    List<Permission> selectByExample(PermissionCriteria example);

    Permission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionCriteria example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionCriteria example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}