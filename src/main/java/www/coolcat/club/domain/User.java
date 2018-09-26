package www.coolcat.club.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.mapping.FetchType;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description 用户实体类
 * @Author Lengjx
 * @Date 2018-09-25 15:15
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class User implements Serializable {
    private Long id;
    private String name;
    private String password;
}