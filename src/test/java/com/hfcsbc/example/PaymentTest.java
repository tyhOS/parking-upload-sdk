package com.hfcsbc.example;

import com.alibaba.fastjson.JSON;
import com.hfcsbc.client.TyhPaymentClient;
import com.hfcsbc.client.command.trade.TradeCmd;
import com.hfcsbc.client.command.trade.TradeMergeCmd;
import com.hfcsbc.client.dto.trade.TradeMergePayDto;
import com.hfcsbc.client.dto.trade.TradePayDto;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.constants.PayConstant;
import com.hfcsbc.constants.TyhOptions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Liu Chong
 * @DateTime 2021/11/25
 * @Description xxx
 */
public class PaymentTest {

    public static final String ACCESS_ID  = "16373180971704771";
    public static final String SECRET_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCNkZ2ix1vBH4VFK29wkg18BOHy4AxLupglYqVwkp++a2fl6e9Q9sF7NlGADeoLnHfpJHIsgyxBpoKiJ23WPHOYPN4p9UljPyfsfZkTAE10MmpcfkAvNUWlurBvEzYR6QiXsaZdRM008NGtOOzjALCnASZXbefvWsuo5RofK/n7EweWMvVmCx1hRLX5OlkjCd7Z3+VDOpEuNtdUpsC2ASqDWsJanrePtJbX2xCaZQH40NCMvNeIJNobMNXjuUB46Nfy6X7DDIYJCWm9K+tvIVOqj30Qd77vV3lOUigIzBnQSZNT5Vm+HLk3IcptL5qvy2yqScyq7NZIGSZiSyVuJ/gLAgMBAAECggEADt9eZSx2ejp6gMLIaVYeronAxwg8onQO6daMNOBigdm8x42lA6d4uh4Bv+c2UFP20PpwODbrnlYE4U4tHtWo+zRhzpyjQhbvdcvYGgPtHyjwvZjR22PIVlnfkTu+cXE+4tjZ9nB08nveO0mAsXRwGotnYMX+GMo8HRk8fkvbbkHwboy5+tYwovm2QA3D2zeZRm9c+bZ7NrhwratqZTSkHnmgMbHQd75KcN92G/jcz6kxxhz0T7jyJgtoZYF/40UqHC8hsV4hK/QkwqL3kB6T8MF3FhBpb2iAt4Z/39nEm5IGl/hyNpN3Ot54Kj6tQ7fIVU+B+g+iAMcbFTxQy6zJUQKBgQDMmUT0Oh9lbbG0KbTpCoTiOtcgqFr+iUJNpziZG5EH40ziUaUjTpvbVy27EkV6EDD/SPSefqLs5fpDdnDikU+lSqvwMYMXtrvk5w4aVt7WePQZd543lPdfEpwWgCI9lC1/jMkYf6E8L1rOW/7PIpzh0g2LTtY+fGhVKB9cefncyQKBgQCxIpbna6UXgPcq8WTLkJnwdhwpcMQZDQENq6RdMnAWBB8HSaJ0etmEBUXRvdpEs2qOZkwhNx7gtwhzFd76Q8V3xB5BBl7DR6guD6XI8tlfXHaMGye0WavWj3mO3L72eRCn/IoyLzZfrl11xn9OHvjGXrrGoxVwG15HHpqpT+McMwKBgQCSKQQrfMIlEWIblJfay1r2ypYYjGzE3YVyN/2k0x6ehfDM1Qql2GhbH0JaG8lqU9rM5G9sModtuTU5sIkgMjK1oEyIQLan4DEGa1GV221BxhKLhvqONmspjf/Xyx2q5ApEzmxyherHNgUm2m2Dx/RPFmH6nQ1Mgk9+VjVhOPoYkQKBgDlO2ommrvPquoy/KoAdmWBNphDWNetw5J1aocOxNMg6rxs5fIC42jS3S/5usPY3IctOV2ULo0bKkMZDFi/by0BTSAJ7oB8HyOaWE2nu/9q1XHk5s9/KfyjcpFRPIM03H+dpcgCIe8v66qvW+4r3xD7RmRX430+02wyhXyJWAUE3AoGBAIs761FlkuQkc5aNdoDAYGq1Ko0QSVjpPDAdPZL4kKluc9Am+xC1oHiXaVBVpLzecWgtPIOwtojHKmcpaF4wXPEfSE1NqiXpFAegMOFJchKUX1yfRlf6x4HYh1ithw9lbnYXHxa+KKte8Y39yYbOHtUl1CM0XiDG3Ud34YAmevqz";
    public static final Long OS_MERCHANT_ID  = 2163737276721967L;
    public static final Long OS_STORE_ID  = 3163757684139653L;


    @Test
    public void paymentTest() {

        TyhPaymentClient client = TyhPaymentClient.create(TyhOptions.builder()
                .restHost("http://192.168.1.42:9008")
                .accessId(ACCESS_ID)
                .secretKey(SECRET_KEY)
                .allowUpload(Boolean.TRUE)
                .build());

//        TradeCmd tradeCmd = TradeCmd.builder()
//                .osMerchantId(2163737276721967L)
//                .osStoreId(3163757684139653L)
//                .ownerTradeNo("owner_trade_118888806")
//                .payChannel(PayConstant.PayChannel.ALI_PAY)
//                .payProduct(PayConstant.PayProduct.USER_QR)
//                .title("支付标题")
//                .remark("给支付平台的附加信息，支付平台会原封回调给对用方")
//                .orderFee(1) //订单金额，最小单位分
//                .timeExpire("2021-11-26 20:18:39")
//                .notifyUrl("https开头的回调地址")
//                .build();



        TradeMergeCmd.SubTradeCmd subCmd01 = TradeMergeCmd.SubTradeCmd.builder()
                .ownerTradeNo("qi_000000000000005")
                .orderFee(1)
                .title("iPhone13 Pro Max")
                .osMerchantId(OS_MERCHANT_ID)
                .build();

        TradeMergeCmd.SubTradeCmd subCmd02 = TradeMergeCmd.SubTradeCmd.builder()
                .ownerTradeNo("qi_000000000000006")
                .orderFee(2)
                .title("iPhone12 Pro Max")
                .osMerchantId(OS_MERCHANT_ID)
                .build();

        List<TradeMergeCmd.SubTradeCmd> subList = Arrays.asList(subCmd01, subCmd02);



        TradeMergeCmd cmd = TradeMergeCmd.builder()
                .payChannel(PayConstant.PayChannel.WX_PAY)
                .payProduct(PayConstant.PayProduct.USER_QR)
                .timeExpire(String.valueOf(System.currentTimeMillis() + 1000 * 60 * 10))
                .subTradeOrders(subList)
                .build();

        String json = JSON.toJSONString(cmd);



        try {
            Results<TradeMergePayDto> results = client.mergeTrade(cmd);
            //获取支付结果
            TradeMergePayDto dto = results.getData();
            String json1 = JSON.toJSONString(dto);
            int i = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
