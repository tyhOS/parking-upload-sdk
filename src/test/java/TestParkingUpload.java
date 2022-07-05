import com.alibaba.fastjson.JSON;
import com.hfcsbc.client.TyhUploadClient;
import com.hfcsbc.client.command.upload.OpenParkingCheckRecordCmd;
import com.hfcsbc.client.command.upload.OpenParkingDriveInCmd;
import com.hfcsbc.client.command.upload.OpenParkingDriveOutCmd;
import com.hfcsbc.client.command.upload.OpenParkingUIDCmd;
import com.hfcsbc.client.dto.OpenParkingCheckRecordDto;
import com.hfcsbc.client.dto.OpenParkingUIDDto;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.constants.TyhConstants;
import com.hfcsbc.constants.TyhOptions;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author Liu Chong
 * @DateTime 2022/7/4
 * @Description xxx
 */
@Slf4j
public class TestParkingUpload {

    public static final String STAGING_HOST = "http://stagingjiguang.hfcsbc.com:8282";
    public static final String ACCESS_ID = "16399969350096021";
    public static final String SECRET_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCD4U/qo7v4b+5g\n" +
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
    public void testUploadDriveIn() {
        // 创建上传数据client
        TyhUploadClient client = TyhUploadClient.create(TyhOptions.builder()
                .restHost(STAGING_HOST)
                .accessId(ACCESS_ID)
                .secretKey(SECRET_KEY)
                .build());

        // 车辆入场
        OpenParkingDriveInCmd cmd = OpenParkingDriveInCmd.builder()
                .osStoreId(3163999803024009l)
                .carPlate("黑A11111")
                .carPlateColor(TyhConstants.CarPlateColor.BLUE)
                .orderId("order123456615")
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

    @Test
    public void testUploadDriveOut() {
        // 创建上传数据client
        TyhUploadClient client = TyhUploadClient.create(TyhOptions.builder()
                .restHost(STAGING_HOST)
                .accessId(ACCESS_ID)
                .secretKey(SECRET_KEY)
                .build());

        // 车辆出场
        OpenParkingDriveOutCmd cmd = OpenParkingDriveOutCmd.builder()
                .osStoreId(3163999803024009l)
                .carPlate("测A12352")
                .carPlateColor(TyhConstants.CarPlateColor.BLUE)
                .orderId("order123456613")
                .inTime(System.currentTimeMillis() - 60 * 1000)
                .outTime(System.currentTimeMillis())
                .duration(60)
                .parkType(TyhConstants.ParkType.TEMPORARY)
                .billingAmount(500)
                .payAmount(500)
                .inChannel("东入口")
                .outChannel("西出口")
                .payType(TyhConstants.PayType.ALIPAY)
                .build();


        // 发送请求 result.ifSuccess()表示请求成功
        try {
            Results result = client.uploadDriveOut(cmd);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCheckRecord() {
        // 创建上传数据client
        TyhUploadClient client = TyhUploadClient.create(TyhOptions.builder()
                .restHost(STAGING_HOST)
                .accessId(ACCESS_ID)
                .secretKey(SECRET_KEY)
                .build());

        // 停车场日对账
        OpenParkingCheckRecordCmd cmd = OpenParkingCheckRecordCmd.builder()
                .osStoreId(3163999803024009l)
                .checkDate(DateUtil.strToDate("2022-07-04", "yyyy-MM-dd"))
                .driveInNum(2)
                .driveOutNum(2)
                .build();

        // 发送请求 result.ifSuccess()表示请求成功
        try {
            Results<OpenParkingCheckRecordDto> results = client.uploadCheckRecord(cmd);
            log.info(JSON.toJSONString(results));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    public void testCheckRecordOrderId() {
        // 创建上传数据client
        TyhUploadClient client = TyhUploadClient.create(TyhOptions.builder()
                .restHost(STAGING_HOST)
                .accessId(ACCESS_ID)
                .secretKey(SECRET_KEY)
                .build());

        // 对账日开放平台order_id获取
        OpenParkingUIDCmd cmd = OpenParkingUIDCmd.builder()
                .osStoreId(3163999803024009l)
                .checkDate(DateUtil.strToDate("2022-07-04", "yyyy-MM-dd"))
                .type(TyhConstants.DriveType.DRIVE_IN)
                .build();

        // 发送请求 result.ifSuccess()表示请求成功
        try {
            Results<OpenParkingUIDDto> results = client.uploadUID(cmd);
            log.info(JSON.toJSONString(results));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
