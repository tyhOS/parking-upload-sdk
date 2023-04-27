package com.hfcsbc.client.command.upload;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class OpenParkingDriveInCmd {

    @NotNull(message = "osStoreCode不可为空")
    private Long osStoreCode;

    @NotNull(message = "carPlate不可为空")
    private String carPlate;

    @NotNull(message = "carPlateColor不可为空")
    private int carPlateColor;

    @NotNull(message = "orderId不可为空")
    private String orderId;

    @NotNull(message = "inTime不可为空")
    private Long inTime;

    @NotNull(message = "inChannel不可为空")
    private String inChannel;
}
