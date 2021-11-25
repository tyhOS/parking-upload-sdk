package com.hfcsbc.service;

import com.alibaba.fastjson.JSON;
import com.hfcsbc.client.TyhUploadClient;
import com.hfcsbc.client.command.upload.*;
import com.hfcsbc.client.dto.OpenParkingCheckRecordDto;
import com.hfcsbc.client.dto.OpenParkingHeartbeatDto;
import com.hfcsbc.client.dto.OpenParkingUIDDto;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.client.model.TyhRequest;
import com.hfcsbc.constants.Options;
import org.bouncycastle.util.encoders.Base64;

import java.nio.charset.StandardCharsets;
import java.util.Date;


public class TyhUploadService implements TyhUploadClient {

  public static final String SIGN_TYPE = "RSA";
  public static final String POST_UPLOAD_SURPLUS = "/open/api/v1/uploadSurplus";
  public static final String POST_UPLOAD_DRIVE_IN = "/open/api/v1/uploadDriveIn";
  public static final String POST_UPLOAD_DRIVE_OUT = "/open/api/v1/uploadDriveOut";
  public static final String POST_UPLOAD_DRIVE_IMAGE = "/open/api/v1/uploadImage";
  public static final String POST_UPLOAD_HEARTBEAT = "/open/api/v1/uploadHeartbeat";
  public static final String POST_UPLOAD_CHECK_RECORD = "/open/api/v1/uploadCheckRecord";
  public static final String POST_UPLOAD_UID = "/open/api/v1/uploadUID";

  private Options options;

  private TyhRestConnection restConnection;

  public TyhUploadService(Options options) {
    this.options = options;
    restConnection = new TyhRestConnection(options);
  }

  @Override
  public Results<String> uploadSurplus(OpenParkingSurplusCmd openParkingSurplusCmd) throws Exception {
    byte[] data = JSON.toJSONString(openParkingSurplusCmd).getBytes(StandardCharsets.UTF_8);
    TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
            .timeStamp(new Date().getTime()).signType(SIGN_TYPE)
            .data(new String(Base64.encode(data))).build();
    return restConnection.executePostWithSignature(POST_UPLOAD_SURPLUS, tyhRequest, String.class);
  }

  @Override
  public Results<String> uploadDriveIn(OpenParkingDriveInCmd openParkingDriveInCmd) throws Exception {
    byte[] data = JSON.toJSONString(openParkingDriveInCmd).getBytes(StandardCharsets.UTF_8);
    TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
            .timeStamp(new Date().getTime()).signType(SIGN_TYPE)
            .data(new String(Base64.encode(data))).build();
    return restConnection.executePostWithSignature(POST_UPLOAD_DRIVE_IN, tyhRequest, String.class);
  }

  @Override
  public Results<String> uploadDriveOut(OpenParkingDriveOutCmd openParkingDriveOutCmd) throws Exception {
    byte[] data = JSON.toJSONString(openParkingDriveOutCmd).getBytes(StandardCharsets.UTF_8);
    TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
            .timeStamp(new Date().getTime()).signType(SIGN_TYPE)
            .data(new String(Base64.encode(data))).build();
    return restConnection.executePostWithSignature(POST_UPLOAD_DRIVE_OUT, tyhRequest, String.class);
  }

  @Override
  public Results<String> uploadImage(OpenParkingImageCmd openParkingImageCmd) throws Exception {
    byte[] data = JSON.toJSONString(openParkingImageCmd).getBytes(StandardCharsets.UTF_8);
    TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
            .timeStamp(new Date().getTime()).signType(SIGN_TYPE)
            .data(new String(Base64.encode(data))).build();
    return restConnection.executePostWithSignature(POST_UPLOAD_DRIVE_IMAGE, tyhRequest, String.class);
  }

  @Override
  public Results<OpenParkingHeartbeatDto> uploadHeartbeat(OpenParkingHeartbeatCmd openParkingHeartbeatCmd) throws Exception {
    byte[] data = JSON.toJSONString(openParkingHeartbeatCmd).getBytes(StandardCharsets.UTF_8);
    TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
            .timeStamp(new Date().getTime()).signType(SIGN_TYPE)
            .data(new String(Base64.encode(data))).build();
    return restConnection.executePostWithSignature(POST_UPLOAD_HEARTBEAT, tyhRequest, OpenParkingHeartbeatDto.class);
  }

  @Override
  public Results<OpenParkingCheckRecordDto> uploadCheckRecord(OpenParkingCheckRecordCmd cmd) throws Exception {
    byte[] data = JSON.toJSONString(cmd).getBytes(StandardCharsets.UTF_8);
    TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
            .timeStamp(new Date().getTime())
            .signType(SIGN_TYPE)
            .data(new String(Base64.encode(data)))
            .build();
    return restConnection.executePostWithSignature(POST_UPLOAD_CHECK_RECORD, tyhRequest, OpenParkingCheckRecordDto.class);
  }

  @Override
  public Results<OpenParkingUIDDto> uploadUID(OpenParkingUIDCmd cmd) throws Exception {
    byte[] data = JSON.toJSONString(cmd).getBytes(StandardCharsets.UTF_8);
    TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
            .timeStamp(new Date().getTime())
            .signType(SIGN_TYPE)
            .data(new String(Base64.encode(data)))
            .build();
    return restConnection.executePostWithSignature(POST_UPLOAD_UID, tyhRequest, OpenParkingUIDDto.class);
  }


}
