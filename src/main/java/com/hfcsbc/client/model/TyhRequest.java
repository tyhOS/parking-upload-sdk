package com.hfcsbc.client.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import org.bouncycastle.util.encoders.Base64;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;

/**
 * @program: tyh-os
 * @description: 请求标准封装
 * @author: wangdan
 * @create: 2021-09-23 16:11
 **/
@Data
@Builder
public class TyhRequest {
    @JSONField(name = "access_id")
    private String accessId;

    @JSONField(name = "sign_type")
    private String signType;

    @JSONField(name = "time_stamp")
    private Long timeStamp;

    private String sign;

    private String data;

    /**
     * 解析出来对应的数据
     * @param tyhRequest
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T decode(TyhRequest tyhRequest, Class<T> clazz) {
        byte[] date = Base64.decode(tyhRequest.getData().getBytes(StandardCharsets.UTF_8));
        return JSON.parseObject(new String(date), clazz);
    }

    /**
     * 判断是否签名，暂时未实现
     * @param tyhRequest
     * @return
     */
    public static boolean isSign(TyhRequest tyhRequest) {
        return true;
    }
}
