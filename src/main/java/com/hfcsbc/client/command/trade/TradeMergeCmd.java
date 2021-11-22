package com.hfcsbc.client.command.trade;

import com.hfcsbc.constants.PayConstant;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description xxx
 */
@Data
@Builder
public class TradeMergeCmd {

    /**
     * 平台分配服务商ID
     */
    @NotNull
    private Long osPartnerId;

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
    private String payProduct;

    /**
     * 绝对超时时间，超出该时间则支付失效
     */
    private Date timeExpire;

    /**
     * 交易子单详情
     */
    List<SubTradeCmd> subTradeOrders;

    /**
     * 合单支付 商户自传的并笔支付编号,传此值时会进行系统重复提交校验
     */
    private String ownerMergeNo;

    /**
     * 支付宝或微信的买家id，小程序必传
     */
    private String buyerId;

    /**
     * 通知地址 通知URL必须为直接可访问的URL，不允许携带查询串，要求必须为https地址。如果此属性有值,则只通知一次
     */
    private String notifyUrl;

    /**
     * 子单交易信息
     */
    @Data
    @Builder
    public static class SubTradeCmd {

        /**
         * 订单明细的应用唯一标识（16位纯数字），指商家的app_id, 没有可不传
         */
        private String appId;

        /**
         * 商户订单号,传此值时会进行系统重复提交校验
         */
        private String ownerTradeNo;

        /**
         * 订单总金额 单位分 范围1~1000000000
         */
        @NotNull
        private Integer orderFee;

        /**
         * 订单标题 最长256
         */
        @NotEmpty
        private String title;

        /**
         * 平台分配商户ID
         */
        @NotNull
        private Long osMerchantId;

        /**
         * 平台分配商户门店ID
         */
        private Long osStoreId;

        /**
         * 通知地址 通知URL必须为直接可访问的URL，不允许携带查询串，要求必须为https地址。如果主单notifyUrl 无值,此属性有值,则多次回调
         */
        private String notifyUrl;

        /**
         * 支付业务,传入此值会进行校验,未指定时,不传
         */
        private String payBusiness;

        /**
         * 给支付平台的附加信息，支付平台会原封回调给对用方
         */
        private String remark;

    }

}