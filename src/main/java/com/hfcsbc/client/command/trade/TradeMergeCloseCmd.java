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
     * 暂时写死,后期通过网关统一从用户公钥私钥比对拿出来
     */
    private Long osPartnerId;

    /**
     * 商户自传的交易号 和 osMergeNo 不能同时为空
     */
    private String ownerMergeNo;

    /**
     * 平台返回的交易号 和 ownerMergeNo 不能同时为空
     */
    private String osMergeNo;

}
