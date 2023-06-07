package com.hfcsbc.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hfcsbc.client.TyhPaymentClient;
import com.hfcsbc.client.command.credit.CreditPayCarStatusCmd;
import com.hfcsbc.client.command.credit.CreditPayTradeCmd;
import com.hfcsbc.client.command.trade.*;
import com.hfcsbc.client.dto.credit.CreditPayCarStatusDto;
import com.hfcsbc.client.dto.credit.CreditPayTradeDto;
import com.hfcsbc.client.dto.trade.*;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.client.model.TyhRequest;
import com.hfcsbc.constants.Options;
import com.hfcsbc.utils.Page;
import org.bouncycastle.util.encoders.Base64;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/22
 * @Description 支付service
 */
public class TyhPaymentService implements TyhPaymentClient {

    public static final String SIGN_TYPE = "RSA2";
    public static final String APPLICATION_NAME = "/os-base";

    /* -------------------------- 支付鉴权 -------------------------- */
    public static final String TRADE_BUYER_ID_PATH = APPLICATION_NAME + "/trade/auth/sign/buyerId/v1/open";

    /* -------------------------- 交易和关闭 -------------------------- */
    public static final String TRADE_PATH = APPLICATION_NAME + "/trade/v2/open";

    public static final String TRADE_CLOSE_PATH = APPLICATION_NAME + "/trade/close/v1/open";
    public static final String MERGE_TRADE_PATH = APPLICATION_NAME + "/trade/merge/v2/open";
    public static final String MERGE_TRADE_CLOSE_PATH = APPLICATION_NAME + "/trade/close/merge/v1/open";

    /* -------------------------- 交易查询 -------------------------- */
    public static final String TRADE_QUERY_PATH = APPLICATION_NAME + "/query/trade/v1/open";
    public static final String TRADE_MERGE_QUERY_PATH = APPLICATION_NAME + "/query/merge/trade/v1/open";
    public static final String TRADE_REFUND_QUERY_PATH = APPLICATION_NAME + "/query/refund/v1/open";
    public static final String TRADE_RECORD_QUERY_PATH = APPLICATION_NAME + "/tradeRecord/queryPage/v1/open";
    public static final String TRADE_RECORD_TOTAL_QUERY_PATH = APPLICATION_NAME + "/tradeRecord/queryTotal/v1/open";

    /* -------------------------- 退款相关 --------------------------- */
    public static final String TRADE_REFUND_PATH = APPLICATION_NAME + "/refund/v1/open";
    public static final String CREDIT_REFUND_PATH = APPLICATION_NAME + "/refund/credit/v1/open";

    /* -------------------------- 多码合一 --------------------------- */
    public static final String MULTI_QR_TRADE = APPLICATION_NAME + "/trade/multiQR/v2/open";
    public static final String MULTI_QR_MERGE_TRADE = APPLICATION_NAME + "/trade/multiQR/merge/v2/open";


    /**
     * 无感支付
     */
    public static final String CREDIT_TRADE_PATH = APPLICATION_NAME + "/trade/credit/v2/open";             // 无感支付申请扣款
    public static final String CREDIT_CAR_STATUS = APPLICATION_NAME + "/trade/credit/carStatus/v1/open";   // 查询车牌是否可用无感支付



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
    public Results<Page<TradeRecordNormalDto>> tradeRecordQuery(TradeRecordQueryCmd query) throws Exception {
        Page<TradeRecordNormalDto> page = new Page<>();
        Results<Page<TradeRecordNormalDto>> pageResults = generalPostRequest(query, TRADE_RECORD_QUERY_PATH, (Class<Page<TradeRecordNormalDto>>) page.getClass());
        if (pageResults.ifSuccess()) {
            List<TradeRecordNormalDto> tradeRecordNormalDto = JSONObject.parseArray(JSONObject.toJSONString(pageResults.getData().getContent()), TradeRecordNormalDto.class);
            pageResults.getData().setContent(tradeRecordNormalDto);
            return pageResults;
        } else {
            return Results.failure(null, pageResults.getMsg());
        }
    }

    @Override
    public Results<TradeRecordTotalDto> tradeRecordTotalQuery(TradeRecordQueryCmd cmd)  throws Exception {
        return generalPostRequest(cmd, TRADE_RECORD_TOTAL_QUERY_PATH, TradeRecordTotalDto.class);
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
    public Results<TradeMergePayDto> multiQrMergeTrade(TradeMergeCmd cmd) throws Exception {
        return generalPostRequest(cmd, MULTI_QR_MERGE_TRADE, TradeMergePayDto.class);
    }

    @Override
    public Results<CreditPayCarStatusDto> creditCarStatus(CreditPayCarStatusCmd cmd) throws Exception {
        return generalPostRequest(cmd, CREDIT_CAR_STATUS, CreditPayCarStatusDto.class);
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
