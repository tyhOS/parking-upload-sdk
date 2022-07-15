package com.hfcsbc.client.dto.trade;

import lombok.Data;

/**
 * @author wangdong
 * @dateTime 2022/2/16
 * @description xxx
 */
@Data
public class TradeRecordTotalDto {
    /**
     * 交易订单（分）
     */
    private Long totalOrderFee = 0L;
    /**
     * 总服务费（分）
     */
    private Long totalServiceFee = 0L;
}
