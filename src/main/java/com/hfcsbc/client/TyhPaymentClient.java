package com.hfcsbc.client;

import com.hfcsbc.client.command.payment.MergeTradeCloseCmd;
import com.hfcsbc.client.command.payment.MergeTradeCmd;
import com.hfcsbc.client.command.payment.TradeCloseCmd;
import com.hfcsbc.client.command.payment.TradeCmd;
import com.hfcsbc.client.model.TyhResponse;
import com.hfcsbc.constants.Options;
import com.hfcsbc.service.TyhPaymentService;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 支付工具类
 */
public interface TyhPaymentClient {

    static TyhPaymentClient create(Options options) {
        return new TyhPaymentService(options);
    }

    /**
     * 单笔交易
     */
    TyhResponse trade(TradeCmd cmd) throws Exception;

    /**
     * 关闭单笔交易订单
     */
    TyhResponse closeTrade(TradeCloseCmd cmd) throws Exception;

    /**
     * 合并订单交易请求
     */
    TyhResponse mergeTrade(MergeTradeCmd cmd) throws Exception;

    /**
     * 关闭合并交易订单
     */
    TyhResponse closeMergeTrade(MergeTradeCloseCmd cmd) throws Exception;

}
