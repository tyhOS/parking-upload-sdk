import com.hfcsbc.client.TyhPaymentClient;
import com.hfcsbc.client.command.trade.TradeQuery;
import com.hfcsbc.client.dto.trade.TradeQueryResultDto;
import com.hfcsbc.constants.PayConstant;
import com.hfcsbc.constants.TyhOptions;
import org.junit.Test;

import java.util.Date;

/**
 * @Author Liu Chong
 * @DateTime 2022/7/8
 * @Description xxx
 */
public class TestTrade {

    public static final String ACCESS_ID = "16481765499390950"; //  路外测试服务商的

    public static final String SECRET_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC9YLWdRR+cWRSgQy02DV2PMujGeklpGbvbLi7uyi8it8qa94UaZHfqu4HQEZEm2rkXcO/bVUAYBUcXeKRAl4wvpiVJcKtP4mAp5w1/OWKLwJcVb8b6Cbh+tehvRufixcpwmEKNXKmy83TsUFUoqcETWN6JPyVry78UsLZQR+xBf2sIBKevUOAol6zntjeneUAgv4R48lxnotgVHl68wEOSoHTtDvfGvTTGnbob4X37+5W0eZeCzioOKk1zqEXPTZd7TOW8//2aLFRxdp8AerF0LhcyM6u5YUGuJJXyzKG9gD76ixSvtc+xsh+WGcO2uSY6XR/2VK3aE/syWc3atF3VAgMBAAECggEAN4P+OZhl5+OFVGXc/xdz8eKusmBu3MyacWpcf8vtfXP7hOpCrrX9IWbOazx7HLTJxcFpzxZyr5f8ezj2jajfg6hlDd5lmgl2v1Hodv9PkEBpCfO2lN38o8iX1ucmWyg4bEF2YRJk/Py5rfzuufjpjM5kjj9grPURkvMqvuYWsCw0y0ye58UnyboONiRmFkW15ubehHxJn9yasZzlAEadI0TXOMZJcCOEp5cQJEI22k7falSZb+rGZQB8u4jEW8+xKEUrq20tIolqfiPoOFNPTmvexWZW1ZisAt6/XUYSxOHGHj8CB/mW+aX93h1Js9oj87bSJ3foeNvOmRqyaxrJkQKBgQDq2O5Km6E7xBzRC3P5xFGskiShXTHjh3J5nJ1E5UA8MkNRwQHNFGpyS2QeuJC9tyoB+EjssD9sEn5EDfjTCeeiuehPT78hx0xzeFtbgggpx0IA+Yzml5o0RHtG71E94Tf3XAPcaZ0k6EO6nFN52VF6uWa+nkQHeQw+vZYwzAWAVwKBgQDOb1ksJGvnWisfcTKRiGMp2t35E5zkl9TD+kubL3NFciPA3YU45TZJcun69sPkFFiQJeJEG0GIa2dc+Kq0v7HKAmNPKBypFf+hw+GPw17d/5n9J0LGrbJZvpW3v3O23M7gKeSLYdFCVDYrW2DOx6kf/i42ug5pgAwPiegvBajHswKBgEJVOaFLKhRmhTkqgfyHTgZvVPdbCm9Y36Wn7ef61NTr4YXi/S4+2P4le0cOHJvpc20RAxAPjCprYsy4IZMCVjHpTsuwG61fzKFE2pETPlkGlgcOdZTgN0cSHLvhdtICnjs4+0IzdpZpIFBCPXXKQzBl07Z9n3t43lOOWzC3P8qLAoGAPeyC2E34nEadBuqC28sIzAZebZfniV7OMReE1IFQV7Wcaf9JNj7zoOa6r1CUhHdh9aOXkwyGBPEK6YWiV2PlZg5/UcBbkJELxK+omuJlM7y3qYu8aTKzfF5CNQNWJ7VmzTFj4DewePAf67OWf5C+99zcagg3yIfjlkms/2X4MicCgYBUwlXt9DiVIRWUuRaGL6nd0ND7PAbAN0tvXR272xc4dmzJE5Tboe5biplb8XgUmqVlSsE3qRlI8oxSDu/ScLSjEPjiJgyUOb7Jc7QKPJkNoBBIDq7yr3KolHC1/QY2Nx2ZTDT8DtWNOjyeQ6uK3SnXUJFbAgx20M1hvRkG7CMvPA==";


    @Test
    public void testTradeQuery() {
        TradeQuery tradeQuery = TradeQuery.builder().ownerBusinessNo(String.valueOf(212541201711120L)).build();
        try {

            // 创建上传数据client
            TyhPaymentClient tyhPaymentClient = TyhPaymentClient.create(TyhOptions.builder()
                    .restHost("https://stagingjiguang.hfcsbc.com")
                    .accessId(ACCESS_ID)
                    .secretKey(SECRET_KEY)
                    .build());

            TradeQueryResultDto dto = tyhPaymentClient.tradeQuery(tradeQuery).getData();
            if (dto != null) {
                Integer duration = 30;
                Date payDate = new Date(dto.getCreatedTime());
                Date currentDate = new Date();
                int durationSec = duration * 60;  // 若5分钟内有发起支付并未付款，则判定存在缴费中的记录。（这里考虑调整成动态的）
                Boolean ifTrue = PayConstant.TradeStatus.WAIT.equals(dto.getTradeStatus())
                        && getBetweenSec(payDate, currentDate) < durationSec;
                int i  = ifTrue.compareTo(Boolean.TRUE);
                System.currentTimeMillis();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 两个时间之差
     * @return 秒
     */
    public static Integer getBetweenSec(Date startDate, Date endDate) {
        int minutes = 0;
        if (startDate != null && endDate != null) {
            long ss = endDate.getTime() - startDate.getTime();
            minutes = (int) (ss / 1000);
        }

        return minutes;
    }

}
