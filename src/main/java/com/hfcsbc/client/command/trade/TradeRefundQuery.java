package com.hfcsbc.client.command.trade;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 交易退款结果查询
 */
@Data
@Builder
public class TradeRefundQuery {

    /**
     * 开放平台退款单号
     */
    @NotEmpty
    private String osRefundNo;

    /**
     * 商户自传的退款单号，若没有可不传
     */
    private String ownerRefundNo;

}
