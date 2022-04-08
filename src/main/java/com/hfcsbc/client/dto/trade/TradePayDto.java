package com.hfcsbc.client.dto.trade;

import lombok.Data;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 单笔下单返回的dto
 */
@Data
public class TradePayDto {

    /**
     * 开放平台唯一订单号
     */
    private String osTradeNo;

    /**
     * 第三方商户创建的唯一订单号
     */
    private String ownerTradeNo;

    /**
     * 该笔订单的资金总金额 单位为分
     */
    private Integer orderFee;

    /**
     * 时间戳，标准北京时间
     */
    private Long timestamp;

    /**
     * 调起支付的签名信息（扫码支付时直接返回url链接）
     */
    private String sign;

    // 支付记录id，兼容tyh-base的payRecordId
    private Long tempId;

}
