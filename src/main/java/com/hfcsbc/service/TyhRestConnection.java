package com.hfcsbc.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.hfcsbc.client.dto.trade.TradePayDto;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.client.model.TyhRequest;
import com.hfcsbc.constants.Options;
import com.hfcsbc.constants.TyhErrorCode;
import com.hfcsbc.constants.TyhException;
import com.hfcsbc.utils.ConnectionFactory;
import com.hfcsbc.utils.RSA2Utils;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.PrivateKey;


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
        Request executeRequest = new Request.Builder().url(requestUrl).post(RequestBody.create(JSON_TYPE, JSON.toJSONString(tyhRequest)))
                .addHeader("Content-Type", "application/json").build();

        String resp = ConnectionFactory.execute(executeRequest);
        return checkAndGetResponse(resp, tClass);
    }


    private <T> Results<T> checkAndGetResponse(String resp, Class<T> tClass) {
        JSONObject json = JSON.parseObject(resp);
        try {
            if (json.containsKey("code")) {
                Integer code = json.getInteger("code");
                if (!code.equals(TyhErrorCode.SUCCESS.getCode())) {
                    String msg = json.getString("msg");
                    throw new TyhException(TyhErrorCode.INTERNAL_SERVER.getCode(), "[Executing] " + code + ": " + msg);
                }
            } else {
                throw new TyhException(TyhErrorCode.INTERNAL_SERVER.getCode(), "[ERROR] Response code cannot be found in response.");
            }
        } catch (Exception e) {
            throw new TyhException(TyhErrorCode.INTERNAL_SERVER.getCode(), "[ERROR] Unexpected error: " + e.getMessage());
        }
        return new Results<>(json.getInteger("code"), json.getString("msg"), json.getObject("data", tClass), json.get("error"));
    }

    public TyhRequest obtainSignRequestParam(TyhRequest tyhRequest) throws Exception {
        Options options = this.getOptions();

        String content = tyhRequest.getAccessId() + tyhRequest.getData()
                + tyhRequest.getSignType() + tyhRequest.getTimeStamp();
        tyhRequest.setSign(RSA2Utils.doSign(content, "utf-8", privateKey));
        return tyhRequest;
    }

}
