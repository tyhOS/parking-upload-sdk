package com.hfcsbc.client.command;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @program: tyh-os
 * @description: 2.2.1心跳上传
 * @author: wangdan
 * @create: 2021-09-24 16:27
 **/
@Data
public class UploadHeartbeatCmd {
    @JSONField(name = "parking_code")
    private String parkingCode;

    @JSONField(name = "upload_time")
    private Long uploadTime;
}
