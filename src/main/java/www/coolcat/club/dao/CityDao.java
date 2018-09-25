package www.coolcat.club.dao;

import org.apache.ibatis.annotations.Param;
import www.coolcat.club.domain.City;

import java.util.List;
/***
   *@autohr Lengjx
   *@Description  城市 DAO 接口类
   *@Date 2018-09-21 16:28
   *@Param
   *@return
**/
public interface CityDao {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
