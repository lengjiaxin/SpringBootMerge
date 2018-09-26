package www.coolcat.club.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import www.coolcat.club.domain.Role;
import www.coolcat.club.domain.RoleCriteria;

public interface RoleMapper {
    int countByExample(RoleCriteria example);

    int deleteByExample(RoleCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExampleWithRowbounds(RoleCriteria example, RowBounds rowBounds);

    List<Role> selectByExample(RoleCriteria example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleCriteria example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleCriteria example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}