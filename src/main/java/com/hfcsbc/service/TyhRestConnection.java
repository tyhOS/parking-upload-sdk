package com.hfcsbc.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.PrivateKey;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hfcsbc.client.model.TyhRequest;
import com.hfcsbc.client.model.TyhResponse;
import com.hfcsbc.constants.Options;
import com.hfcsbc.constants.TyhErrorCode;
import com.hfcsbc.constants.TyhException;
import com.hfcsbc.utils.ConnectionFactory;
import com.hfcsbc.utils.RSA2Utils;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;


public class TyhRestConnection {
    private static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    private Options options;

    private String host;

    private PrivateKey privateKey;

    public Options getOptions() {
        return options;
    }

    public TyhRestConnection(Options options) {
        this.options = options;
        try {
            this.host = new URL(this.options.getRestHost()).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            this.privateKey = RSA2Utils.getPrivateKeyFromPKCS8(options.getSecretKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TyhResponse executePostWithSignature(String path, TyhRequest tyhRequest) throws Exception {
        Options options = this.getOptions();

        String content = tyhRequest.getAccessId() + tyhRequest.getData()
                + tyhRequest.getSignType() + tyhRequest.getTimeStamp();
        tyhRequest.setSign(RSA2Utils.doSign(content, "utf-8", privateKey));

        String requestUrl = options.getRestHost() + path;
        Request executeRequest = new Request.Builder().url(requestUrl).post(RequestBody.create(JSON_TYPE, JSON.toJSONString(tyhRequest)))
                .addHeader("Content-Type", "application/json").build();

        String resp = ConnectionFactory.execute(executeRequest);
        return checkAndGetResponse(resp);
    }


    private TyhResponse checkAndGetResponse(String resp) {
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

        return JSON.toJavaObject(json, TyhResponse.class);
    }

    public TyhRequest obtainSignRequestParam(TyhRequest tyhRequest) throws Exception {
        Options options = this.getOptions();

        String content = tyhRequest.getAccessId() + tyhRequest.getData()
                + tyhRequest.getSignType() + tyhRequest.getTimeStamp();
        tyhRequest.setSign(RSA2Utils.doSign(content, "utf-8", privateKey));
        return tyhRequest;
    }

}
