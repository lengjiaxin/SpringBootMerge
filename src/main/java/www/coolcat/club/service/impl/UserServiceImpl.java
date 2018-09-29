package www.coolcat.club.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import www.coolcat.club.dao.UserMapper;
import www.coolcat.club.domain.User;
import www.coolcat.club.domain.UserCriteria;
import www.coolcat.club.service.UserService;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author Lengjx
 * @Date 2018-09-26 17:03
 * @Version 1.0
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String username) {
        UserCriteria example = new UserCriteria();
        UserCriteria.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(username);
        return userMapper.selectByExample(example).get(0);
    }

    @Override
    public PageInfo findItemByPage(int currentPage, int pageSize) {
        UserCriteria userCriteria = new UserCriteria();
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<User> allUsers = userMapper.selectByExample(userCriteria);       //全部用户
        PageInfo<User> pageInfo = new PageInfo<>(allUsers);
        return pageInfo;
    }
}
