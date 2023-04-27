package com.hfcsbc.client.command.upload;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @program: tyh-os
 * @description: 2.2.1心跳上传
 * @author: wangdan
 * @create: 2021-09-24 16:27
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenParkingHeartbeatCmd {

    @NotNull(message = "osStoreCode不可为空")
    private Long osStoreCode;

    @NotNull(message = "uploadTime不可为空")
    private Long uploadTime;
}
