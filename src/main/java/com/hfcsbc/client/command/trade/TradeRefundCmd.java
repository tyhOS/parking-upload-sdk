package com.hfcsbc.client.command.trade;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 请求退款参数
 */
@Data
@Builder
public class TradeRefundCmd {


    /**
     * 商户自传的交易号, ownerTradeNo/osTradeNo/tpTradeNo 不能同时为空
     */
    private String ownerTradeNo;

    /**
     * 开放平台给支付平台的订单号 ownerTradeNo/osTradeNo/tpTradeNo 不能同时为空
     */
    private String osTradeNo;

    /**
     * 支付平台的订单号 ownerTradeNo/osTradeNo/tpTradeNo 不能同时为空
     */
    private String tpTradeNo;

    /**
     * 商户自传的退款交易号,传此值时,会进行重复校验
     */
    private String ownerRefundNo;

    /**
     * 退款金额 单位分
     */
    @NotNull
    private Integer refundFee;

    /**
     * 退款原因
     */
    private String refundReason;

    /**
     * 退款回调地址
     */
    private String callbackUrl;

}
