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
     * 三方支付机构的优惠金额 单位为分
     */
    private Integer tpDiscountFee;

    /**
     * 商户给开放平台的的附加数据，支付平台原封不动返回
     */
    private String remark;

    /**
     * 商户编号
     */
    private String osMerchantCode;

    /**
     * 门店编号
     */
    private String osStoreCode;

    /**
     * 下单时间, 返回时间戳 标准北京时间
     */
    private Long createdTime;

    /**
     * 支付完成时间, 返回时间戳 标准北京时间
     */
    private Long payTime;

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

    /**
    * 商户维护:商户创建的订单业务号
    */
    private String ownerBusinessNo;

    /**
    * 商户支付终端
    */
    private String ownerPayTerminal;

    /**
     * 子商户应用对应用户ID,openId
     */
    private String ownerAppBuyerId;

    /**
     * 买家在支付机构的登录账号
     */
    private String buyerLoginId;

    /**
     * 第三方商户账号
     */
    private String tpMerchantId;

    /**
     * 开票主体（企业税号）
     */
    private String uscCode;

    // 支付记录id，兼容tyh-base的payRecordId
    private Long tempId;
}
