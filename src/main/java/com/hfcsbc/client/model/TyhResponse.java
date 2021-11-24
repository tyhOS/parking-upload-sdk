package com.hfcsbc.client.model;

import com.alibaba.fastjson.JSON;
import com.hfcsbc.constants.TyhErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: tyh-os
 * @description: 响应标准封装
 * @author: wangdan
 * @create: 2021-09-23 16:11
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TyhResponse {
    private Integer code;
    private String msg;
    private String data;

    public boolean ifSuccess() {
        return  code != null && code.equals(TyhErrorCode.SUCCESS.getCode());
    }

    public static TyhResponse FAIL(TyhErrorCode errorCode) {
        return TyhResponse.builder()
                .code(errorCode.getCode())
                .msg(errorCode.getMsg())
                .build();
    }

    public static TyhResponse SUCCESS() {
        return TyhResponse.builder()
                .code(TyhErrorCode.SUCCESS.getCode())
                .msg(TyhErrorCode.SUCCESS.getMsg())
                .build();
    }

    public static TyhResponse SUCCESS(Object obj) {
        return TyhResponse.builder()
                .code(TyhErrorCode.SUCCESS.getCode())
                .msg(TyhErrorCode.SUCCESS.getMsg())
                .data(JSON.toJSONString(obj))
                .build();
    }

}
