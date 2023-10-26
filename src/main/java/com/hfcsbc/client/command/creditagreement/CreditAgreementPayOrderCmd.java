package com.hfcsbc.client.command.creditagreement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: wangdong
 * Date: 2022/8/30
 * Description: 信用支付下单Cmd
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditAgreementPayOrderCmd {

    /**
     * 平台协议号
     */
    private String osAgreementNo;

    /**
     * 业务方协议号
     */
    private String ownerAgreementNo;

    /**
     * 开放平台商户编号
     */
    private String osMerchantCode;

    /**
     * 开放平台门店编号
     */
    private String osStoreCode;

    /**
     * 第三方商户创建的唯一订单号
     */
    private String ownerTradeNo;

    /**
     * 订单标题
     */
    private String title;

    /**
     * 订单总金额
     */
    private Integer orderFee;

    /**
     * 附加信息
     */
    private String remark;

    /**
     * 商户创建的订单业务号
     */
    private String ownerBusinessNo;

    /**
     * 通知地址
     */
    private String notifyUrl;

}
