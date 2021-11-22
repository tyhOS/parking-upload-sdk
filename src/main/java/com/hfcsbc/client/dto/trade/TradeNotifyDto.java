package com.hfcsbc.client.dto.trade;

import com.hfcsbc.constants.PayConstant;
import lombok.Data;

import java.util.Date;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 单笔交易订单结果回调通知dto
 */
@Data
public class TradeNotifyDto {

    /**
     * 开放平台商户ID
     */
    private Long osPartnerId;

    /**
     * 开放平台商户ID
     */
    private Long osMerchantId;

    /**
     * 开放平台商户门店ID ,可以为空
     */
    private Long osStoreId;

    /**
     * 商户创建的订单唯一标识
     */
    private String ownerTradeNo;

    /**
     * 开放平台返回的交易订单号,全平台唯一
     */
    private String osTradeNo;

    /**
     * 支付宝微信交易订单号对应trade_no.在支付回调时写入
     */
    private String tpTradeNo;

    /**
     * os_merge_trade_no	合并支付商户订单号，如果为空表示单笔支付
     */
    private String osMergeTradeNo;

    /**
     * 创建时间，时间戳
     */
    private Date createdDate;

    /**
     * 用户标识,可以是手机号/openID等
     */
    private String userId;

    /**
     * 支付完成时间
     */
    private Date payDate;

    /**
     * 订单金额,单位分  orderFee= paymentFee + tpDiscountFee + osDiscountFee
     */
    private Integer orderFee;

    /**
     * 用户实际支付金额,单位分
     */
    private Integer paymentFee;

    /**
     * 平台侧优惠金额,可能是开放平台,也可能是某个服务商,甚至商户
     */
    private Integer osDiscountFee;

    /**
     * 平台侧优惠类别 {@link PayConstant.OSDiscountType}
     */
    @PayConstant.OSDiscountType
    private Integer osDiscountType;

    /**
     * 支付机构优惠,单位分
     */
    private Integer tpDiscountFee;

    /**
     * 支付渠道code
     */
    private String payChannel;

    /**
     * 支付产品类型 {@link PayConstant.PayProductCode}
     */
    @PayConstant.PayProductCode
    private String payProduct;

    /**
     * 业务类型, 商户未配置特定业务类型时,不可传入此值
     */
    private String payBusiness;

    /**
     * 支付标题
     */
    private String title;


    /**
     * 异步回调时原样返回。也可用于自定义查询。平台存储不发送给支付机构
     */
    private String remark;

}
