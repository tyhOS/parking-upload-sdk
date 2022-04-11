package com.hfcsbc.client.dto;

import com.hfcsbc.constants.TyhConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

/**
 * @author qidongliang
 * @email 18919656953@163.com
 * @dateTime 2021/9/27
 * @description 驶入驶出记录
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenParkingDriveRecordDto {

    private String orderId;

    private String carPlate;

    private Integer carPlateColor;

    private String carPlateColorDesc;

    private Integer status;

    private String statusDesc;

    private String parkingLotName;

    private Date inTime;

    private Date outTime;

    private String billingAmount;

    private String payAmount;

    private String merchantName;

    private String partnerName;


}
