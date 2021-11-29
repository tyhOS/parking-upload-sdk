package com.hfcsbc.client.dto.trade;

import com.hfcsbc.constants.PayConstant;
import lombok.Data;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 交易退款结果dto
 */
@Data
public class TradeRefundResultDto {

    /**
     * 退款状态
     */
    @PayConstant.RefundStatus
    private String refundStatus;

    /**
     * 开放平台给商户的交易订单号
     */
    private String osTradeNo;

    /**
     * 支付平台交易订单号
     */
    private String tpTradeNo;

    /**
     * 本次请求部分退款的单号
     */
    private String osRefundNo;

    /**
     * 本次退款请求在支付平台的退款单号,由于支付宝未返回，故暂时使用tpTradeNo
     */
    private String tpRefundNo;

    /**
     * 本次退款金额
     */
    private Integer refundFee;

    /**
     * 退款申请时间，时间戳，标准北京时间
     */
    private Long createdTime;

    /**
     * 支付平台返回的退款时间，时间戳 ，标准北京时间
     */
    private Long refundTime;

    /**
     * 交易的订单金额 单位为分
     */
    private Integer orderFee;

    /**
     * 交易的实付金额 单位为分
     */
    private Integer paymentFee;

    /**
     * 退款原因
     */
    private String refundReason;

    /**
     * 商户维护:商户创建的订单业务号
     */
    private String ownerBusinessNo;

    /**
     * 商户支付终端
     */
    private String ownerPayTerminal;

}
