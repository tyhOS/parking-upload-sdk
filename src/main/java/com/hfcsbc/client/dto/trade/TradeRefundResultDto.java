package com.hfcsbc.client.dto.trade;

import com.hfcsbc.constants.PayConstant;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 交易退款结果dto
 */
@Data
@Builder
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
     * 本次退款给用户的金额，不包含所有优惠券金额（微信独有）
     */
    private Integer refundBuyerFee;

    /**
     * 退款总金额 指该笔交易累计已经退款成功的金额(支付宝独有)
     */
    private Integer refundTotalFee;

    /**
     * 本次商户实际退回金额.(支付宝独有)
     */
    private Integer mchRefundFee;

    /**
     * 支付平台返回的退款时间，不保证一定有值，因为要看支付平台是否返回
     */
    private Date refundDate;

    /**
     * 退款失败时用于显示支付平台的失败原因
     */
    private String msg;

    /**
     * 支付平台返回的原始数据
     */
    private String response;

}
