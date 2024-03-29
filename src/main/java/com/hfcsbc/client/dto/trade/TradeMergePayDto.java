package com.hfcsbc.client.dto.trade;

import com.hfcsbc.client.dto.AppPayJumpConfigDto;
import lombok.Data;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 合单支付返回的dto
 */
@Data
public class TradeMergePayDto {

    /**
     * 开放平台给支付平台的订单号
     */
    private String osMergeNo;

    /**
     * 商户自传的并笔支付编号
     */
    private String ownerMergeNo;

    /**
     * 时间戳，标准北京时间
     */
    private Long timestamp;

    /**
     * 调起支付的签名信息
     */
    private String sign;

    /**
     * app跳转参数
     */
    private AppPayJumpConfigDto jumpConfig;

}
