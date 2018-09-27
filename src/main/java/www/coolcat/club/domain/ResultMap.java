package www.coolcat.club.domain;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/***
   *@autohr Lengjx
   *@Description  接口返回对象
   *@Date 2018-09-27 14:50
   *@Param
   *@return
**/
@Component
public class ResultMap extends HashMap<String, Object> {
    public ResultMap() {
    }

    public ResultMap success() {
        this.put("result", "success");
        return this;
    }

    public ResultMap fail() {
        this.put("result", "fail");
        return this;
    }

    public ResultMap message(Object message) {
        this.put("message", message);
        return this;
    }
}

