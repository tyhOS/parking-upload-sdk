package com.hfcsbc.client.command.upload;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @program: tyh-os
 * @description: 2.1.3 停车场出场信息上报
 * @author: wangdan
 * @create: 2021-09-24 16:20
 **/
@Data
@Builder
public class OpenParkingDriveOutCmd {

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

    @JSONField(name = "out_time")
    @NotNull(message = "out_time不可为空")
    private Date outTime;

    @NotNull(message = "duration不可为空")
    private Integer duration;

    @JSONField(name = "park_type")
    @NotNull(message = "park_type不可为空")
    private Integer parkType;

    @JSONField(name = "billing_amount")
    @NotNull(message = "billing_amount不可为空")
    private Integer billingAmount;

    @JSONField(name = "pay_type")
    @NotNull(message = "pay_type不可为空")
    private Integer payType;

    @JSONField(name = "pay_amount")
    @NotNull(message = "pay_amount不可为空")
    private Integer payAmount;

    @JSONField(name = "in_channel")
    @NotNull(message = "in_channel不可为空")
    private String inChannel;

    @JSONField(name = "out_channel")
    @NotNull(message = "out_channel不可为空")
    private String outChannel;

}
