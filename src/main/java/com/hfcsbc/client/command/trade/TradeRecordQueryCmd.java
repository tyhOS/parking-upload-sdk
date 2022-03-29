package com.hfcsbc.client.command.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author wangdong
 * @dateTime 2021/11/29
 * @description 交易记录查询cmd
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradeRecordQueryCmd {

    /**
     * 开放平台服务商ID
     */
    private Long osPartnerId;

    /**
     * 开放平台商户ID
     */
    private Long osMerchantId;

    /**
     * 开放平台商户门店ID
     */
    private Long osStoreId;

    /**
     * 商户订单号
     */
    private String osTradeNo;

    /**
     * 第三方支付单号
     */
    private String tpTradeNo;

    /**
     * 创建开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdStartDate;

    /**
     * 创建结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdEndDate;

    /**
     * 交易状态
     */
    private String tradeStatus;

    /**
     * 支付渠道
     */
    private String payChannel;

    /**
     * 支付产品类型
     */
    private String payProduct;

    /**
     * 支付宝、微信商户账号
     */
    private String tpMerchantId;

    /**
     * 订单唯一标识
     */
    private String ownerTradeNo;

    /**
     * 当前页
     */
    private Integer page = 0;

    /**
     * 每页查询数
     */
    private Integer size = 20;

}
