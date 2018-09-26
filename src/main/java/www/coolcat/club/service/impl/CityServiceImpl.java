package www.coolcat.club.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import www.coolcat.club.dao.CityDao;
import www.coolcat.club.domain.City;
import www.coolcat.club.service.CityService;

/***
   *@autohr Lengjx
   *@Description 城市业务逻辑实现类
   *@Date 2018-09-21 16:21
   *@Param 
   *@return  
**/
@Service
@Transactional
public class CityServiceImpl implements CityService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);
    @Autowired
    private CityDao cityDao;
    @Autowired
    private RedisServiceImpl redisService;
    /**
     * 获取城市逻辑：
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     */
    public City findCityById(Long id) {
        // 从 DB 中获取城市信息
        String key = "city_" + id;
        boolean hasKey = redisService.exists(key);
        if(hasKey){
            return (City) redisService.get( key );
        }else{
            City city = cityDao.findById(id);
            redisService.set("city_"+id, city);
            return city;

        }
    }

    @Override
    public Long saveCity(City city) {
        return cityDao.saveCity(city);
    }

    /**
     * 更新城市逻辑：
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     */
    @Override
    public Long updateCity(City city) {
        Long ret = cityDao.updateCity(city);

        // 缓存存在，删除缓存
        String key = "city_" + city.getId();
        boolean hasKey = redisService.exists(key);
        if (hasKey) {
            redisService.remove(key);

            LOGGER.info("CityServiceImpl.updateCity() : 从缓存中删除城市 >> " + city.toString());
        }

        return ret;
    }

    @Override
    public Long deleteCity(Long id) {

        Long ret = cityDao.deleteCity(id);

        // 缓存存在，删除缓存
        String key = "city_" + id;
        boolean hasKey = redisService.exists(key);
        if (hasKey) {
            redisService.remove(key);

            LOGGER.info("CityServiceImpl.deleteCity() : 从缓存中删除城市 ID >> " + id);
        }
        return ret;
    }
}
