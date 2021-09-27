package com.hfcsbc.client.command;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @program: tyh-os
 * @description: 2.1.3 停车场出场信息上报
 * @author: wangdan
 * @create: 2021-09-24 16:20
 **/
@Data
public class UploadDriveOutCmd {
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

    @JSONField(name = "out_time")
    private Date outTime;

    private Integer duration;

    @JSONField(name = "park_type")
    private Integer parkType;

    @JSONField(name = "billing_amount")
    private Integer billingAmount;

    @JSONField(name = "pay_type")
    private Integer payType;

    @JSONField(name = "pay_amount")
    private Integer payAmount;

    @JSONField(name = "in_channel")
    private String inChannel;

    @JSONField(name = "out_channel")
    private String outChannel;

}
