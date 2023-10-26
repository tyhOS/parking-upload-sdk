package com.hfcsbc.client.command.creditagreement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: wangdong
 * Date: 2022/8/30
 * Description: 无感支付交易并签约Cmd
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditAgreementOrderAndSignCmd {

    /**
     * 商户外部协议号，不同的支付宝用户需要传递不同的外部单号
     */
    private String ownerAgreementNo;

    /**
     * 通知地址
     */
    private String notifyUrl;

    /**
     * 开放平台支付配置编号
     */
    private String osPaySettingNo;

    /**
     * 取消开通跳转回商户的页面地址
     */
    private String cancelBackLink;

    /**
     * 开通结束跳转回商户的页面地址
     */
    private String returnBackLink;

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

}
