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
     * 商户自传,合并交易单号
     */
    private String ownerMergeNo;

    /**
     * 合并交易单号
     */
    private String osMergeNo;

    /**
     * 技术服务商id，该参数只有超级服务商使用
     */
    private Long superTePartnerId;

}
