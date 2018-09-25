package www.coolcat.club.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.mapping.FetchType;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Role
 * @Description 角色实体类
 * @Author Lengjx
 * @Date 2018-09-25 15:16
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class Role implements Serializable {
    private Long id;
    private String roleName;
    private User user;
}
