package com.hfcsbc.client.command.upload;

import com.alibaba.fastjson.annotation.JSONField;
import com.hfcsbc.constants.TyhConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class OpenParkingDriveOutCmd {

    @NotNull(message = "osStoreId不可为空")
    private Long osStoreId;

    @NotNull(message = "carPlate不可为空")
    private String carPlate;

    @NotNull(message = "carPlateColor不可为空")
    private int carPlateColor;

    @NotNull(message = "orderId不可为空")
    private String orderId;

    @NotNull(message = "inTime不可为空")
    private Long inTime;

    @NotNull(message = "outTime不可为空")
    private Long outTime;

    @NotNull(message = "duration不可为空")
    private Integer duration;

    @NotNull(message = "parkType不可为空")
    @TyhConstants.ParkType
    private Integer parkType;

    @NotNull(message = "billingAmount不可为空")
    private Integer billingAmount;

    @NotNull(message = "payAmount不可为空")
    private Integer payAmount;

    @NotNull(message = "payType不可为空")
    @TyhConstants.PayType
    private Integer payType;

    @NotNull(message = "inChannel不可为空")
    private String inChannel;

    @NotNull(message = "outChannel不可为空")
    private String outChannel;

    /**
     * 停车售卖记录
     */
    private Long cardRecordId;

}
