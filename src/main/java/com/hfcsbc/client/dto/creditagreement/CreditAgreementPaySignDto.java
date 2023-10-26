package com.hfcsbc.client.dto.creditagreement;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author wangdong
 * @Date 2022/9/7
 * @Desc 下单返回内容
 */
@Setter
@Getter
public class CreditAgreementPaySignDto implements Serializable {

    /**
     * 时间戳，标准北京时间
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
     * 协议状态
     */
    private String status;

}
