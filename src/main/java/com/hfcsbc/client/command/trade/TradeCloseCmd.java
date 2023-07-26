package com.hfcsbc.client.command.trade;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 关闭单笔交易
 */
@Data
@Builder
public class TradeCloseCmd {


    /**
     * 交易订单号，要求唯一
     */
    private String ownerTradeNo;

    /**
     * 开放平台给支付平台的交易订单号
     */
    private String osTradeNo;

    /**
     * 服务商id，该参数只有超级服务商使用
     */
    private Long superOsPartnerId;
}
