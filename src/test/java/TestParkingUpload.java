import com.alibaba.fastjson.JSON;
import com.hfcsbc.client.TyhUploadClient;
import com.hfcsbc.client.command.upload.OpenParkingDriveInCmd;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.constants.TyhConstants;
import com.hfcsbc.constants.TyhOptions;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestParkingUpload {

    public static final String ACCESS_ID = "16399969350096021";
    public static final String SECRET_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCD4U/qo7v4b+5g" +
            "PwAijiVvZ73xbtaqTFMMVonCW3kFi+y0+iKizSL/mhTb7QmcBbvGmYxyIox3/TLL" +
            "MFxhJ08stdsSrW5r4BwcdC80EwyO2ciA6gN3BCH7+uaZmDr++6+WrLlVbXUXBNlA" +
            "hsDFlcwTD9o1KxHJXL2zUYuSIGWPjS/1VWfoiLajp//kLOB8S1Jkxi/bFaNRzU4G" +
            "Z98H0Hwrv1HvGkO4h18m86qrqru7LgTNlcPdqercp4t7lT/th6FdDE8qsYlXrfGq" +
            "ExYNq0Sw95njZmmJACFCGq0dM4s5vE3hAE9t+p/98FoNDoj3yPiU7VFQ8TfHwzJD" +
            "AP86hONzAgMBAAECggEABaR6OtvOiw6e8FdBtjjGuUGDCvVnEdo6I2kAc+ReBTK7" +
            "afLZ0IVeXflFszMtGhPUuOaQ78EyqV+X8MGc8jswVAVj3iS1eMAZ8820x1GZU/NV" +
            "dM6OX2U53wIZI7EztP0nwhaZx2HrhJSchvo8/TcviBFBkMzK8gaZxzZR9mqUbdPY" +
            "Bo2MontPjOaZUH8ZyCuQ/+H6vPjM6Md5FMrnMlBtFj8PEjm+ptSaJ06sZ2bNqYnq" +
            "hpe6mUMt6PaGkw6dpm21XtZlKbIRqbyszI0ZdJVXDMJg31ltPxIaWBH2SgUlrMhT" +
            "wk02HyEAgxNnz/0lFlJoP7j4OkYuAwXxUFZvayvUQQKBgQD/sqVRkbAd/IzRmM/J" +
            "9Z+beenv0/dvjDrZqL7qUPRhAVKXa3+t21y4GqVgJFoQthJGdwNJmnCUYFmPLeBL" +
            "DAfQMg4DSTJAjnclJBV8H5XUKuY4enjQ6D/VDA+2WFXDHUUFWj5mTtWL/zN8DLK8" +
            "x48fOEIMuSI/M4deyR/3G4WeyQKBgQCECTV069mBoFYjyVExneuENLjzzF01dBln" +
            "7NEgyp1ZASUH0VC8hZao4d40D/gxvqopqIjfshSHaIthUUAHxoiZm9v34NZCOvDQ" +
            "yzQybUfensVFf1wx9qF+C0mPyUzT/ILrhwi4J5/QyuNQXKo3PQ3Kj1HM4P4OA/yd" +
            "8yVYURjiWwKBgQDRtbzst2YQUe9Uf9X7t52dsFFzRw9qx0IE/ecG2jpzzNfmJF5l" +
            "QsI6pG/5+BZ+GjXG4RkrJqUqrBMH4QJRyp4l3MetXjz+wVlqdrvAP09s4XpL2/Z2" +
            "r+SaYPgJ/0znZ3wSNb9zvThbR4T8OpXlSm5RlpxlPvmdiC+AR8gVrNbcMQKBgFr+" +
            "Ma3zQAF6awLcoa0NBRsmbnPt2iqVaVDavsDXgZquFEQP95EEi3C1wDmm68f0ezac" +
            "ZD+tbUJoRO37XaI+KzOZWv24IFCiaAWslLtP3qDIUHF1tSblriO8SaTi+KR7OApz" +
            "FAo9nID64a8nPVM2K0P2g0wrnkoway67O3hi40BTAoGAT/qvEoolXQrXJN2ahIaq" +
            "Giqopi6BQVC6fT4Cs7Afccq9UAqo4nzMkDAIcspPIJe65UZPyqUNkmLTmxAl7xUB" +
            "XurQ2eQEZx2yFGZWnyIBzEl6rzoPXOHM+knNuva2cQVibt1Dne6vvWdaEOcBo4E3" +
            "McSals11axfnozYJoquz/ug=";


    @Test
    public void uploadDriveIn() {

        // 创建上传数据client
        TyhUploadClient client = TyhUploadClient.create(TyhOptions.builder()
                .restHost("https://stagingjiguang.hfcsbc.com")
                .accessId(ACCESS_ID)
                .secretKey(SECRET_KEY)
                .build());

        // 车辆入场
        OpenParkingDriveInCmd cmd = OpenParkingDriveInCmd.builder()
                .osStoreId(3163999803024009L)
                .carPlate("黑C12345")
                .carPlateColor(TyhConstants.CarPlateColor.BLUE)
                .orderId("order123456700")
                .inTime(System.currentTimeMillis())
                .inChannel("东入口")
                .build();

        // 发送请求 result.ifSuccess()表示请求成功
        try {
            Results result = client.uploadDriveIn(cmd);
            log.info(JSON.toJSONString(result));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}