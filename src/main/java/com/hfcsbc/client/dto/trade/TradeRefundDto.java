package com.hfcsbc.client.dto.trade;

import lombok.Data;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/27
 * @Description 申请退款返回的dto
 */
@Data
public class TradeRefundDto {

    /**
     * 本次请求平台退款的单号
     */
    private String osRefundNo;

}
