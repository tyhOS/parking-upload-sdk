package com.hfcsbc.client.command;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @program: tyh-os
 * @description: 2.1.4 车辆图片上传
 * @author: wangdan
 * @create: 2021-09-24 16:25
 **/
@Data
public class UploadImageCmd {
    @JSONField(name = "parking_code")
    private String parkingCode;

    @JSONField(name = "car_plate")
    private String carPlate;

    @JSONField(name = "car_plate_color")
    private int carPlateColor;

    @JSONField(name = "order_id")
    private String orderId;

    private String content;
    private Integer source;
}
