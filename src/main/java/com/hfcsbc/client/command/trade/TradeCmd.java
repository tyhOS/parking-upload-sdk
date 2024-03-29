package com.hfcsbc.client.command.trade;

import com.hfcsbc.constants.PayConstant;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 单笔交易cmd
 */
@Data
@Builder
public class TradeCmd {

    /**
     * 平台分配的商户编号
     */
    @NotNull
    private String osMerchantCode;

    /**
     * 平台分配的门店编号
     */
    @NotNull
    private String osStoreCode;

    /**
     * 交易订单号，要求唯一
     */
    private String ownerTradeNo;

    /**
     * 支付渠道 {@link PayConstant.PayChannel}
     */
    @NotNull
    @PayConstant.PayChannel
    private String payChannel;

    /**
     * 支付产品 {@link PayConstant.PayProduct}
     */
    @NotNull
    @PayConstant.PayProduct
    private String payProduct;

    /**
     * 支付业务,传入此值会进行校验,未指定时,不传
     */
    private String payBusiness;

    /**
     * 单标题 最长256
     */
    @NotEmpty
    private String title;

    /**
     * 给支付平台的附加信息，支付平台会原封回调给对用方
     */
    private String remark;

    /**
     * 订单总金额 单位分 范围 1 ~ 1000000000
     */
    @NotNull
    private Integer orderFee;

    /**
     * 通知地址 通知URL必须为直接可访问的URL，不允许携带查询串，要求必须为https地址。
     */
    private String notifyUrl;

    /**
     * 绝对超时时间，超出该时间则支付失效， 时间戳，精确到毫秒
     */
    private Long timeExpire;

    /**
     * 支付宝手机网页支付必传，用户付款中途退出返回商户网站的地址
     */
    private String quitUrl;

    /**
     * 商户维护:商户创建的订单业务号
     */
    private String ownerBusinessNo;

    /**
    * 商户支付终端
    */
    private String ownerPayTerminal;

    /**
     * 商户独立应用的appId，没有可不传
     */
    private String ownerAppId;

    /**
     * 支付宝或微信应用的买家id，小程序必传 （若商户有独立的小程序应用，则传商户小程序的用户id）
     */
    private String ownerAppBuyerId;

}
