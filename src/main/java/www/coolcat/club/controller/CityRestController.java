package www.coolcat.club.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import www.coolcat.club.domain.City;
import www.coolcat.club.service.CityService;

@RestController
public class CityRestController {

    private static Logger log = Logger.getLogger(CityRestController.class);

    @Autowired
    private CityService cityService;

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @RequestMapping(value = "/api/findCityById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  City  findOneCity(@PathVariable("id") Long id){
        log.info("请求数据信息成功！");
        return cityService.findCityById(id);
    }

}
