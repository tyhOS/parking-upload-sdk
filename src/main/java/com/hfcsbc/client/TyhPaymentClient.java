package com.hfcsbc.client;

import com.hfcsbc.client.command.trade.*;
import com.hfcsbc.client.model.TyhRequest;
import com.hfcsbc.client.model.TyhTradeResponse;
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
     * 获取用户在支付平台的buyerId(openId)
     */
    TyhTradeResponse obtainBuyerId(TradeBuyerIdQuery query) throws Exception;

    /**
     * 单笔交易
     */
    TyhTradeResponse trade(TradeCmd cmd) throws Exception;

    /**
     * 关闭单笔交易订单
     */
    TyhTradeResponse closeTrade(TradeCloseCmd cmd) throws Exception;

    /**
     * 合并订单交易请求
     */
    TyhTradeResponse mergeTrade(TradeMergeCmd cmd) throws Exception;

    /**
     * 关闭合并交易订单
     */
    TyhTradeResponse closeMergeTrade(TradeMergeCloseCmd cmd) throws Exception;

    /**
     * 查询交易结果
     */
    TyhTradeResponse tradeQuery(TradeQuery query) throws Exception;

    /**
     * 查询很大交易结果
     */
    TyhTradeResponse tradeMergeQuery(TradeMergeQuery query) throws Exception;

    /**
     * 请求单笔退款
     */
    TyhTradeResponse tradeRefund(TradeRefundCmd cmd) throws Exception;

    /**
     * 查询交易退款结果
     */
    TyhTradeResponse tradeRefundQuery(TradeRefundQuery query) throws Exception;


    /**
     * 根据传参，获取加密后的请求参数
     */
    TyhRequest obtainSignRequestParam(Object param)  throws Exception;


}
