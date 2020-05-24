package cn.springcloud.book.util.result;

/**
 * 操作请求的返回码
 * <p>区别于HttpStatus的状态码
 * <p>返回码与操作的业务相关
 * <br>
 * 说明：0为正常返回码,-1为阻塞
 * <br>
 * 1001 ~ 1999 为访问状态相关（访问过于频繁、）
 * <br>
 * 4001 ~ 4999 为数据/参数有效性相关 （不合法的参数、不合法的URL长度 、不合法的请求格式等）
 * <br>
 * 5001 ~ 5999 为认证/授权相关 （用户未授权该api、用户受限）
 * <br>
 * 9001 ~ 9999 为内部服务器相关（系统出现异常、访问出现未知错误）
 *
 * @author ryuu.kk
 */
public enum ReturnCode {

    // 返回码:OK请求成功
    OK(0, "OK"),
    // 系统忙,阻塞
    BLOCK(-1, "BLOCK"),

    // 验证失败：重复操作
    VALIDATION_REPETITION_OPERATION(4101, "Validation Failure: Repeat Operation"),

    // 验证失败：名称重复
    VALIDATION_REPETITIVE_NAME(4104, "Validation Failure: Repetitive Name"),

    // 访问的资源为空
    ACCESS_RESOURCE_EMPTY(4401, "Access Resource Empty"),

    // 访问资源不存在
    ACCESS_RESOURCE_NOT_FOUND(4402, "Access Resource Not Found"),

    // 访问资源已存在
    ACCESS_RESOURCE_ALREADY_EXISTED(4403, "Access Resource Already Existed"),

    // 错误的访问请求
    BAD_REQUEST_ERROR(4410, "Bad Request"),

    // 错误的访问请求参数
    BAD_REQUEST_PARAMS_ERROR(4411, "Bad Request Parameters"),

    // 访问过于频繁
    ACCESS_TOO_FREQUENT(1001, "Access Too Frequent"),

    // 认证失败
    AUTHORIZATION_FAILURE(5001, "Authorization Failure"),

    // 未授权API
    UNAUTHORIZED_API(5002, "Unauthorized API"),

    // 未授权的数据访问
    UNAUTHORIZED_ACCESS_DATA(5003, "Unauthorized Access Data"),

    // 内部服务器出现异常
    INTERNAL_SERVER_ERROR(9000, "Internal Server Error "),

    // 内部服务器出现运行时异常: RuntimeException及继承类
    INTERNAL_RUNTIME_EXCEPTION(9001, "Internal Server Runtime Exception");

    // 返回码
    private final int value;
    // 返回码的短语形式
    private final String reasonPhrase;

    ReturnCode(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int getValue() {
        return value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

}
