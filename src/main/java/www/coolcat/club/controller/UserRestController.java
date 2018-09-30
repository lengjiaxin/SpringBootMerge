package www.coolcat.club.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import www.coolcat.club.common.Result;
import www.coolcat.club.common.ResultCodeEnum;
import www.coolcat.club.service.UserService;

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

    @ApiOperation(value="zip文件下载", notes="默认目录zip文件夹下载")
    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public String downloadFile(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        // 获取指定目录下的第一个文件
        File scFileDir = new File("E://music_eg");
        File TrxFiles[] = scFileDir.listFiles();
        String fileName = TrxFiles[0].getName(); //下载的文件名
        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            //设置文件路径
            String realPath = "E://music_eg/";
            File file = new File(realPath, fileName);
            // 如果文件名存在，则进行下载
            if (file.exists()) {
                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("Download the song successfully!");
                }
                catch (Exception e) {
                    System.out.println("Download the song failed!");
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
 }
