package com.hfcsbc.service;

import com.alibaba.fastjson.JSON;
import com.hfcsbc.client.TyhPaymentClient;
import com.hfcsbc.client.command.credit.CreditPayTradeCmd;
import com.hfcsbc.client.command.trade.*;
import com.hfcsbc.client.dto.credit.CreditPayTradeDto;
import com.hfcsbc.client.dto.trade.*;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.client.model.TyhRequest;
import com.hfcsbc.constants.Options;
import org.bouncycastle.util.encoders.Base64;

import java.nio.charset.StandardCharsets;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 支付service
 */
public class TyhPaymentService implements TyhPaymentClient {

    public static final String SIGN_TYPE = "RSA2";

    /* -------------------------- 支付鉴权 -------------------------- */
    public static final String TRADE_BUYER_ID_PATH = "/trade/auth/sign/buyerId/v1/open";

    /* -------------------------- 交易和关闭 -------------------------- */
    public static final String TRADE_PATH = "/trade/v1/open";
    public static final String CREDIT_TRADE_PATH = "/trade/credit/v1/open";
    public static final String TRADE_CLOSE_PATH = "/trade/close/v1/open";
    public static final String MERGE_TRADE_PATH = "/trade/merge/v1/open";
    public static final String MERGE_TRADE_CLOSE_PATH = "/trade/close/merge/v1/open";

    /* -------------------------- 交易查询 -------------------------- */
    public static final String TRADE_QUERY_PATH = "/query/trade/v1/open";
    public static final String TRADE_MERGE_QUERY_PATH = "/query/merge/trade/v1/open";
    public static final String TRADE_REFUND_QUERY_PATH = "/query/refund/v1/open";

    /* -------------------------- 退款相关 --------------------------- */
    public static final String TRADE_REFUND_PATH = "/refund/v1/open";
    public static final String CREDIT_REFUND_PATH = "/refund/credit/v1/open";

    /* -------------------------- 多码合一 --------------------------- */
    public static final String MULTI_QR_TRADE = "/trade/multiQR/v1/open";


    private final Options options;

    private final TyhRestConnection restConnection;

    public TyhPaymentService(Options options) {
        this.options = options;
        restConnection = new TyhRestConnection(options);
    }

    public <T> Results<T> generalPostRequest(Object object, String path, Class<T> dtoClass) throws Exception {
        byte[] data = JSON.toJSONString(object).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis()).signType(SIGN_TYPE)
                .data(new String(Base64.encode(data))).build();
        return restConnection.executePostWithSignature(path, tyhRequest, dtoClass);
    }

    @Override
    public Results<String> obtainBuyerId(TradeBuyerIdQuery query) throws Exception {
        return generalPostRequest(query, TRADE_BUYER_ID_PATH, String.class);
    }

    @Override
    public Results<TradePayDto> trade(TradeCmd cmd) throws Exception {
        return generalPostRequest(cmd, TRADE_PATH, TradePayDto.class);
    }

    @Override
    public Results<String> closeTrade(TradeCloseCmd cmd) throws Exception {
        return generalPostRequest(cmd, TRADE_CLOSE_PATH, String.class);
    }

    @Override
    public Results<TradeMergePayDto> mergeTrade(TradeMergeCmd cmd) throws Exception {
        return generalPostRequest(cmd, MERGE_TRADE_PATH, TradeMergePayDto.class);
    }

    @Override
    public Results<String> closeMergeTrade(TradeMergeCloseCmd cmd) throws Exception {
        return generalPostRequest(cmd, MERGE_TRADE_CLOSE_PATH, String.class);
    }

    @Override
    public Results<TradeQueryResultDto> tradeQuery(TradeQuery query) throws Exception {
        return generalPostRequest(query, TRADE_QUERY_PATH, TradeQueryResultDto.class);
    }

    @Override
    public Results<TradeMergeQueryResultDto> tradeMergeQuery(TradeMergeQuery query) throws Exception {
        return generalPostRequest(query, TRADE_MERGE_QUERY_PATH, TradeMergeQueryResultDto.class);
    }

    @Override
    public Results<TradeRefundDto> tradeRefund(TradeRefundCmd cmd) throws Exception {
        return generalPostRequest(cmd, TRADE_REFUND_PATH, TradeRefundDto.class);
    }

    @Override
    public Results<TradeRefundResultDto> tradeRefundQuery(TradeRefundQuery query) throws Exception {
        return generalPostRequest(query, TRADE_REFUND_QUERY_PATH, TradeRefundResultDto.class);
    }

    @Override
    public TyhRequest obtainSignRequestParam(Object param) throws Exception {
        byte[] data = JSON.toJSONString(param).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis()).signType(SIGN_TYPE)
                .data(new String(Base64.encode(data))).build();
        return restConnection.obtainSignRequestParam(tyhRequest);
    }

    @Override
    public Results<TradePayDto> multiQRTrade(TradeCmd cmd) throws Exception {
        return generalPostRequest(cmd, MULTI_QR_TRADE, TradePayDto.class);
    }

    @Override
    public Results<CreditPayTradeDto> creditTrade(CreditPayTradeCmd cmd) throws Exception {
        return generalPostRequest(cmd, CREDIT_TRADE_PATH, CreditPayTradeDto.class);
    }

    @Override
    public Results<TradeRefundResultDto> creditRefund(TradeRefundCmd cmd) throws Exception {
        return generalPostRequest(cmd, CREDIT_REFUND_PATH, TradeRefundResultDto.class);
    }

}
