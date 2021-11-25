package com.hfcsbc.client.command.trade;

import com.hfcsbc.constants.PayConstant;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/23
 * @Description 获取用户在支付平台的buyerId(openId)
 */
@Data
@Builder
public class TradeBuyerIdQuery {

    /**
     * 前端在支付平台应用获取到的code
     */
    @NotEmpty
    private String code;

    /**
     * 支付渠道
     */
    @NotEmpty
    @PayConstant.PayChannel
    private String payChannel;

    /**
     * 支付产品
     */
    @NotEmpty
    @PayConstant.PayProduct
    private String payProduct;

}
