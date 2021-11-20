package com.hfcsbc.client.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: tyh-os
 * @description:
 * @author: wangdan
 * @create: 2021-09-24 17:39
 **/
@Data
@AllArgsConstructor
public class OpenParkingHeartbeatDto {

    @JSONField(name = "server_time")
    private Long serverTime;
}
