package com.hfcsbc.client.command.creditagreement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: wangdong
 * Date: 2022/8/30
 * Description: 信用支付签约查询Cmd
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditAgreementPaySignQueryCmd {

    /**
     * 平台协议号
     */
    private String osAgreementNo;

    /**
     * 商户协议号
     */
    private String ownerAgreementNo;

}
