package com.hfcsbc.client.command.upload;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @program: tyh-os
 * @description: 2.1.2  停车场入场信息上报
 * @author: wangdan
 * @create: 2021-09-24 16:15
 **/
@Data
@Builder
public class OpenParkingDriveInCmd {

    @JSONField(name = "os_store_id")
    @NotNull(message = "os_store_id不可为空")
    private Long osStoreId;

    @JSONField(name = "car_plate")
    @NotNull(message = "car_plate不可为空")
    private String carPlate;

    @JSONField(name = "car_plate_color")
    @NotNull(message = "car_plate_color不可为空")
    private int carPlateColor;

    @JSONField(name = "order_id")
    @NotNull(message = "order_id不可为空")
    private String orderId;

    @JSONField(name = "in_time")
    @NotNull(message = "in_time不可为空")
    private Date inTime;

    @JSONField(name = "in_channel")
    @NotNull(message = "in_channel不可为空")
    private String inChannel;
}
