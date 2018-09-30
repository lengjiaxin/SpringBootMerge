package www.coolcat.club.common;

/**
 * @ClassName ResultCodeEnum
 * @Description 状态码
 * @Author Lengjx
 * @Date 2018-09-29 16:28
 * @Version 1.0
 **/
public enum ResultCodeEnum {
    SUCCESS(200),//成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500);//服务器内部错误

    public int code;

    ResultCodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
 }
