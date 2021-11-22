package com.hfcsbc.client.command.trade;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 单笔交易订单查询
 */
@Data
@Builder
public class TradeQuery {

    /**
     * 开放平台商户ID
     */
    private Long osPartnerId;

    /**
     * 商户自传的交易号,和osTradeNo/tpTradeNo 不能同时为空
     */
    private String ownerTradeNo;

    /**
     * 开放平台给支付平台的订单号，和tpTradeNo/ownerTradeNo不能同时为空
     */
    private String osTradeNo;

    /**
     * 支付宝交易号，和osTradeNo/ownerTradeNo不能同时为空
     */
    private String tpTradeNo;

}
