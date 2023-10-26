package com.hfcsbc.client.dto.creditagreement;

import lombok.Data;

import java.util.Date;

/**
 * Author: wangdong
 * Date: 2022/9/7
 * Description: 协议查询dto
 */
@Data
public class CreditAgreementQueryDto {

    /**
     * 平台签约协议号
     */
    private String osAgreementNo;

    /**
     * 商户协议号
     */
    private String ownerAgreementNo;

    /**
     * 协议生效时间
     */
    private Date validTime;

    /**
     * 协议失效时间
     */
    private Date invalidTime;

    /**
     * 协议当前状态
     */
    private String status;

}
