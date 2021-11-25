package com.hfcsbc.example;

import com.hfcsbc.client.TyhPaymentClient;
import com.hfcsbc.client.command.trade.TradeCloseCmd;
import com.hfcsbc.client.command.trade.TradeCmd;
import com.hfcsbc.client.command.trade.TradeQuery;
import com.hfcsbc.client.dto.trade.TradePayDto;
import com.hfcsbc.client.dto.trade.TradeQueryResultDto;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.constants.PayConstant;
import com.hfcsbc.constants.TyhOptions;
import org.junit.Test;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/25
 * @Description xxx
 */
public class PaymentTest {

    public static final Long OS_STORE_ID = 300001L;
    public static final String ACCESS_ID  = "16327134271655855";
    public static final String SECRET_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCkF3fmmuHSl5vzJNBFUImPj5RJhpX32IKKizk6WfS+zvtNjoBItxbUBbKXcnt6PqCsH/hol0ofQVN7VvJorwNYRk12XNbMUIyek8TBVIBzwloAj4kyUlxv2YaEVakbUP8lJzW50WtqOrJs+DH2if6M6OSq/hEzrmnYIPdcezOnysYZGAwmrY+mtuPaPiLsWmNjYMEE+XnJfSq9/UcMC+gdUuLtwKUvSRjqKv0xIqZJEnR9OI872/6feWiC4PFVxOHjlPYZQGhNmnftXzgofcx9jlknHq+1DpOm4a/YUnDPMn57AmIDJAh/tiUwoIRttt2YxCSH1ykH45HuhdSfP+0XAgMBAAECggEAB0snwC9INFUa0G7ldv9CbggivjXmOpL8Em5nx8kx0L1gfC0GVLUWpavvKT4kcOWRvLTbFMMMv2Dm9geCVNbanjTZwpYT0hcOeQn2Z+V6pCqSV44JuhvhEfOoP/+Sua0a+irI/45oaNtdDOznQ58UmmzLpTIPz61D9SBZ/llXjXCqUSb6Fr0neBI1BHewBCZxjdiyl8+1yc7XuBnHYkvdDNn6o0yqKvgbt34OIo0MyG5hlgfG2spkWZJzwKXaOoCYx+RWTm7QZCg09BuuE5LZDO4PLLBng82FZykO28Ty8cKkoaZRt/8qXPQNFv7E41OPHCOOx6bpbuBqPZYpjfx8WQKBgQD6bU2TOLkJX+hopq8No1ROdyCibir+HJ2p417Uu/ZSR09gVQCfF8b2sC07r7jPP0qhEYFf2c9rC8KLDy+QRZAxRKQkImhv3eC53MzEqnjbhOx5jQ1N9Tu6iadt9CaxQ0BgQPnKn7QcDlol7Xvn2xDkpwQSG4f3BOpuxQh69NsnMwKBgQCnvk7jpKPrJS0fTjaLJi6fDDek6nGKCtnroq6pfv3TpFuc2VETZOh0seHXmTaTU6zBuGeS/cES1UqnZVChzRRTElG8ipACuJ1vS3wzZ3C3sRY4S/pWvvEPt4H3pXCsPPnnttSIa7VRlZ5Bm+qILQR+uiZ2Jo7m+qNENJ2ArA9SjQKBgHQyjWE3W5w+9S7B0M3qMC8sVWco6Sf5jSqMBq98+6FX1zvilSQ8uyQxwPtF4OHBA1bTMY2RGg4Yac9uX2p47Jv/to3RrVXixOhYzGaglu18suD/kuHOXUWDo72AIQf1JYTEAWOEUOUHv8qDdA+z9RWzbU8dmSwECucU44dx39JDAoGBAIw70G4FpTgfc1KZq4W3HQDAUQChMtxp5/dToNt4nDFEVYaSM3KYSLHOSHVa1EJkkKe/R2+ejrv07p11WOx7q4MrbIPH/08XEh8KJ0I+NwCKnn3gHuBIbvVpv9DOUZzcuTvbIGEQUpxrDcvh0jeYEwrzCtZ5s7wsSzPpHMeGkKS9AoGBAO3UyIaEa6OIpA/Y985lw5jE1fW+suunf1/Htv/cG1fteOKlt+eCsdvjXADNgJaPcz2jHNZBur9vtn/3BQXqO2fz4RiSZuqG9t/eKgyvmEY2H7lgrrU4Zg8Q5w8e4UKyIuw9gNcjMnrOnJz1AHyCT2CbpyMBly/1f8n4fhg4/yXY";

    @Test
    public void tradeTest()  {

        TyhPaymentClient client = TyhPaymentClient.create(TyhOptions.builder()
                .accessId(ACCESS_ID)
                .secretKey(SECRET_KEY)
                .allowUpload(Boolean.TRUE)
                .build());

        TradeCmd tradeCmd = TradeCmd.builder()
                .osMerchantId(2293839381L)
                .osStoreId(39819018L)
                .ownerTradeNo("owner_trade_32192182")
                .payChannel(PayConstant.PayChannel.ALI_PAY)
                .payProduct(PayConstant.PayProductCode.MINI_APP)
                .payBusiness("支付业务类别")
                .title("支付标题")
                .remark("给支付平台的附加信息，支付平台会原封回调给对用方")
                .orderFee(1) //订单金额，最小单位分
                .timeExpire("2021-11-26 20:18:39")
                .notifyUrl("https开头的回调地址")
                .buyerId("仅小程序或手机网页支付必传")
                .build();

        try {
            Results<TradePayDto> results = client.trade(tradeCmd);
            //获取支付结果
            TradePayDto dto = results != null && results.ifSuccess() ? results.getData() : null;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void tradeClose() {
        TyhPaymentClient client = TyhPaymentClient.create(TyhOptions.builder()
                .accessId(ACCESS_ID)
                .secretKey(SECRET_KEY)
                .allowUpload(Boolean.TRUE)
                .build());

        TradeCloseCmd cmd = TradeCloseCmd.builder()
                .ownerTradeNo("1292103218")
                .osTradeNo("329121821")   //参数二选一，至少填一个
                .build();

        try {
            Results<String> results = client.closeTrade(cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tradeQuery() {
        TyhPaymentClient client = TyhPaymentClient.create(TyhOptions.builder()
                .accessId(ACCESS_ID)
                .secretKey(SECRET_KEY)
                .allowUpload(Boolean.TRUE)
                .build());

        TradeQuery query = TradeQuery.builder()
                .ownerTradeNo("3213213123")
                .osTradeNo("31239128112")
                .build();

        try {
            Results<TradeQueryResultDto> results = client.tradeQuery(query);
            // 获取支付查询结果
            TradeQueryResultDto dto = results != null && results.ifSuccess() ? results.getData() : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
