package com.hfcsbc.client.command.trade;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description xxx
 */
@Data
@Builder
public class TradeMergeCloseCmd {


    /**
     * 商户自传的交易号 和 osMergeNo 不能同时为空
     */
    private String ownerMergeNo;

    /**
     * 平台返回的交易号 和 ownerMergeNo 不能同时为空
     */
    private String osMergeNo;

    /**
     * 服务商id，该参数只有超级服务商使用
     */
    private Long superOsPartnerId;
}
