package com.hfcsbc.client.dto.creditagreement;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author wangdong
 * @Date 2022/9/7
 * @Desc 下单并签约
 */
@Setter
@Getter
public class CreditAgreementOrderAndSignDto implements Serializable {

    /**
     * 订单标题
     */
    private String title;

    /**
     * 附加信息
     */
    private String remark;

    /**
     * 订单总金额
     */
    private Integer orderFee;

    /**
     * 时间戳
     */
    private Long timestamp;

    /**
     * 调起签约的签名信息
     */
    private String sign;

    /**
     * 开放平台协议号
     */
    private String osAgreementNo;

    /**
     * 商户协议号
     */
    private String ownerAgreementNo;

    /**
     * 开放平台交易号
     */
    private String osTradeNo;

    /**
     * 商户订单号
     */
    private String ownerTradeNo;

    /**
     * 商户订单业务号
     */
    private String ownerBusinessNo;

    /**
     * 协议状态
     */
    private String status;

}
