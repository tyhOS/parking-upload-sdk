package com.hfcsbc.constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author CaptainSir
 * @Email zhaopgfw@dingtalk.com
 * @Date 2021/11/4
 * @Desc 支付模块相关常量
 */
public class PayConstant {

    public static final String MERGE_TAG = "merge:";

    /**
     * 分账接收方类型
     * MERCHANT_ID 商户
     * PERSONAL_OPENID 个人
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface ProfitSharReceiverType {
        String MERCHANT_ID = "MERCHANT_ID";
        String PERSONAL_OPENID = "PERSONAL_OPENID";
    }

    /**
     * 结算类型,资金清算或清分以后,将钱解冻
     * REAL_TIME 实时
     * T_N 工作日+N
     * D_N 自然日+N
     * M_N 自然月+N
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface SettleType {
        Integer REAL_TIME = 1;
        Integer T_N = 2;
        Integer D_N = 3;
        Integer M_N = 4;
    }

    /**
     * 分账方式
     * NO 不需要分账
     * NEED 需要分账
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface ProfitSharType {
        Integer NO = 1;
        Integer NEED = 2;
    }

    /**
     * 分账关系类型
     * SUPPLIER：供应商
     * DISTRIBUTOR：分销商
     * SERVICE_PROVIDER：服务商
     * PLATFORM：平台
     * OTHERS：其他
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface ProfitSharRelationType {
        String SUPPLIER = "SUPPLIER";
        String DISTRIBUTOR = "DISTRIBUTOR";
        String SERVICE_PROVIDER = "SERVICE_PROVIDER";
        String PLATFORM = "PLATFORM";
        String OTHERS = "OTHERS";
    }

    /**
     * 交易状态
     * WAIT：交易创建，等待买家付款
     * SUCCESS: 支付成功
     * SUCCESS_PART_REFUND: 支付成功有部分退款
     * SUCCESS_FULL_REFUND: 支付成功全额退款
     * FAILURE：支付失败（包含用户取消支付、超时关闭）
     * CLOSE：已关闭，订单超过操作时限
     * REFUNDING: 退款中
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface TradeStatus {
        String WAIT = "WAIT";
        String SUCCESS = "SUCCESS";
        String SUCCESS_PART_REFUND = "SUCCESS_PART_REFUND";
        String SUCCESS_FULL_REFUND = "SUCCESS_FULL_REFUND";
        String FAILURE = "FAILURE";
        String CLOSED = "CLOSED";
        String REFUNDING = "REFUNDING";
    }


    /**
     * 退款状态
     * WAIT 退款申请创建
     * SUCCESS 退款成功
     * FAILURE 退款失败
     * CLOSE  关闭
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface RefundStatus {
        String WAIT = "WAIT";
        String SUCCESS = "SUCCESS";
        String FAILURE = "FAILURE";
        String CLOSED = "CLOSED";
    }

    /**
     * 支付api来源
     * THIRD_PART_DIRECT 三方支付机构直连 (微信/支付宝/工商银行/建设银行/招商银行)
     * ICBC_AGG 工商银行聚合支付
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface PayApiSourceCode {
        String THIRD_PART_DIRECT = "THIRD_PART_DIRECT";
        String ICBC_AGG = "ICBC_AGG";
    }


    /**
     * 平台侧优惠类型 1开放平台 2开放平台服务商 3开放平台商户
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface OSDiscountType {
        Integer OS = 1;
        Integer OS_PARTNER = 2;
        Integer OS_MERCHANT = 3;
    }


    /**
     * 支付渠道 = 支付机构
     * ALI_PAY 支付宝
     * WX_PAY 微信
     * CCB 建行龙支付
     * ICBC 工银e支付
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface PayChannel {
        String ALI_PAY = "ALI_PAY";
        String WX_PAY = "WX_PAY";
        String CCB = "CCB";
        String CMB = "CMB";
        String ICBC = "ICBC";
    }

    /**
     * 支付产品类型
     * APP
     * MINI_APP(小程序)
     * M_WEB(手机网站支付)
     * PC_WEB(电脑网站支付)
     * USER_QR(用户扫码，扫商家码)
     * MCH_QR(商家扫码，扫用户码)
     * FACE(刷脸支付)
     * CREDIT(无感支付)
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface PayProduct {
        String APP = "APP";
        String MINI_APP = "MINI_APP";
        String M_WEB = "M_WEB";
        String PC_WEB = "PC_WEB";
        String USER_QR = "USER_QR";
        String MCH_QR = "MCH_QR";
        String FACE = "FACE";
        String H5 = "H5";
        String CREDIT = "CREDIT";
    }

    /**
     * 结算状态
     * INIT 初始状态,生成支付订单,但是用户还未支付
     * WAIT 未结算,等待结算给商家
     * SUCCESS  已结算给商家账户，但是还没有分成
     * NO_NEED  无需结算,该订单未支付成功或已全额退款
     * EXCEPTION 结算异常
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface SettleStatus {
        Integer INIT = 0;
        Integer WAIT = 1;
        Integer SUCCESS = 2;
        Integer NO_NEED = 3;
        Integer EXCEPTION = 4;
    }

    /**
     * 分账状态
     * INIT 无需分账
     * WAIT 待分账
     * SUCCESS  分账成功
     * EXCEPTION 失败/异常
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface ProfitSharStatus {
        Integer INIT = 0;
        Integer WAIT = 1;
        Integer SUCCESS = 2;
        Integer EXCEPTION = 3;
    }

    /**
     * 回调状态
     * WAIT  等待回调,可能是回调到业务方提示错误了,需要继续回调
     * SUCCESS 回调业务方成功,为了保证消息的快速处理,此状态的记录可能会清除
     * FAILURE 回调失败
     * IGNORE 忽略回调,超过最大回调次数,不再调用商户
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface CallbackStatus {
        String WAIT = "WAIT";
        String IGNORE = "IGNORE";
        String SUCCESS = "SUCCESS";
        String FAILURE = "FAILURE";
    }

    /**
     * 审核状态
     * INIT 等待审核
     * SUCCESS 审核成功
     * REFUSE 审核拒绝
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface ApprovedStatus {
        Integer INIT = 1;
        Integer SUCCESS = 2;
        Integer REFUSE = 3;
    }


}
