package com.hfcsbc.example;

import com.hfcsbc.client.TyhUploadClient;
import com.hfcsbc.client.command.upload.*;
import com.hfcsbc.client.dto.OpenParkingCheckRecordDto;
import com.hfcsbc.client.dto.OpenParkingUIDDto;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.client.model.TyhRequest;
import com.hfcsbc.constants.TyhConstants;
import com.hfcsbc.constants.TyhOptions;
import org.junit.Test;

import java.util.Date;

public class UploadTest {


    public static final String ACCESS_ID  = "16373180971704771";
    public static final String SECRET_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCNkZ2ix1vBH4VFK29wkg18BOHy4AxLupglYqVwkp++a2fl6e9Q9sF7NlGADeoLnHfpJHIsgyxBpoKiJ23WPHOYPN4p9UljPyfsfZkTAE10MmpcfkAvNUWlurBvEzYR6QiXsaZdRM008NGtOOzjALCnASZXbefvWsuo5RofK/n7EweWMvVmCx1hRLX5OlkjCd7Z3+VDOpEuNtdUpsC2ASqDWsJanrePtJbX2xCaZQH40NCMvNeIJNobMNXjuUB46Nfy6X7DDIYJCWm9K+tvIVOqj30Qd77vV3lOUigIzBnQSZNT5Vm+HLk3IcptL5qvy2yqScyq7NZIGSZiSyVuJ/gLAgMBAAECggEADt9eZSx2ejp6gMLIaVYeronAxwg8onQO6daMNOBigdm8x42lA6d4uh4Bv+c2UFP20PpwODbrnlYE4U4tHtWo+zRhzpyjQhbvdcvYGgPtHyjwvZjR22PIVlnfkTu+cXE+4tjZ9nB08nveO0mAsXRwGotnYMX+GMo8HRk8fkvbbkHwboy5+tYwovm2QA3D2zeZRm9c+bZ7NrhwratqZTSkHnmgMbHQd75KcN92G/jcz6kxxhz0T7jyJgtoZYF/40UqHC8hsV4hK/QkwqL3kB6T8MF3FhBpb2iAt4Z/39nEm5IGl/hyNpN3Ot54Kj6tQ7fIVU+B+g+iAMcbFTxQy6zJUQKBgQDMmUT0Oh9lbbG0KbTpCoTiOtcgqFr+iUJNpziZG5EH40ziUaUjTpvbVy27EkV6EDD/SPSefqLs5fpDdnDikU+lSqvwMYMXtrvk5w4aVt7WePQZd543lPdfEpwWgCI9lC1/jMkYf6E8L1rOW/7PIpzh0g2LTtY+fGhVKB9cefncyQKBgQCxIpbna6UXgPcq8WTLkJnwdhwpcMQZDQENq6RdMnAWBB8HSaJ0etmEBUXRvdpEs2qOZkwhNx7gtwhzFd76Q8V3xB5BBl7DR6guD6XI8tlfXHaMGye0WavWj3mO3L72eRCn/IoyLzZfrl11xn9OHvjGXrrGoxVwG15HHpqpT+McMwKBgQCSKQQrfMIlEWIblJfay1r2ypYYjGzE3YVyN/2k0x6ehfDM1Qql2GhbH0JaG8lqU9rM5G9sModtuTU5sIkgMjK1oEyIQLan4DEGa1GV221BxhKLhvqONmspjf/Xyx2q5ApEzmxyherHNgUm2m2Dx/RPFmH6nQ1Mgk9+VjVhOPoYkQKBgDlO2ommrvPquoy/KoAdmWBNphDWNetw5J1aocOxNMg6rxs5fIC42jS3S/5usPY3IctOV2ULo0bKkMZDFi/by0BTSAJ7oB8HyOaWE2nu/9q1XHk5s9/KfyjcpFRPIM03H+dpcgCIe8v66qvW+4r3xD7RmRX430+02wyhXyJWAUE3AoGBAIs761FlkuQkc5aNdoDAYGq1Ko0QSVjpPDAdPZL4kKluc9Am+xC1oHiXaVBVpLzecWgtPIOwtojHKmcpaF4wXPEfSE1NqiXpFAegMOFJchKUX1yfRlf6x4HYh1ithw9lbnYXHxa+KKte8Y39yYbOHtUl1CM0XiDG3Ud34YAmevqz";
    public static final Long OS_MERCHANT_ID  = 2163737276721967L;
    public static final Long OS_STORE_ID  = 3163757684139653L;

    @Test
    public void UploadTest1(){
        // 创建上传数据client
//        TyhUploadClient client = TyhUploadClient.create(TyhOptions.builder()
//                .restHost("https://devjiguang.hfcsbc.com")
//                .accessId(ACCESS_ID)
//                .secretKey(SECRET_KEY)
//                .build());

        // 上传余位数据
//        OpenParkingSurplusCmd cmd = OpenParkingSurplusCmd.builder()
//                .osStoreId(OS_STORE_ID)
//                .total(20)
//                .surplus(10)
//                .build();

        // 车辆入场
//        OpenParkingDriveInCmd cmd = OpenParkingDriveInCmd.builder()
//                .osStoreId(OS_STORE_ID)
//                .carPlate("皖Axxxxx")
//                .carPlateColor(TyhConstants.CarPlateColor.BLUE)
//                .orderId("order123456662")
//                .inTime(inTime)
//                .inChannel("东入口")
//                .build();

        // 车辆出场
//        OpenParkingDriveOutCmd cmd = OpenParkingDriveOutCmd.builder()
//                .osStoreId(OS_STORE_ID)
//                .carPlate("皖Axxxxx")
//                .carPlateColor(TyhConstants.CarPlateColor.BLUE)
//                .orderId("order123456662")
//                .inTime(inTime)
//                .outTime(outTime)
//                .duration(1800)
//                .parkType(TyhConstants.ParkType.TEMPORARY)
//                .billingAmount(500)
//                .payAmount(500)
//                .inChannel("东入口")
//                .outChannel("西出口")
//                .build();

        // 图片上传
//        OpenParkingImageCmd cmd = OpenParkingImageCmd.builder()
//                .osStoreId(OS_STORE_ID)
//                .carPlate("皖Axxxxx")
//                .carPlateColor(TyhConstants.CarPlateColor.BLUE)
//                .orderId("order123456662")
//                .content("https://ossweb.hfcsbc.com/tyh/asset/app-icon.png")
//                .source(TyhConstants.ImageSource.DRIVE_IN)
//                .imageType(TyhConstants.ImageType.URL)
//                .build();

//        // 心跳数据
//        OpenParkingHeartbeatCmd cmd = OpenParkingHeartbeatCmd.builder()
//                .osStoreId(OS_STORE_ID)
//                .uploadTime(System.currentTimeMillis())
//                .build();

        // 停车场日对账
//        OpenParkingCheckRecordCmd cmd = OpenParkingCheckRecordCmd.builder()
//                .osStoreId(OS_STORE_ID)
//                .checkDate(DateUtil.stringToDate("2021-11-11", "yyyy-MM-dd"))
//                .driveInNum(200)
//                .driveOutNum(203)
//                .build();

        // 对账日开放平台order_id获取
//        OpenParkingUIDCmd cmd = OpenParkingUIDCmd.builder()
//                .osStoreId(OS_STORE_ID)
//                .checkDate(DateUtil.stringToDate("2021-11-11", "yyyy-MM-dd"))
//                .type(TyhConstants.DriveType.DRIVE_IN)
//                .build();

//        Results<OpenParkingUIDDto> results = client.uploadUID(cmd);

//        OpenParkingSurplusCmd openParkingSurplusCmd = OpenParkingSurplusCmd.builder()
//                .parkingCode(PARKING_CODE)
//                .total(20)
//                .surplus(10).build();

//        try {
//            Results reponse = client.uploadImage(cmd);
//            if (!reponse.ifSuccess()) {
//                System.out.println("调用失败，错误码="+ reponse.getCode() + "，失败原因="+reponse.getMsg());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("调用失败，失败原因="+e.getMessage());
//        }
    }

}
