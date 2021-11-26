package com.hfcsbc.client.dto.trade;

import com.hfcsbc.constants.PayConstant;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 查询、回调单笔交易结果
 */
@Data
public class TradeQueryResultDto {

    /**
     * 商户订单号
     */
    private String ownerTradeNo;

    /**
     * 支付平台订单号
     */
    private String tpTradeNo;

    /**
     * 开放平台给支付平台的商家订单号
     */
    private String osTradeNo;

    /**
     * 交易状态 {@link PayConstant.TradeStatus}
     */
    @PayConstant.TradeStatus
    private String tradeStatus;

    /**
     * 交易的订单金额 单位为分
     */
    private Integer orderFee;

    /**
     * 交易的实付金额 单位为分
     */
    private Integer paymentFee;

    /**
     * 商户给开放平台的的附加数据，支付平台原封不动返回
     */
    private String remark;

    /**
     * 开放平台分配给商户的服务商ID
     */
    private Long osPartnerId;

    /**
     * 开放平台分配给商户的商户ID
     */
    private Long osMerchantId;

    /**
     * 开放平台商户门店ID ,可以为空
     */
    private Long osStoreId;

    /**
     * 下单时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    /**
     * 支付完成时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date payDate;

    /**
     * 支付渠道 {@link PayConstant.PayChannel}
     */
    @PayConstant.PayChannel
    private String payChannel;

    /**
     * 支付产品类型 {@link PayConstant.PayProduct}
     */
    @PayConstant.PayProduct
    private String payProduct;

    /**
     * 支付标题
     */
    private String title;

    /**
     * 回调地址
     */
    private String callbackUrl;

    /**
     * 退款金额, 单位为分
     */
    private Integer refundFee;

    /**
     * 业务类型
     */
    private String payBusiness;

}
