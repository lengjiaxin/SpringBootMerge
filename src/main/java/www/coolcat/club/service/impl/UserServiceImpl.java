package www.coolcat.club.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import www.coolcat.club.dao.UserMapper;
import www.coolcat.club.domain.User;
import www.coolcat.club.domain.UserCriteria;
import www.coolcat.club.service.UserService;

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
}
