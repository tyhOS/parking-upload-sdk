package com.hfcsbc.client.command;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


/**
 * @program: tyh-os
 * @description: 2.1.2  停车场入场信息上报
 * @author: wangdan
 * @create: 2021-09-24 16:15
 **/

@Data
@Builder
public class UploadDriveInCmd {
    @JSONField(name = "parking_code")
    private String parkingCode;

    @JSONField(name = "car_plate")
    private String carPlate;

    @JSONField(name = "car_plate_color")
    private int carPlateColor;

    @JSONField(name = "order_id")
    private String orderId;

    @JSONField(name = "in_time")
    private Date inTime;

    @JSONField(name = "in_channel")
    private String inChannel;
}
