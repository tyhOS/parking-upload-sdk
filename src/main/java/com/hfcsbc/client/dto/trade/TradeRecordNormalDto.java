package com.hfcsbc.client.dto.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wangdong
 * @dateTime 2021/11/29
 * @description 交易记录返回dto
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradeRecordNormalDto {

    /**
     * 交易记录ID
     */
    private Long id;

    /**
     * 支付宝、微信商户账号
     */
    private String tpMerchantId;

    /**
     * 开放平台服务商ID
     */
    private Long osPartnerId;

    /**
     * 开放平台服务商名称
     */
    private String osPartnerName;

    /**
     * 开放平台商户ID
     */
    private Long osMerchantId;

    /**
     * 开放平台商户名称
     */
    private String osMerchantName;

    /**
     * 开放平台商户门店ID
     */
    private Long osStoreId;

    /**
     * 开放平台商户门店名称
     */
    private String osStoreName;

    /**
     * 订单唯一标识
     */
    private String ownerTradeNo;

    /**
     * 支付机构的out_trade_no
     */
    private String osTradeNo;

    /**
     * 支付宝微信交易订单号对应trade_no
     */
    private String tpTradeNo;

    /**
     * 合并支付商户订单号
     */
    private String osMergeNo;

    /**
     * 商户创建的并笔支付唯一标识
     */
    private String ownerMergeNo;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 子商户应用对应用户ID,openId
     */
    private String ownerAppBuyerId;

    /**
     * 买家在支付机构的登录账号，支付宝独有参数
     */
    private String buyerLoginId;

    /**
     * 支付完成时间
     */
    private Date payDate;

    /**
     * 回调时间
     */
    private Date callbackDate;

    /**
     * 支付状态
     */
    private String tradeStatus;

    /**
     * 订单金额
     */
    private Integer orderFee;

    /**
     * 用户实际支付金额
     */
    private Integer paymentFee;

    /**
     * 平台侧优惠金额
     */
    private Integer osDiscountFee;

    /**
     * 平台侧优惠类别
     */
    private Integer osDiscountType;

    /**
     * 支付机构优惠
     */
    private Integer tpDiscountFee;

    /**
     * 支付渠道code
     */
    private String payChannel;

    /**
     * 支付产品类型
     */
    private String payProduct;

    /**
     * 业务类型
     */
    private String payBusiness;

    /**
     * 总服务费率
     */
    private Integer totalServiceRatio;

    /**
     * 总服务费
     */
    private Integer totalServiceFee;

    /**
     * 支付标题
     */
    private String title;

    /**
     * 标签信息
     */
    private String body;

    /**
     * 异步回调时原样返回
     */
    private String remark;

    /**
     * 退款金额
     */
    private Integer refundFee;

    /**
     * 结算状态
     */
    private String settleStatus;

    /**
     * 分账状态
     */
    private String profitShareStatus;

    /**
     * 回调调用方地址
     */
    private String callbackUrl;

    /**
     * 商户创建的订单业务号
     */
    private String ownerBusinessNo;

    /**
     * 商户支付终端
     */
    private String ownerPayTerminal;

}
