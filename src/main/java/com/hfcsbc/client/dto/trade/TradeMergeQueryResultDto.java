package com.hfcsbc.client.dto.trade;

import lombok.Data;

import java.util.List;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 合单交易查询
 */
@Data
public class TradeMergeQueryResultDto {

    /**
     * 商户自传,合并交易单号
     */
    private String ownerMergeNo;

    /**
     * 开放平台 合单订单号
     */
    private String osMergeNo;

    /**
     * 子单交易结果
     */
    private List<TradeQueryResultDto> subOrders;

    /**
     * 子商户应用对应用户ID,openId
     */
    private String ownerAppBuyerId;

    /**
     * 买家在支付机构的登录账号
     */
    private String buyerLoginId;

}
