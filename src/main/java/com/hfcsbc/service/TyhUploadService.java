package com.hfcsbc.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hfcsbc.client.TyhUploadClient;
import com.hfcsbc.client.command.*;
import com.hfcsbc.client.model.TyhRequest;
import com.hfcsbc.client.model.TyhResponse;
import com.hfcsbc.constants.Options;
import org.bouncycastle.util.encoders.Base64;

import java.nio.charset.StandardCharsets;
import java.util.Date;


public class TyhUploadService implements TyhUploadClient {
  public static final String SIGN_TYPE = "RSA";
  public static final String POST_UPLOAD_SURPLUS = "/v1/uploadSurplus";
  public static final String POST_UPLOAD_DRIVE_IN = "/v1/uploadDriveIn";
  public static final String POST_UPLOAD_DRIVE_OUT = "/v1/uploadDriveOut";
  public static final String POST_UPLOAD_DRIVE_IMAGE = "/v1/uploadImage";
  public static final String POST_UPLOAD_HEARTBEAT = "/v1/uploadHeartbeat";

  private Options options;

  private TyhRestConnection restConnection;

  public TyhUploadService(Options options) {
    this.options = options;
    restConnection = new TyhRestConnection(options);
  }

  @Override
  public TyhResponse uploadSurplus(UploadSurplusCmd uploadSurplusCmd) throws Exception {
    byte[] data = JSON.toJSONString(uploadSurplusCmd).getBytes();
    TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
            .timeStamp(new Date().getTime()).signType(SIGN_TYPE)
            .data(new String(Base64.encode(data), StandardCharsets.UTF_8)).build();
    return restConnection.executePostWithSignature(POST_UPLOAD_SURPLUS, tyhRequest);
  }

  @Override
  public TyhResponse uploadDriveIn(UploadDriveInCmd uploadDriveInCmd) throws Exception {
    byte[] data = JSON.toJSONString(uploadDriveInCmd).getBytes();
    TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
            .timeStamp(new Date().getTime()).signType(SIGN_TYPE)
            .data(new String(Base64.encode(data), StandardCharsets.UTF_8)).build();
    return restConnection.executePostWithSignature(POST_UPLOAD_DRIVE_IN, tyhRequest);
  }

  @Override
  public TyhResponse uploadDriveOut(UploadDriveOutCmd uploadDriveOutCmd) throws Exception {
    byte[] data = JSON.toJSONString(uploadDriveOutCmd).getBytes();
    TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
            .timeStamp(new Date().getTime()).signType(SIGN_TYPE)
            .data(new String(Base64.encode(data), StandardCharsets.UTF_8)).build();
    return restConnection.executePostWithSignature(POST_UPLOAD_DRIVE_OUT, tyhRequest);
  }

  @Override
  public TyhResponse uploadImage(UploadImageCmd uploadImageCmd) throws Exception {
    byte[] data = JSON.toJSONString(uploadImageCmd).getBytes();
    TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
            .timeStamp(new Date().getTime()).signType(SIGN_TYPE)
            .data(new String(Base64.encode(data), StandardCharsets.UTF_8)).build();
    return restConnection.executePostWithSignature(POST_UPLOAD_DRIVE_IMAGE, tyhRequest);
  }

  @Override
  public  TyhResponse uploadHeartbeat(UploadHeartbeatCmd uploadHeartbeatCmd) throws Exception {
    byte[] data = JSON.toJSONString(uploadHeartbeatCmd).getBytes();
    TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
            .timeStamp(new Date().getTime()).signType(SIGN_TYPE)
            .data(new String(Base64.encode(data), StandardCharsets.UTF_8)).build();
    return restConnection.executePostWithSignature(POST_UPLOAD_HEARTBEAT, tyhRequest);
  }

}
