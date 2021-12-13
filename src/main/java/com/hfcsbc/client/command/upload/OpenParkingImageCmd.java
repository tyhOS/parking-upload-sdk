package com.hfcsbc.client.command.upload;

import com.alibaba.fastjson.annotation.JSONField;
import com.hfcsbc.constants.TyhConstants;
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

    @NotNull(message = "osStoreId不可为空")
    private Long osStoreId;

    @NotNull(message = "carPlate不可为空")
    private String carPlate;

    @NotNull(message = "carPlateColor不可为空")
    @TyhConstants.CarPlateColor
    private int carPlateColor;

    @NotNull(message = "orderId不可为空")
    private String orderId;

    @NotNull(message = "车辆图片base64编码数据content不可为空")
    private String content;

    @NotNull(message = "source不可为空(车辆图片来源 1：上传驶入照片；2：上传驶出照片；3：上传车位监控照片；4：上传车道监控抓拍图片;)")
    @TyhConstants.ImageSource
    private Integer source;

    @NotNull(message = "图片类型不能为空（1：URL， 2：Base64）")
    @TyhConstants.ImageType
    private Integer imageType = TyhConstants.ImageType.URL;

}
