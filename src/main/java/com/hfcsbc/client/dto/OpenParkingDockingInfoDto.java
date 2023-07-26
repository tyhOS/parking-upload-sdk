package com.hfcsbc.client.dto;

import lombok.*;

import java.util.Date;

/**
 * @Author: HeQuanChao
 * @Date: 22/03/16
 * @Description 停车数据对接状态数据
 */


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class OpenParkingDockingInfoDto {
    private Long id;

    /**
     * 门店号
     */
    private Long osStoreId;

    /**
     * 停车场编码
     */
    private String osStoreCode;

    /**
     * 驶入及时的数据
     */
    private Long inTimelyNum;

    /**
     * 驶入上传图片的数量
     */
    private Long inImageNum;

    /**
     * 驶入平台计入数量
     */
    private Long inAllNum;

    /**
     * 驶入实际数量
     */
    private Long inRealityNum;

    /**
     * 驶出及时的数据
     */
    private Long outTimelyNum;

    /**
     * 驶出上传图片的数量
     */
    private Long outImageNum;

    /**
     * 驶出平台计出数量
     */
    private Long outAllNum;

    /**
     * 驶出实际数量
     */
    private Long outRealityNum;

    /**
     * 心跳数量
     */
    private Long heartbeatNum;

    /**
     * 最后一次心跳时间
     */
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastHeartbeatTime;

    /**
     * 记录日期
     */
    //@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date recordDate;

    /**
     * 对账是否涨平状态 0表示正常，1表示异常
     */
    private Integer checkStatus;

    /**
     * 入场数据状态 0表示正常，1表示异常
     */
    private Integer inStatus;

    /**
     * 出场数据状态 0表示正常，1表示异常
     */
    private Integer outStatus;

    /**
     * 心跳数据状态 0表示正常，1表示异常
     */
    private Integer heartbeatStatus;

    /**
     * 入场图片数据状态 0表示正常，1表示异常
     */
    private Integer inImageStatus;

    /**
     * 出场图片数据状态 0表示正常，1表示异常
     */
    private Integer outImageStatus;

    /**
     * 余位上传接口请求标记
     */

    private Boolean uploadSurplusApiFlag;

    /**
     * 对账接口请求标记
     */

    private Boolean uploadCheckRecordApiFlag;

    /**
     * 对接状态
     */
    private Boolean dockingFlag;

    /**
     * 对账时间
     */
    private Date checkDate;

}
