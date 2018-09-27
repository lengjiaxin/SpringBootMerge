package www.coolcat.club.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import www.coolcat.club.domain.User;
import www.coolcat.club.service.UserService;

/**
 * @ClassName UserController
 * @Description Shiro用户权限认证
 * @Author Lengjx
 * @Date 2018-09-26 17:14
 * @Version 1.0
 **/
@RestController
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String index() {
        return "index";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的username来获取用户详细信息")
    @RequestMapping(value = "/admin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User admin(@PathVariable("username") String username) {
        return userService.getUserByUserName(username);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String doLogin(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:admin";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String home() {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.checkPermission("admin");
        } catch (UnauthorizedException exception) {
            System.out.println("没有足够的权限");
        }
        return "home";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String logout() {
        return "index";
    }
 }
