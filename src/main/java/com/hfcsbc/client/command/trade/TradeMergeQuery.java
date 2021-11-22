package com.hfcsbc.client.command.trade;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 合单支付查询
 */
@Data
@Builder
public class TradeMergeQuery {

    /**
     * 平台分配服务商ID
     */
    private Long osPartnerId;

    /**
     * 商户自传,合并交易单号
     */
    private String ownerMergeNo;

    /**
     * 合并交易单号
     */
    private String osMergeNo;

}
