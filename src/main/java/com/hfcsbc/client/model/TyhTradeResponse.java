package com.hfcsbc.client.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 交易相关响应标准封装
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TyhTradeResponse {

    private Integer code;
    private String msg;
    private Object data;

    public static <T> TyhTradeResponse build(TyhResponse response) {
        return TyhTradeResponse.builder()
                .code(response.getCode())
                .msg(response.getMsg())
                .data(response.getData())
                .build();
    }

    public static <T> TyhTradeResponse build(TyhResponse response, Class<T> tClass) {
        Object data = tClass == null ? response.getData() : JSON.parseObject(response.getData(), tClass);
        return TyhTradeResponse.builder()
                .code(response.getCode())
                .msg(response.getMsg())
                .data(data)
                .build();
    }

}
