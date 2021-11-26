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
     * 开放平台给支付平台的交易订单号
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
     * 支付平台返回的退款时间，时间戳 ，标准北京时间
     */
    private Long refundTime;

    /**
     * 退款失败时用于显示支付平台的失败原因
     */
    private String msg;


}
