package com.hfcsbc.client.dto.credit;

import com.hfcsbc.constants.PayConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: qdl
 * Email: 18919656953@163.com
 * Date: 2022/3/7
 * Description: 这里添加描述
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditPayTradeDto {

    /**
     * 商户订单号
     */
    private String ownerTradeNo;

    /**
     * 开放平台给支付平台的商家订单号
     */
    private String osTradeNo;

    /**
     * 支付平台订单号
     */
    private String tpTradeNo;

    /**
     * 交易状态
     */
    @PayConstant.TradeStatus
    private String tradeStatus;

    /**
     * 交易的订单金额 单位为分
     */
    private Integer orderFee;

    /**
     * 交易的实付金额 单位为分
     */
    private Integer paymentFee;

    /**
     * 商户给开放平台的的附加数据，支付平台原封不动返回
     */
    private String remark;

    /**
     * 商户编号
     */
    private String osMerchantCode;

    /**
     * 门店编号
     */
    private String osStoreCode;

    /**
     * 下单时间 时间戳，精确到毫秒
     */
    private Long createdTime;

    /**
     * 支付完成时间 时间戳，精确到毫秒
     */
    private Long payTime;

    /**
     * 支付api来源
     */
    @PayConstant.PayApiSourceCode
    private String payApiSource;

    /**
     * 支付渠道
     */
    @PayConstant.PayChannel
    private String payChannel;

    /**
     * 支付产品类型
     */
    @PayConstant.PayProduct
    private String payProduct;

    /**
     * 支付标题
     */
    private String title;

    /**
     * 业务类型
     */
    private String payBusiness;

    /**
     * 买家在支付机构的登录账号，支付宝独有参数
     */
    private String buyerLoginId;

    /**
     * 退款金额, 单位为分
     */
    private Integer refundFee;

    /**
     * 子商户应用对应用户ID,openId
     */
    private String ownerAppBuyerId;

    /**
     * 商户维护:商户创建的订单业务号
     */
    private String ownerBusinessNo;

    /**
     * 商户支付终端
     */
    private String ownerPayTerminal;

}
