package com.hfcsbc.client.command.creditagreement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: wangdong
 * Date: 2022/8/30
 * Description: 无感支付扣款Cmd
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditAgreementPayTradeCmd {

    /**
     * 开放平台订单号
     */
    private String osTradeNo;

    /**
     * 第三方商户创建的唯一订单号
     */
    private String ownerTradeNo;

}
