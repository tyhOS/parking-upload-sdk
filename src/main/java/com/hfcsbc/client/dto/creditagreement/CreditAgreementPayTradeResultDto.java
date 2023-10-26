package com.hfcsbc.client.dto.creditagreement;

import lombok.Data;

/**
 * Author: wangdong
 * Date: 2022/9/7
 * Description: 信用支付下单、扣款返回给业务方响应
 */
@Data
public class CreditAgreementPayTradeResultDto {

    /**
     * 商户订单号
     */
    private String ownerTradeNo;

    /**
     * 开放平台订单号
     */
    private String osTradeNo;

    /**
     * 交易状态
     */
    private String tradeStatus;

    /**
     * 交易的订单金额
     */
    private Integer orderFee;

    /**
     * 附加信息
     */
    private String remark;

    /**
     * 开放平台商户编号
     */
    private String osMerchantCode;

    /**
     * 开放平台门店编号
     */
    private String osStoreCode;

    /**
     * 下单时间
     */
    private Long createdTime;

    /**
     * 支付渠道
     */
    private String payChannel;

    /**
     * 支付产品类型
     */
    private String payProduct;

    /**
     * 支付标题
     */
    private String title;

    /**
     * 商户创建的订单业务号
     */
    private String ownerBusinessNo;

}
