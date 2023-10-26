package com.hfcsbc.client.command.creditagreement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: wangdong
 * Date: 2022/8/30
 * Description: 信用支付下单查询Cmd
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditAgreementPayOrderQueryCmd {

    /**
     * 第三方商户创建的唯一订单号
     */
    private String ownerTradeNo;

    /**
     * 开放平台订单号
     */
    private String osTradeNo;
}
