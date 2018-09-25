package www.coolcat.club.service;
import www.coolcat.club.domain.City;

/***
   *@autohr Lengjx
   *@Description  城市业务逻辑接口类
   *@Date 2018-09-21 16:28
   *@Param
   *@return
**/
public interface CityService {

    default public String Name(){
        return "THIS IS LENGJIAXIN";
    }
    /**
     * 根据城市 ID,查询城市信息
     *
     * @param id
     * @return
     */
    City findCityById(Long id);

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    Long saveCity(City city);

    /**
     * 更新城市信息
     *
     * @param city
     * @return
     */
    Long updateCity(City city);

    /**
     * 根据城市 ID,删除城市信息
     *
     * @param id
     * @return
     */
    Long deleteCity(Long id);
}
