package com.hfcsbc.client.command.trade;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 交易退款结果查询
 */
@Data
@Builder
public class TradeRefundQuery {

    /** ******************************************************
     * 支付宝 osTradeNo tpTradeNo ownerTradeNo 三选一，至少需要传一个
     * 微信支付 osRefundNo 必传,其余可不传
     ** ******************************************************/

    /**
     * 平台分配服务商ID
     */
    private Long osPartnerId;

    /**
     * 商户自传的交易号,和osTradeNo/tpTradeNo 不能同时为空
     */
    private String ownerTradeNo;

    /**
     * 开放平台给支付平台的商户订单号
     */
    private String osTradeNo;

    /**
     * 支付平台订单号
     */
    private String tpTradeNo;

    /**
     * 开发平台退款单号 请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的商户订单号。
     */
    private String osRefundNo;

    /**
     * 开发平台退款单号 请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的商户订单号。
     */
    private String ownerRefundNo;

}
