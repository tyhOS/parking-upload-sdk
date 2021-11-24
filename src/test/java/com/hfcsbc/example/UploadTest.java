package com.hfcsbc.example;

import com.hfcsbc.client.TyhUploadClient;
import com.hfcsbc.client.command.upload.OpenParkingDriveInCmd;
import com.hfcsbc.client.command.upload.OpenParkingDriveOutCmd;
import com.hfcsbc.client.command.upload.OpenParkingSurplusCmd;
import com.hfcsbc.client.model.TyhResponse;
import com.hfcsbc.constants.TyhConstants;
import com.hfcsbc.constants.TyhOptions;
import org.junit.Test;

public class UploadTest {
    public static final Long OS_STORE_ID = 300001L;
    public static final String ACCESS_ID  = "16327134271655855";
    public static final String SECRET_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCkF3fmmuHSl5vzJNBFUImPj5RJhpX32IKKizk6WfS+zvtNjoBItxbUBbKXcnt6PqCsH/hol0ofQVN7VvJorwNYRk12XNbMUIyek8TBVIBzwloAj4kyUlxv2YaEVakbUP8lJzW50WtqOrJs+DH2if6M6OSq/hEzrmnYIPdcezOnysYZGAwmrY+mtuPaPiLsWmNjYMEE+XnJfSq9/UcMC+gdUuLtwKUvSRjqKv0xIqZJEnR9OI872/6feWiC4PFVxOHjlPYZQGhNmnftXzgofcx9jlknHq+1DpOm4a/YUnDPMn57AmIDJAh/tiUwoIRttt2YxCSH1ykH45HuhdSfP+0XAgMBAAECggEAB0snwC9INFUa0G7ldv9CbggivjXmOpL8Em5nx8kx0L1gfC0GVLUWpavvKT4kcOWRvLTbFMMMv2Dm9geCVNbanjTZwpYT0hcOeQn2Z+V6pCqSV44JuhvhEfOoP/+Sua0a+irI/45oaNtdDOznQ58UmmzLpTIPz61D9SBZ/llXjXCqUSb6Fr0neBI1BHewBCZxjdiyl8+1yc7XuBnHYkvdDNn6o0yqKvgbt34OIo0MyG5hlgfG2spkWZJzwKXaOoCYx+RWTm7QZCg09BuuE5LZDO4PLLBng82FZykO28Ty8cKkoaZRt/8qXPQNFv7E41OPHCOOx6bpbuBqPZYpjfx8WQKBgQD6bU2TOLkJX+hopq8No1ROdyCibir+HJ2p417Uu/ZSR09gVQCfF8b2sC07r7jPP0qhEYFf2c9rC8KLDy+QRZAxRKQkImhv3eC53MzEqnjbhOx5jQ1N9Tu6iadt9CaxQ0BgQPnKn7QcDlol7Xvn2xDkpwQSG4f3BOpuxQh69NsnMwKBgQCnvk7jpKPrJS0fTjaLJi6fDDek6nGKCtnroq6pfv3TpFuc2VETZOh0seHXmTaTU6zBuGeS/cES1UqnZVChzRRTElG8ipACuJ1vS3wzZ3C3sRY4S/pWvvEPt4H3pXCsPPnnttSIa7VRlZ5Bm+qILQR+uiZ2Jo7m+qNENJ2ArA9SjQKBgHQyjWE3W5w+9S7B0M3qMC8sVWco6Sf5jSqMBq98+6FX1zvilSQ8uyQxwPtF4OHBA1bTMY2RGg4Yac9uX2p47Jv/to3RrVXixOhYzGaglu18suD/kuHOXUWDo72AIQf1JYTEAWOEUOUHv8qDdA+z9RWzbU8dmSwECucU44dx39JDAoGBAIw70G4FpTgfc1KZq4W3HQDAUQChMtxp5/dToNt4nDFEVYaSM3KYSLHOSHVa1EJkkKe/R2+ejrv07p11WOx7q4MrbIPH/08XEh8KJ0I+NwCKnn3gHuBIbvVpv9DOUZzcuTvbIGEQUpxrDcvh0jeYEwrzCtZ5s7wsSzPpHMeGkKS9AoGBAO3UyIaEa6OIpA/Y985lw5jE1fW+suunf1/Htv/cG1fteOKlt+eCsdvjXADNgJaPcz2jHNZBur9vtn/3BQXqO2fz4RiSZuqG9t/eKgyvmEY2H7lgrrU4Zg8Q5w8e4UKyIuw9gNcjMnrOnJz1AHyCT2CbpyMBly/1f8n4fhg4/yXY";

    @Test
    public void UploadTest1(){
        // 创建上传数据client
        TyhUploadClient client = TyhUploadClient.create(TyhOptions.builder()
                .accessId(ACCESS_ID)
                .secretKey(SECRET_KEY)
                .build());

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


//        TyhResponse reponse = client.uploadDriveOut(cmd);

//        OpenParkingSurplusCmd openParkingSurplusCmd = OpenParkingSurplusCmd.builder()
//                .parkingCode(PARKING_CODE)
//                .total(20)
//                .surplus(10).build();

//        try {
//            TyhResponse reponse = uploadClient.uploadSurplus(openParkingSurplusCmd);
//            if (!reponse.ifSuccess()) {
//                System.out.println("调用失败，错误码="+ reponse.getCode() + "，失败原因="+reponse.getMsg());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("调用失败，失败原因="+e.getMessage());
//        }
    }

}
