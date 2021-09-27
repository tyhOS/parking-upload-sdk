package com.hfcsbc.constants;

import lombok.Getter;

/**
 * @program: upload-client
 * @description: 停宜慧异常处理类
 * @author: wangdan
 * @create: 2021-09-27 10:00
 **/
@Getter
public class TyhException extends RuntimeException {
    public TyhException(Integer code, String description) {
        //异常信息为错误代码+异常信息
        super("错误代码：" + code + "错误信息：" + description);
    }

}
