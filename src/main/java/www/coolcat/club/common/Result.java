package www.coolcat.club.common;

import org.springframework.stereotype.Component;

/***
   *@autohr Lengjx
   *@Description  接口返回对象
   *@Date 2018-09-27 14:50
   *@Param
   *@return
**/
@Component
public class Result<T>  {
    private ResultCodeEnum code;
    private String message;
    private  T data;
    
    public ResultCodeEnum getCode() {
        return code;
    }

    public Result() {
    }

    public Result setCode(ResultCodeEnum resultCode) {
        this.code = resultCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }
}

