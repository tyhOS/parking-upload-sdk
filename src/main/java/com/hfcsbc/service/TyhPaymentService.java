package com.hfcsbc.service;

import com.alibaba.fastjson.JSON;
import com.hfcsbc.client.TyhPaymentClient;
import com.hfcsbc.client.command.trade.*;
import com.hfcsbc.client.dto.trade.*;
import com.hfcsbc.client.model.TyhRequest;
import com.hfcsbc.client.model.TyhResponse;
import com.hfcsbc.client.model.TyhTradeResponse;
import com.hfcsbc.constants.Options;
import org.bouncycastle.util.encoders.Base64;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 支付service
 */
public class TyhPaymentService implements TyhPaymentClient {

    public static final String SIGN_TYPE = "RSA";

    /* -------------------------- 交易和关闭 -------------------------- */
    public static final String TRADE_PATH = "/trade/open";
    public static final String TRADE_CLOSE_PATH = "/trade/close/open";
    public static final String MERGE_TRADE_PATH = "/trade/merge/open";
    public static final String MERGE_TRADE_CLOSE_PATH = "/trade/close/merge/open";

    /* -------------------------- 交易查询 -------------------------- */
    public static final String TRADE_QUERY_PATH = "/query/trade";
    public static final String TRADE_MERGE_QUERY_PATH = "/query/merge/trade";
    public static final String TRADE_REFUND_QUERY_PATH = "/query/refund";

    /* -------------------------- 退款相关 --------------------------- */
    public static final String TRADE_REFUND_PATH = "/refund/open";


    private final Options options;

    private final TyhRestConnection restConnection;

    public TyhPaymentService(Options options) {
        this.options = options;
        restConnection = new TyhRestConnection(options);
    }

    public TyhResponse generalPostRequest(Object object, String path) throws Exception {
        byte[] data = JSON.toJSONString(object).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(new Date().getTime()).signType(SIGN_TYPE)
                .data(new String(Base64.encode(data))).build();
        return restConnection.executePostWithSignature(path, tyhRequest);
    }

    @Override
    public TyhTradeResponse trade(TradeCmd cmd) throws Exception {
        return TyhTradeResponse.build(generalPostRequest(cmd, TRADE_PATH), TradePayDto.class);
    }

    @Override
    public TyhTradeResponse closeTrade(TradeCloseCmd cmd) throws Exception {
        return TyhTradeResponse.build(generalPostRequest(cmd, TRADE_CLOSE_PATH));
    }

    @Override
    public TyhTradeResponse mergeTrade(TradeMergeCmd cmd) throws Exception {
        return TyhTradeResponse.build(generalPostRequest(cmd, MERGE_TRADE_PATH), TradeMergePayDto.class);
    }

    @Override
    public TyhTradeResponse closeMergeTrade(TradeMergeCloseCmd cmd) throws Exception {
        return TyhTradeResponse.build(generalPostRequest(cmd, MERGE_TRADE_CLOSE_PATH));
    }

    @Override
    public TyhTradeResponse tradeQuery(TradeQuery query) throws Exception {
        return TyhTradeResponse.build(generalPostRequest(query, TRADE_QUERY_PATH), TradeQueryResultDto.class);
    }

    @Override
    public TyhTradeResponse tradeMergeQuery(TradeMergeQuery query) throws Exception {
        return TyhTradeResponse.build(generalPostRequest(query, TRADE_MERGE_QUERY_PATH), TradeMergeQueryResultDto.class);
    }

    @Override
    public TyhTradeResponse tradeRefund(TradeRefundCmd cmd) throws Exception {
        return TyhTradeResponse.build(generalPostRequest(cmd, TRADE_REFUND_PATH));
    }

    @Override
    public TyhTradeResponse tradeRefundQuery(TradeRefundQuery query) throws Exception {
        return TyhTradeResponse.build(generalPostRequest(query, TRADE_REFUND_QUERY_PATH), TradeRefundResultDto.class);
    }
}
