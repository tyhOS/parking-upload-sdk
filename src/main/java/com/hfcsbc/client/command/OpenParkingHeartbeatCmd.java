package com.hfcsbc.client.command;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: tyh-os
 * @description: 2.2.1心跳上传
 * @author: wangdan
 * @create: 2021-09-24 16:27
 **/
@Data
@Builder
public class OpenParkingHeartbeatCmd {

    @JSONField(name = "os_store_id")
    @NotNull(message = "os_store_id不可为空")
    private Long osStoreId;

    @JSONField(name = "upload_time")
    @NotNull(message = "upload_time不可为空")
    private Long uploadTime;
}
