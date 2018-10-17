package www.coolcat.club.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import www.coolcat.club.common.Result;
import www.coolcat.club.common.ResultCodeEnum;
import www.coolcat.club.service.UserService;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @ClassName UserController
 * @Description Shiro用户权限认证
 * @Author Lengjx
 * @Date 2018-09-26 17:14
 * @Version 1.0
 **/
@RestController
public class UserRestController {

    private static Logger log = Logger.getLogger(UserRestController.class);

    @Autowired
    private UserService userService;

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    //paramType 有五个可选值 ： path, query, body, header, form
    @ApiOperation(value="获取用户详细信息", notes="根据url的username来获取用户详细信息")
    @ApiImplicitParam(name = "username", value = "username", required = true, dataType = "String",paramType = "form")
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public Result admin(@RequestParam("username") String username) {
        return new Result().setCode(ResultCodeEnum.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE).setData(userService.getUserByUserName(username));
    }

    @ApiOperation(value="分页获取用户详细信息", notes="根据开始页，每页条数来获取用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "currentPage", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", required = true, dataType = "Integer", paramType = "form")
    })
    @RequestMapping(value = "/findAdminByPage", method = RequestMethod.POST)
    public Result findAdminByPage(@RequestParam("currentPage")  int currentPage,@RequestParam("pageSize")  int pageSize) {
        return new Result().setCode(ResultCodeEnum.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE).setData(userService.findItemByPage(currentPage,pageSize));
    }

 }
