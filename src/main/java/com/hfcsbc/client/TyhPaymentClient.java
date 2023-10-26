package com.hfcsbc.client;

import com.hfcsbc.client.command.credit.CreditPayCarStatusCmd;
import com.hfcsbc.client.command.credit.CreditPayTradeCmd;
import com.hfcsbc.client.command.creditagreement.*;
import com.hfcsbc.client.command.trade.*;
import com.hfcsbc.client.dto.credit.CreditPayCarStatusDto;
import com.hfcsbc.client.dto.credit.CreditPayTradeDto;
import com.hfcsbc.client.dto.creditagreement.CreditAgreementOrderAndSignDto;
import com.hfcsbc.client.dto.creditagreement.CreditAgreementPaySignDto;
import com.hfcsbc.client.dto.creditagreement.CreditAgreementPayTradeResultDto;
import com.hfcsbc.client.dto.creditagreement.CreditAgreementQueryDto;
import com.hfcsbc.client.dto.trade.*;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.client.model.TyhRequest;
import com.hfcsbc.constants.Options;
import com.hfcsbc.service.TyhPaymentService;
import com.hfcsbc.utils.Page;

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
    Results<String> obtainBuyerId(TradeBuyerIdQuery query) throws Exception;

    /**
     * 单笔交易
     */
    Results<TradePayDto> trade(TradeCmd cmd) throws Exception;

    /**
     * 关闭单笔交易订单
     */
    Results<String> closeTrade(TradeCloseCmd cmd) throws Exception;

    /**
     * 合并订单交易请求
     */
    Results<TradeMergePayDto> mergeTrade(TradeMergeCmd cmd) throws Exception;

    /**
     * 关闭合并交易订单
     */
    Results<String> closeMergeTrade(TradeMergeCloseCmd cmd) throws Exception;

    /**
     * 查询交易结果
     */
    Results<TradeQueryResultDto> tradeQuery(TradeQuery query) throws Exception;

    /**
     * 查询很大交易结果
     */
    Results<TradeMergeQueryResultDto> tradeMergeQuery(TradeMergeQuery query) throws Exception;

    /**
     * 请求单笔退款
     */
    Results<TradeRefundDto> tradeRefund(TradeRefundCmd cmd) throws Exception;

    /**
     * 查询交易退款结果
     */
    Results<TradeRefundResultDto> tradeRefundQuery(TradeRefundQuery query) throws Exception;

    /**
     * 查询交易记录
     */
    Results<Page<TradeRecordNormalDto>> tradeRecordQuery(TradeRecordQueryCmd query) throws Exception;

    /**
     * 查询交易记录合计值
     */
    Results<TradeRecordTotalDto> tradeRecordTotalQuery(TradeRecordQueryCmd cmd) throws Exception;


    /**
     * 根据传参，获取加密后的请求参数
     */
    TyhRequest obtainSignRequestParam(Object param)  throws Exception;

    /**
     * 多码合一交易请求
     */
    Results<TradePayDto> multiQRTrade(TradeCmd cmd) throws Exception;

    /**
     * 多码合一交易请求
     */
    Results<TradeMergePayDto> multiQrMergeTrade(TradeMergeCmd cmd) throws Exception;

    /**
     * 查询车牌是否可用无感支付
     */
    Results<CreditPayCarStatusDto> creditCarStatus(CreditPayCarStatusCmd cmd) throws Exception;

    /**
     * 无感支付
     */
    Results<CreditPayTradeDto> creditTrade(CreditPayTradeCmd cmd) throws Exception;

    /**
     * 无感支付退款
     */
    Results<TradeRefundResultDto> creditRefund(TradeRefundCmd cmd) throws Exception;

    /**
     * 信用支付服务开通
     */
    Results<CreditAgreementPaySignDto> creditAgreementSign(CreditAgreementPaySignCmd cmd) throws Exception;

    /**
     * 信用支付下单
     */
    Results<CreditAgreementPayTradeResultDto> creditAgreementOrder(CreditAgreementPayOrderCmd cmd) throws Exception;

    /**
     * 信用支付扣款
     */
    Results<CreditAgreementPayTradeResultDto> creditAgreementTrade(CreditAgreementPayTradeCmd cmd) throws Exception;

    /**
     * 信用支付下单并签约
     */
    Results<CreditAgreementOrderAndSignDto> creditAgreementOrderAndSign(CreditAgreementOrderAndSignCmd cmd) throws Exception;

    /**
     * 信用支付服务状态查询
     */
    Results<CreditAgreementQueryDto> creditAgreementQuery(CreditAgreementPaySignQueryCmd cmd) throws Exception;
}
