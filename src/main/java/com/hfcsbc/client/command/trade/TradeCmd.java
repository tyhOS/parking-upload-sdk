package com.hfcsbc.client.command.trade;

import com.hfcsbc.constants.PayConstant;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 单笔交易cmd
 */
@Data
@Builder
public class TradeCmd {

    /**
     * 平台分配的服务商ID
     */
    @NotNull
    private Long osPartnerId;

    /**
     * 平台分配的商户ID
     */
    @NotNull
    private Long osMerchantId;

    /**
     * 平台分配的商户门店ID
     */
    private Long osStoreId;

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
     * 支付产品 {@link PayConstant.PayProductCode}
     */
    @NotNull
    @PayConstant.PayProductCode
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
     * 绝对超时时间，超出该时间则支付失效
     */
    private Date timeExpire;

    /**
     * 支付宝或微信的买家id，小程序必传
     */
    private String buyerId;

    /**
     * 支付宝手机网页支付必传，用户付款中途退出返回商户网站的地址
     */
    private String quitUrl;

}
