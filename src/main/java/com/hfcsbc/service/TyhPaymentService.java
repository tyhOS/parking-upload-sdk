package com.hfcsbc.service;

import com.alibaba.fastjson.JSON;
import com.hfcsbc.client.TyhPaymentClient;
import com.hfcsbc.client.command.payment.MergeTradeCloseCmd;
import com.hfcsbc.client.command.payment.MergeTradeCmd;
import com.hfcsbc.client.command.payment.TradeCloseCmd;
import com.hfcsbc.client.command.payment.TradeCmd;
import com.hfcsbc.client.model.TyhRequest;
import com.hfcsbc.client.model.TyhResponse;
import com.hfcsbc.constants.Options;
import com.sun.org.apache.bcel.internal.generic.RET;
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
    public static final String TRADE_PATH = "/trade/open";
    public static final String TRADE_CLOSE_PATH = "/trade/close/open";
    public static final String MERGE_TRADE_PATH = "/trade/merge/open";
    public static final String MERGE_TRADE_CLOSE_PATH = "/trade/close/merge/open";

    private Options options;

    private TyhRestConnection restConnection;

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
    public TyhResponse trade(TradeCmd cmd) throws Exception {
        return generalPostRequest(cmd, TRADE_PATH);
    }

    @Override
    public TyhResponse closeTrade(TradeCloseCmd cmd) throws Exception {
        return generalPostRequest(cmd, TRADE_CLOSE_PATH);
    }

    @Override
    public TyhResponse mergeTrade(MergeTradeCmd cmd) throws Exception {
        return generalPostRequest(cmd, MERGE_TRADE_PATH);
    }

    @Override
    public TyhResponse closeMergeTrade(MergeTradeCloseCmd cmd) throws Exception {
        return generalPostRequest(cmd, MERGE_TRADE_CLOSE_PATH);
    }
}
