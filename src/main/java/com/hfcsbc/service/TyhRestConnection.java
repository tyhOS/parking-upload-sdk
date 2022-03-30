package com.hfcsbc.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.client.model.TyhRequest;
import com.hfcsbc.constants.Options;
import com.hfcsbc.utils.ConnectionFactory;
import com.hfcsbc.utils.RSA2Utils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.PrivateKey;

@Slf4j
public class TyhRestConnection {
    private static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    private final Options options;

    private PrivateKey privateKey;

    public Options getOptions() {
        return options;
    }

    public TyhRestConnection(Options options) {
        this.options = options;
        try {
            String host = new URL(this.options.getRestHost()).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            this.privateKey = RSA2Utils.getPrivateKeyFromPKCS8(options.getSecretKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> Results<T> executePostWithSignature(String path, TyhRequest tyhRequest, Class<T> tClass) throws Exception {
        Options options = this.getOptions();
        if (!options.getAllowUpload()) {
            return Results.failure(null, "未开启请求配置");
        }

        String content = tyhRequest.getAccessId() + tyhRequest.getData()
                + tyhRequest.getSignType() + tyhRequest.getTimeStamp();
        tyhRequest.setSign(RSA2Utils.doSign(content, "utf-8", privateKey));

        String requestUrl = options.getRestHost() + path;
        Request executeRequest = new Request.Builder().url(requestUrl).post(RequestBody.create(JSON.toJSONString(tyhRequest), JSON_TYPE))
                .addHeader("Content-Type", "application/json").build();

        String resp = ConnectionFactory.execute(executeRequest);
        Results<T> results = checkAndGetResponse(requestUrl, resp, tClass);

        log.info("[请求地址]：" + requestUrl);
        log.info("[响应参数]" + JSON.toJSONString(results));
        return results;
    }


    private <T> Results<T> checkAndGetResponse(String requestUrl, String resp, Class<T> tClass) {
        JSONObject json = JSON.parseObject(resp);
        if (!json.containsKey("code") || !json.containsKey("data")) {
            return Results.failure();
        }
        return new Results<>(json.getInteger("code"), json.getString("msg"), json.getObject("data", tClass), json.get("error"));
    }

    public TyhRequest obtainSignRequestParam(TyhRequest tyhRequest) throws Exception {
        String content = tyhRequest.getAccessId() + tyhRequest.getData()
                + tyhRequest.getSignType() + tyhRequest.getTimeStamp();
        tyhRequest.setSign(RSA2Utils.doSign(content, "utf-8", privateKey));
        return tyhRequest;
    }

}
