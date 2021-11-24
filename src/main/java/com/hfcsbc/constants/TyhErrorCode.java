package com.hfcsbc.constants;

/**
 * @program: tyh-os
 * @description: 对外SDK之错误码表
 * @author: wangdan
 * @create: 2021-09-24 17:56
 **/
public enum TyhErrorCode {
    SUCCESS(8888, "处理成功"),

    // 代码逻辑异常
    NULL_EXCEPTION(1001, "参数为空"),
    NUMBER_FORMAT_ERROR(1002, "参数类型错误"),
    ACCESS_ID_ERROR(1003, "该access_id无请求权限"),
    FILE_NOT_FOUND(1004, "找不到资源"),
    REQUEST_TOO_QUICK(1005, "请求过于频繁"),
    REQUEST_EXPIRED(1006, "被禁止的IP访问"),
    REQUEST_TIMEOUT(1007, "请求已过期"),
    SIGN_ALGORITHM_ERROR(1008, "签名计算错误"),
    REQUEST_NETWORKS_ERROR(1009, "网络请求错误"),

    // 业务异常
    USER_ALREADY_EXISTS(2001,"用户已存在"),
    USER_NOT_EXISTS(2002, "账号不存在"),
    AUTH_ERROR(2003, "用户权限错误"),
    NO_VALUE_PRESENT(2004,"找不到有效数据"),
    TOO_MANY_REQUESTS(2005, "请求过频繁"),
    FAILED_DELETE(2006,"删除失败"),
    NOT_ALLOW_UPLOAD(2007, "未开启上传"),

    // 没有捕获的异常
    INTERNAL_SERVER(5000, "服务器内部错误");

    private final int code;
    private final String msg;

    TyhErrorCode(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
