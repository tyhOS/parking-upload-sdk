import com.hfcsbc.client.TyhPaymentClient;
import com.hfcsbc.client.TyhUploadClient;
import com.hfcsbc.client.command.trade.TradeQuery;
import com.hfcsbc.client.command.upload.OpenParkingDriveInCmd;
import com.hfcsbc.client.command.upload.OpenParkingDriveOutCmd;
import com.hfcsbc.client.dto.trade.TradeQueryResultDto;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.constants.PayConstant;
import com.hfcsbc.constants.TyhConstants;
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

    public static final String LC_ACCESS_ID = "16399969350096021"; // 刘翀RSA2商户的

    public static final String LC_SECRET_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCD4U/qo7v4b+5g\n" +
            "PwAijiVvZ73xbtaqTFMMVonCW3kFi+y0+iKizSL/mhTb7QmcBbvGmYxyIox3/TLL\n" +
            "MFxhJ08stdsSrW5r4BwcdC80EwyO2ciA6gN3BCH7+uaZmDr++6+WrLlVbXUXBNlA\n" +
            "hsDFlcwTD9o1KxHJXL2zUYuSIGWPjS/1VWfoiLajp//kLOB8S1Jkxi/bFaNRzU4G\n" +
            "Z98H0Hwrv1HvGkO4h18m86qrqru7LgTNlcPdqercp4t7lT/th6FdDE8qsYlXrfGq\n" +
            "ExYNq0Sw95njZmmJACFCGq0dM4s5vE3hAE9t+p/98FoNDoj3yPiU7VFQ8TfHwzJD\n" +
            "AP86hONzAgMBAAECggEABaR6OtvOiw6e8FdBtjjGuUGDCvVnEdo6I2kAc+ReBTK7\n" +
            "afLZ0IVeXflFszMtGhPUuOaQ78EyqV+X8MGc8jswVAVj3iS1eMAZ8820x1GZU/NV\n" +
            "dM6OX2U53wIZI7EztP0nwhaZx2HrhJSchvo8/TcviBFBkMzK8gaZxzZR9mqUbdPY\n" +
            "Bo2MontPjOaZUH8ZyCuQ/+H6vPjM6Md5FMrnMlBtFj8PEjm+ptSaJ06sZ2bNqYnq\n" +
            "hpe6mUMt6PaGkw6dpm21XtZlKbIRqbyszI0ZdJVXDMJg31ltPxIaWBH2SgUlrMhT\n" +
            "wk02HyEAgxNnz/0lFlJoP7j4OkYuAwXxUFZvayvUQQKBgQD/sqVRkbAd/IzRmM/J\n" +
            "9Z+beenv0/dvjDrZqL7qUPRhAVKXa3+t21y4GqVgJFoQthJGdwNJmnCUYFmPLeBL\n" +
            "DAfQMg4DSTJAjnclJBV8H5XUKuY4enjQ6D/VDA+2WFXDHUUFWj5mTtWL/zN8DLK8\n" +
            "x48fOEIMuSI/M4deyR/3G4WeyQKBgQCECTV069mBoFYjyVExneuENLjzzF01dBln\n" +
            "7NEgyp1ZASUH0VC8hZao4d40D/gxvqopqIjfshSHaIthUUAHxoiZm9v34NZCOvDQ\n" +
            "yzQybUfensVFf1wx9qF+C0mPyUzT/ILrhwi4J5/QyuNQXKo3PQ3Kj1HM4P4OA/yd\n" +
            "8yVYURjiWwKBgQDRtbzst2YQUe9Uf9X7t52dsFFzRw9qx0IE/ecG2jpzzNfmJF5l\n" +
            "QsI6pG/5+BZ+GjXG4RkrJqUqrBMH4QJRyp4l3MetXjz+wVlqdrvAP09s4XpL2/Z2\n" +
            "r+SaYPgJ/0znZ3wSNb9zvThbR4T8OpXlSm5RlpxlPvmdiC+AR8gVrNbcMQKBgFr+\n" +
            "Ma3zQAF6awLcoa0NBRsmbnPt2iqVaVDavsDXgZquFEQP95EEi3C1wDmm68f0ezac\n" +
            "ZD+tbUJoRO37XaI+KzOZWv24IFCiaAWslLtP3qDIUHF1tSblriO8SaTi+KR7OApz\n" +
            "FAo9nID64a8nPVM2K0P2g0wrnkoway67O3hi40BTAoGAT/qvEoolXQrXJN2ahIaq\n" +
            "Giqopi6BQVC6fT4Cs7Afccq9UAqo4nzMkDAIcspPIJe65UZPyqUNkmLTmxAl7xUB\n" +
            "XurQ2eQEZx2yFGZWnyIBzEl6rzoPXOHM+knNuva2cQVibt1Dne6vvWdaEOcBo4E3\n" +
            "McSals11axfnozYJoquz/ug=";

    @Test
    public void testDriveIn() {
        TyhUploadClient client = TyhUploadClient.create(TyhOptions.builder()
                .restHost("https://stagingjiguang.hfcsbc.com")
                .accessId(LC_ACCESS_ID)
                .secretKey(LC_SECRET_KEY)
                .build());


        // 车辆入场
        OpenParkingDriveInCmd cmd = OpenParkingDriveInCmd.builder()
                .osStoreId(3163999803024009L)
                .carPlate("新A10086")
                .carPlateColor(TyhConstants.CarPlateColor.BLUE)
                .orderId("order21321111")
                .inTime(1675382471000L)
                .inChannel("东入口")
                .build();

        // 发送请求 result.ifSuccess()表示请求成功
        try {
            Results result = client.uploadDriveIn(cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDriveOut() {
        TyhUploadClient client = TyhUploadClient.create(TyhOptions.builder()
                .restHost("https://stagingjiguang.hfcsbc.com")
                .accessId(LC_ACCESS_ID)
                .secretKey(LC_SECRET_KEY)
                .build());


        // 车辆入场
        OpenParkingDriveOutCmd cmd = OpenParkingDriveOutCmd.builder()
                .osStoreId(3163999803024009L)
                .carPlate("新A10086")
                .carPlateColor(TyhConstants.CarPlateColor.BLUE)
                .orderId("order21321111")
                .inTime(1672545930000L)
                .outTime(1672546110000L)
                .duration(1800)
                .parkType(TyhConstants.ParkType.TEMPORARY)
                .billingAmount(500)
                .payAmount(500)
                .payType(TyhConstants.PayType.ALIPAY)
                .inChannel("东入口")
                .outChannel("西出口")
                .build();

        // 发送请求 result.ifSuccess()表示请求成功
        try {
            Results result = client.uploadDriveOut(cmd);
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
