package www.coolcat.club.service;

import www.coolcat.club.domain.User;

/**
 * @ClassName UserService
 * @Description 用户业务逻辑接口类
 * @Author Lengjx
 * @Date 2018-09-26 17:01
 * @Version 1.0
 **/
public interface UserService {
    /***
       *@autohr Lengjx
       *@Description 根据用户姓名查询权限
       *@Date 2018-09-26 17:02 
       *@Param [username]
       *@return www.coolcat.club.domain.User 
    **/
    User getUserByUserName(String username);

}
