package com.hfcsbc.client.command.payment;

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
     * 平台分配的服务商ID
     */
    private Long osPartnerId;

    /**
     * 交易订单号，要求唯一
     */
    private String ownerTradeNo;

}
