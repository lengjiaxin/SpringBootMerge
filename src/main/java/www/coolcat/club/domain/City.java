package www.coolcat.club.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/***
   *@autohr Lengjx
   *@Description 城市实体类 
   *@Date 2018-09-21 16:28 
   *@Param 
   *@return  
**/
@Getter
@Setter
@ToString
public class City implements Serializable {

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;
}
