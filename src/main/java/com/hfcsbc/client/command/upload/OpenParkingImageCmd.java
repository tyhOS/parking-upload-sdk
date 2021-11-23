package com.hfcsbc.client.command.upload;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @program: tyh-os
 * @description: 2.1.4 车辆图片上传
 * @author: wangdan
 * @create: 2021-09-24 16:25
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenParkingImageCmd {

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

    @NotNull(message = "车辆图片base64编码数据content不可为空")
    private String content;

    @NotNull(message = "source不可为空(车辆图片来源 1：上传驶入照片；2：上传驶出照片；3：上传车位监控照片；4：上传车道监控抓拍图片;)")
    private Integer source;

}
