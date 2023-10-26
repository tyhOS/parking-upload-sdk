package com.hfcsbc.client.command.creditagreement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: wangdong
 * Date: 2022/8/30
 * Description: 信用支付服务开通Cmd
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditAgreementPaySignCmd {

    /**
     * 商户协议号
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

}
