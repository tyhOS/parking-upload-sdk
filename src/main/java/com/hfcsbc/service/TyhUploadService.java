package com.hfcsbc.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.hfcsbc.client.TyhUploadClient;
import com.hfcsbc.client.command.upload.*;
import com.hfcsbc.client.dto.*;
import com.hfcsbc.client.dto.trade.TradeRecordNormalDto;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.client.model.TyhRequest;
import com.hfcsbc.constants.Options;
import com.hfcsbc.constants.TyhConstants;
import com.hfcsbc.constants.TyhOptions;
import com.hfcsbc.utils.Page;
import com.hfcsbc.utils.StringUtil;
import org.bouncycastle.util.encoders.Base64;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class TyhUploadService implements TyhUploadClient {

    public static final String SIGN_TYPE = "RSA2";
    //public static final String APPLICATION_NAME = "/os-park";
    public static final String APPLICATION_NAME = "/";
    public static final String POST_UPLOAD_SURPLUS = APPLICATION_NAME + "/ospark/open/api/v2/uploadSurplus";
    public static final String POST_UPLOAD_DRIVE_IN = APPLICATION_NAME + "/ospark/open/api/v2/uploadDriveIn";
    public static final String POST_UPLOAD_DRIVE_OUT = APPLICATION_NAME + "/ospark/open/api/v2/uploadDriveOut";
    public static final String POST_UPLOAD_DRIVE_IMAGE = APPLICATION_NAME + "/ospark/open/api/v2/uploadImage";
    public static final String POST_UPLOAD_HEARTBEAT = APPLICATION_NAME + "/ospark/open/api/v2/uploadHeartbeat";
    public static final String POST_UPLOAD_CHECK_RECORD = APPLICATION_NAME + "/ospark/open/api/v2/uploadCheckRecord";
    public static final String POST_UPLOAD_UID = APPLICATION_NAME + "/ospark/open/api/v2/uploadUID";
    public static final String POST_CREDIT_PAY_SET = APPLICATION_NAME + "/ospark/open/api/v2/creditPaySet";
    public static final String POST_DOCKING_INFO = APPLICATION_NAME + "/ospark/open/api/v2/parkingDataDockingInfo";
    public static final String POST_DOCKING_STATIST = APPLICATION_NAME + "/ospark/open/api/v2/parkingDataDockingStatistics";
    public static final String POST_DRIVE_RECORD_LIST = APPLICATION_NAME + "/ospark/open/api/v2/parkingRecordList";
    public static final String POST_PARKING_STATUS = APPLICATION_NAME + "/ospark/open/api/v2/parkingStatusMap";

    private Options options;

    private TyhRestConnection restConnection;

    public TyhUploadService(Options options) {
        this.options = options;
        restConnection = new TyhRestConnection(options);
    }

    @Override
    public Results<String> uploadSurplus(OpenParkingSurplusCmd openParkingSurplusCmd) throws Exception {
        byte[] data = JSON.toJSONString(openParkingSurplusCmd).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis()).signType(SIGN_TYPE)
                .data(new String(Base64.encode(data))).build();
        return restConnection.executePostWithSignature(POST_UPLOAD_SURPLUS, tyhRequest, String.class);
    }

    @Override
    public Results<String> uploadDriveIn(OpenParkingDriveInCmd openParkingDriveInCmd) throws Exception {
        byte[] data = JSON.toJSONString(openParkingDriveInCmd).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis()).signType(SIGN_TYPE)
                .data(new String(Base64.encode(data))).build();
        return restConnection.executePostWithSignature(POST_UPLOAD_DRIVE_IN, tyhRequest, String.class);
    }

    @Override
    public Results<String> uploadDriveOut(OpenParkingDriveOutCmd openParkingDriveOutCmd) throws Exception {
        byte[] data = JSON.toJSONString(openParkingDriveOutCmd).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis()).signType(SIGN_TYPE)
                .data(new String(Base64.encode(data))).build();
        return restConnection.executePostWithSignature(POST_UPLOAD_DRIVE_OUT, tyhRequest, String.class);
    }

    @Override
    public Results<String> uploadImage(OpenParkingImageCmd openParkingImageCmd) throws Exception {
        byte[] data = JSON.toJSONString(openParkingImageCmd).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis()).signType(SIGN_TYPE)
                .data(new String(Base64.encode(data))).build();
        return restConnection.executePostWithSignature(POST_UPLOAD_DRIVE_IMAGE, tyhRequest, String.class);
    }

    @Override
    public Results<OpenParkingHeartbeatDto> uploadHeartbeat(OpenParkingHeartbeatCmd openParkingHeartbeatCmd) throws Exception {
        byte[] data = JSON.toJSONString(openParkingHeartbeatCmd).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis()).signType(SIGN_TYPE)
                .data(new String(Base64.encode(data))).build();
        return restConnection.executePostWithSignature(POST_UPLOAD_HEARTBEAT, tyhRequest, OpenParkingHeartbeatDto.class);
    }

    @Override
    public Results<OpenParkingCheckRecordDto> uploadCheckRecord(OpenParkingCheckRecordCmd cmd) throws Exception {
        byte[] data = JSON.toJSONString(cmd).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis())
                .signType(SIGN_TYPE)
                .data(new String(Base64.encode(data)))
                .build();
        return restConnection.executePostWithSignature(POST_UPLOAD_CHECK_RECORD, tyhRequest, OpenParkingCheckRecordDto.class);
    }

    @Override
    public Results<OpenParkingUIDDto> uploadUID(OpenParkingUIDCmd cmd) throws Exception {
        byte[] data = JSON.toJSONString(cmd).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis())
                .signType(SIGN_TYPE)
                .data(new String(Base64.encode(data)))
                .build();
        return restConnection.executePostWithSignature(POST_UPLOAD_UID, tyhRequest, OpenParkingUIDDto.class);
    }

    @Override
    public Results<String> creditPaySet(OpenParkingCreditPayCmd cmd) throws Exception {
        byte[] data = JSON.toJSONString(cmd).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis())
                .signType(SIGN_TYPE)
                .data(new String(Base64.encode(data)))
                .build();
        return restConnection.executePostWithSignature(POST_CREDIT_PAY_SET, tyhRequest, String.class);
    }


    @Override
    public Results<OpenParkingDockingInfoDto> dockingInfo(OpenParkingDockingInfoCmd cmd) throws Exception {
        byte[] data = JSON.toJSONString(cmd).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis())
                .signType(SIGN_TYPE)
                .data(new String(Base64.encode(data)))
                .build();
        return restConnection.executePostWithSignature(POST_DOCKING_INFO, tyhRequest, OpenParkingDockingInfoDto.class);
    }

    @Override
    public Results<OpenParkingDockingStatistDto> dockingStatist(OpenParkingDockingStatistCmd cmd) throws Exception {
        byte[] data = JSON.toJSONString(cmd).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis())
                .signType(SIGN_TYPE)
                .data(new String(Base64.encode(data)))
                .build();
        return restConnection.executePostWithSignature(POST_DOCKING_STATIST, tyhRequest, OpenParkingDockingStatistDto.class);
    }


    @Override
    public Results<Page<OpenParkingDriveRecordDto>> driveRecordList(OpenParkingDriveRecordCmd cmd) throws Exception {
        Page<OpenParkingDriveRecordDto> page = new Page<>();
        byte[] data = JSON.toJSONString(cmd).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis())
                .signType(SIGN_TYPE)
                .data(new String(Base64.encode(data)))
                .build();
        Results<Page<OpenParkingDriveRecordDto>> pageResults = restConnection.executePostWithSignature(POST_DRIVE_RECORD_LIST, tyhRequest, (Class<Page<OpenParkingDriveRecordDto>>) page.getClass());
        List<OpenParkingDriveRecordDto> dto = JSONObject.parseArray(JSONObject.toJSONString(pageResults.getData().getContent()), OpenParkingDriveRecordDto.class);
        pageResults.getData().setContent(dto);
        return pageResults;
    }

    @Override
    public Results<OpenParkingDockingStatusDto> parkingDockingStatus() throws Exception {
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis())
                .build();
        return restConnection.executePostWithSignature(POST_PARKING_STATUS, tyhRequest, OpenParkingDockingStatusDto.class);
    }


    public static void main(String[] args) throws Exception {
        //TyhUploadClient client = TyhUploadClient.create(TyhOptions.builder()
        //        .restHost("http://localhost:9010")
        //        .accessId("16481765499390950")
        //        .secretKey("MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC9YLWdRR+cWRSgQy02DV2PMujGeklpGbvbLi7uyi8it8qa94UaZHfqu4HQEZEm2rkXcO/bVUAYBUcXeKRAl4wvpiVJcKtP4mAp5w1/OWKLwJcVb8b6Cbh+tehvRufixcpwmEKNXKmy83TsUFUoqcETWN6JPyVry78UsLZQR+xBf2sIBKevUOAol6zntjeneUAgv4R48lxnotgVHl68wEOSoHTtDvfGvTTGnbob4X37+5W0eZeCzioOKk1zqEXPTZd7TOW8//2aLFRxdp8AerF0LhcyM6u5YUGuJJXyzKG9gD76ixSvtc+xsh+WGcO2uSY6XR/2VK3aE/syWc3atF3VAgMBAAECggEAN4P+OZhl5+OFVGXc/xdz8eKusmBu3MyacWpcf8vtfXP7hOpCrrX9IWbOazx7HLTJxcFpzxZyr5f8ezj2jajfg6hlDd5lmgl2v1Hodv9PkEBpCfO2lN38o8iX1ucmWyg4bEF2YRJk/Py5rfzuufjpjM5kjj9grPURkvMqvuYWsCw0y0ye58UnyboONiRmFkW15ubehHxJn9yasZzlAEadI0TXOMZJcCOEp5cQJEI22k7falSZb+rGZQB8u4jEW8+xKEUrq20tIolqfiPoOFNPTmvexWZW1ZisAt6/XUYSxOHGHj8CB/mW+aX93h1Js9oj87bSJ3foeNvOmRqyaxrJkQKBgQDq2O5Km6E7xBzRC3P5xFGskiShXTHjh3J5nJ1E5UA8MkNRwQHNFGpyS2QeuJC9tyoB+EjssD9sEn5EDfjTCeeiuehPT78hx0xzeFtbgggpx0IA+Yzml5o0RHtG71E94Tf3XAPcaZ0k6EO6nFN52VF6uWa+nkQHeQw+vZYwzAWAVwKBgQDOb1ksJGvnWisfcTKRiGMp2t35E5zkl9TD+kubL3NFciPA3YU45TZJcun69sPkFFiQJeJEG0GIa2dc+Kq0v7HKAmNPKBypFf+hw+GPw17d/5n9J0LGrbJZvpW3v3O23M7gKeSLYdFCVDYrW2DOx6kf/i42ug5pgAwPiegvBajHswKBgEJVOaFLKhRmhTkqgfyHTgZvVPdbCm9Y36Wn7ef61NTr4YXi/S4+2P4le0cOHJvpc20RAxAPjCprYsy4IZMCVjHpTsuwG61fzKFE2pETPlkGlgcOdZTgN0cSHLvhdtICnjs4+0IzdpZpIFBCPXXKQzBl07Z9n3t43lOOWzC3P8qLAoGAPeyC2E34nEadBuqC28sIzAZebZfniV7OMReE1IFQV7Wcaf9JNj7zoOa6r1CUhHdh9aOXkwyGBPEK6YWiV2PlZg5/UcBbkJELxK+omuJlM7y3qYu8aTKzfF5CNQNWJ7VmzTFj4DewePAf67OWf5C+99zcagg3yIfjlkms/2X4MicCgYBUwlXt9DiVIRWUuRaGL6nd0ND7PAbAN0tvXR272xc4dmzJE5Tboe5biplb8XgUmqVlSsE3qRlI8oxSDu/ScLSjEPjiJgyUOb7Jc7QKPJkNoBBIDq7yr3KolHC1/QY2Nx2ZTDT8DtWNOjyeQ6uK3SnXUJFbAgx20M1hvRkG7CMvPA==")
        //        .build());
        TyhUploadClient client = TyhUploadClient.create(TyhOptions.builder()
                //本地测试
                .restHost("http://localhost:9010")
                .accessId("16529280935310110")
                .secretKey("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCjL9JI8zsJpZLYzjZxrZjgt4gl+2lMBvbl2YgbQwzeXCS5sPKtkmPQJAhAKuwfzWVGdcrGt9svMFwPYn5yYD87iCAQQlTGbnIrpup93i2HKLcrZGOz9WUqZmzh6NRRYcCgv+P710lO5rSmGIv1ug5j2YKO1EFY0hv5anheIImpoKrfo+E3rdu203uXfFp1qOLJJoqxUixb2+lEed8IUqejv1jBbjmpcC3PuDiw1xMakv60muRFLVvR8gDqBC3gpGTqlm/6aw4Nqo+94klGTpI9cd90YgkcjFGsIl92XpmDO794PtGSpeqhI07J1k46IkJNMDli6L4rX5MwhzCca4P5AgMBAAECggEAZkdu0XJBqoYwR9rXnOBlVVMy7jtpf9FNpjp1aEDaK/QswIX7VHbQQICU+0Lrw/MEaukhMvPBWQ5CZRIilqVkfHeRQR+R6t0Gif2QM1uxxWjrhTLimsRPqAeSbvVzPZ67EQW0awBAXkeTKhdwgY8fvc1yWvsGChmGlwj4cGaMYdfk+gilbPfgUAOxZ7wWtX0D6HmldQsvtC4SEhcYT6L5vKwNj1GxnkIy/PJn8vgrGL3WBc1xZCOSmdOOt8Pu6rE3eEf9SFd1S/m6UmJCWlhAgL2Fga7pkrw06itT2HYjvd8NW7d3j36Qy9+LMvhgreDsAvM8UnZsWhkB27aQVbe8kQKBgQDabpy8UhC2jkf6o+EsBcdKz8ICtwE9z2G0lqsqgAMf0xF9jIW/iUz12DrDDxLVpleINQsmbueTbNf3iELsk14wjl/1QrSCPBBxoL7m8DRgHZaoXxtYt/ib9o4ZGqr2wYhsufWctX+ivjPsSVkCnw+UwA3UOqsBu8hmKeF+ZJAFzwKBgQC/QM3o21wYq1/X7w9JjOaYg2rGwhipWULl+c9WoZ5S5Gl8Z3HVCxkqD7zZcM3zG+BtrO+zKEjIPJP2g7eXN5W3QVE+aU401/cQprhOybVp1eDPbn7vNGb9F6ABB+bQhuZIoTAukC3h6PdEq7HZQ/WsWwGK8Igh/roHB3E+kacTtwKBgQChi47lhDgSG5ZGWu9MVJW40YBl65zCbt6O5aN/kh89aSeVV9kO9+dwJtQGsN44Hoa8GKa/bORd1vC+hAsi1jah6Jo1VHkVnIB42O528414zElBCt25to3qIuWi0WNBjY5tAvcQR/c2kD7scK6gzqyCUauomx8f8BZc4HqBtLQDZwKBgQCu2wLnGFcVPum7tJdXeXkCi3Q+EAsYGcHuHP0RiWYFB0viL3mFfEYfjI/uhRHmaOBBpdDpDbWtTKVCxp49pNY+23r6ArE74w/Bq4vqjMRN5PtK6w0midR3JPhmuOCwWgWE9cnlaHBqkOIxaICL0XR1hibc7pin7AoMjyNcPzJv9QKBgGVYU6m8f0ZM3VdyuO0hN8yUnTjAxWyTOIaxoZcQlasMYRq3UsDQT3CFjhkvP4uvpHych5L1q6IV/OF6924XrrKNJvVwxkoy0s5SdHU9mKQdb88UCACbMqlK0+l1SRh+GlFqZarNVTCoVZkQSrxtMmMqbbRlPPYAlYuEIZ2MjKxF")
                //线上使用
                //.restHost("https://os.hfcsbc.com")
                //.restHost("https://stagingjiguang.hfcsbc.com")
                //.accessId("16507886200710314")
                //.secretKey("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCDMItWY/f3I/YPVK55r0qvoIOGiAsWtMDrVqDpt+Vrj7JO9oDNsHimw2p+nWWNI0Zjz48YEtkar2cEHa6qZ/ggW9WGN1oimj2TUnIY80geFaMkSeTnhj87YSghxiWRyWMGondbngRihi2ccRwFoYtx9X0PczbZr+OhbDksWGQdVLn1sJ0dlZDKI8oYY8asxxEkXTs/MGEObTK/m5xw4jGQa8vEuWYwi8DrG2Rvt961NXhTRQIRT7nZT6hNkZE6WVeNsmMrNc4FiDCY8n8zYHd481yDMreNV3EZI/r930aFZCMw+39hxXtqDKiVu+hAswZVErhSyL7eYkai3VGgAtE/AgMBAAECggEAdCT1Jx3IOTfQL1B0S2zifUxpRSCKWKbcKT3/pgtWBH0qinf4HqI+nr1hOglVD7gMKG9oqxJ8vQBO/rjcmycC6HsFNhcpKHtPSm9ybh5sWZ4kWgtFqagTsRlZ81S+jCw0DHqnmyfxj9xk4xzMhzu2/cQt3RDOnbj3mUD7+QOkVsYUpYU2lTYDmqmteyOhd09Z43uKxUp3iOjMvXRM3PjzvqVr5D/PQrRLaOe1YleY+mJzma7If2ndZrQFz7L2D++TW7oNXI0GrSjyjNJ+8vbRczbNec6MJ92yuk5jY2ZcEU0C+kogvoA6JTkZTP0gck+KT/j45Mt7GYjO5I9kwXJPyQKBgQDVzj7Dfmsplm88ZHUidRvLmGM3+9vAspncSGE2UXunrRa3RaEvcYZhxaiJLL55/x6LttJ1CjnUt4ZVfbLA0m7AHJ7PNqtr8scHcZCA9Y7976u5KswPTX1HNLOMwcFp63WZ6kjqIvqdkai0b/YPdllV2jpBVbzn4ILKzh2kYxO0AwKBgQCdFGyjiiJtPCB+KxeEjkkgO8vZ6sSXTsAvmz2DNObohcaBpHQ29uqo5A4ThXPsTpT7Et59c6aBbVWmriPf9HftFwRwdx0Fe4YWT3RCuJxWO+/11UHYsGhvylKokKNFbqFRMiHC54GQXXlzt4ukxeuqA4Q4C4wn3x/yy6Lj4R2vFQKBgQCX966Y2aRlvO13qZewVDjbb4cmZbf+sXO3JSMjrqsLtXWt8qnsxO5VVF7Eka8Zm4IkoF/anNgaIBA1d9C0SV464pzmf988LSXWXpvtbZyjVdVjGc5NGjDvicANTjKhjKDcM7B76zzi/oNBLUtiFibNZP1/LufEkMmmSPa8v0dj7QKBgCsdwRg+wWZke7LGF0V+XNopL7JYO7AgoKYwoXjTW5J1reBGCNRRgGXte2OmXQR/KWulaUbcKNcb8Me4wwYlL4n3qHNKbr/jgRG8q3fo/pi5CQvchp95BKGy0m+MjBRx4nvMG/JI44qB7eVyezU2UpKvNmq/2K/VEgruFH8ieqhlAoGBAKBGPOFlP4jbQUFHZCAH52ZDAdAtbZtruz4QIBh8ReSMQj174csUge+5DtyBiamwyOszp3DuQBubQerdRa472CmggDCo+m8xLXap1F40tSz+pcnDi9iAGXTJP/bwIXgQoGJPisvCc4ud4JVGeaYxJOs+7F3113zSOVCfEkqxSycb")

                .build());
//        TradeRecordQueryCmd cmd = new TradeRecordQueryCmd();
//        Results<Page<TradeRecordNormalDto>> pageResults = client.tradeRecordQuery(cmd);
//        List<TradeRecordNormalDto> content = pageResults.getData().getContent();
//        TradeRecordNormalDto tradeRecordNormalDto = content.get(0);
//        System.out.println(JSON.toJSONString(tradeRecordNormalDto));
//
//        ArrayList<Long> list = new ArrayList<>();
//        list.add(10757L);
//        list.add(10758L);
//        list.add(111L);
//        list.add(222L);
//        list.add(55667788L);
        //停车数据记录列表
        //Results<Page<OpenParkingDriveRecordDto>> results =
        //        client.driveRecordList(OpenParkingDriveRecordCmd.builder().page(0).size(5).osStoreId(111L).status(0).build());
        //System.out.println(JSON.toJSONString(results.getData()));
        //停车数据接入异常判定统计
        //Results<OpenParkingDockingStatistDto> results = client.dockingStatist(OpenParkingDockingStatistCmd.builder().osStoreIds(list).queryDate(strToDate("2022-06-07", "yyyy-MM-dd")).build());
        //System.out.println(JSON.toJSONString(results.getData()));

        //查询已对接的每个停车场的状态
        //Results<OpenParkingDockingStatusDto> results = client.parkingDockingStatus();
        //System.out.println(results.getData());

        //com.hfcsbc.client.model.Results<OpenParkingDockingStatistDto> results = client.dockingStatist(cmd);

        /** 停车数据接入异常判定详细 */
        //Results<OpenParkingDockingInfoDto> results =
        //        client.dockingInfo(OpenParkingDockingInfoCmd.builder().osStoreId(55667788L).queryDate(strToDate("2022-06-07", "yyyy-MM-dd")).build());
        //System.out.println(JSON.toJSONString(results));

        //Results<String> uploadSurplus =
        //            client.uploadSurplus(OpenParkingSurplusCmd.builder().osStoreId(34010400159L).total(300).surplus(111).build());
        //System.out.println("uploadDriveIn===>>>" + JSONObject.toJSONString(uploadSurplus));
        //
        //
        //Results<String> uploadDriveIn = client.uploadDriveIn(OpenParkingDriveInCmd.builder()
        //        .osStoreId(10954L)
        //        .carPlate("浙A10086")
        //        .carPlateColor(TyhConstants.CarPlateColor.BLUE)
        //        .orderId("order003")
        //        //.inTime(1660738830000L)
        //        .inTime(strToDate("2023-03-21 17:30:00", "yyyy-MM-dd HH:mm:ss").getTime())
        //        .inChannel("东入口")
        //        .build());
        //System.out.println("uploadDriveIn===>>>" + JSON.toJSONString(uploadDriveIn));

        Results<String> uploadDriveOut = client.uploadDriveOut(OpenParkingDriveOutCmd.builder()
                .osStoreCode(1095400L)   //测试共享停车卡
                //.osStoreId(10955L)      //测试新桥机场
                //.osStoreId(10951L)   //普通停车场
                .carPlate("浙A10086")
                .carPlateColor(TyhConstants.CarPlateColor.BLUE)
                .orderId("t001")
                .inTime(strToDate("2023-04-21 17:30:00", "yyyy-MM-dd HH:mm:ss").getTime())
                .outTime(strToDate("2023-04-21 21:30:00", "yyyy-MM-dd HH:mm:ss").getTime())
                .duration(60 * 60 * 4)
                .parkType(TyhConstants.ParkType.TEMPORARY)
                .payType(TyhConstants.PayType.CASH)
                .billingAmount(500)
                .payAmount(500)
                .inChannel("东入口")
                .outChannel("西出口")
                .cardRecordId(1000198L)  //测试共享停车卡
                .parkDiscountTime(60 * 60 * 2)  //测试共享停车卡
                .build());
        System.out.println("uploadDriveOut===>>>" + JSON.toJSONString(uploadDriveOut));


        //Results<String> uploadImage = client.uploadImage(OpenParkingImageCmd.builder()
        //		.osStoreId(3401040142L)
        //		.carPlate("皖AK86E6")
        //		.carPlateColor(TyhConstants.CarPlateColor.BLUE)
        //		.orderId("DCkxJxBoFGQpfy7CZpgnWf")
        //		.content("https://image-cn.keytop.cn/551008011/172.19.2.51/2023/01/12/20230112103400196_172.19.2.51_003455.jpg")
        //		.source(TyhConstants.ImageSource.DRIVE_IN)
        //		.imageType(TyhConstants.ImageType.URL)
        //		.build());
        //System.out.println("uploadImage===>>>" + JSON.toJSONString(uploadImage));

        //Results<OpenParkingHeartbeatDto> uploadHeartbeat = client.uploadHeartbeat(OpenParkingHeartbeatCmd.builder()
        //		.osStoreId(10739L)
        //		.uploadTime(new Date().getTime())
        //		.build()
        //);
        //System.out.println("uploadHeartbeat===>>>" + JSON.toJSONString(uploadHeartbeat));

        //Results<OpenParkingCheckRecordDto> uploadCheckRecord = client.uploadCheckRecord(OpenParkingCheckRecordCmd.builder()
        //        .osStoreId(34010400158L)
        //        .checkDate(strToDate("2022-06-26", "yyyy-MM-dd"))
        //        .driveInNum(1)
        //        .driveOutNum(1)
        //        .build());
        //System.out.println("uploadCheckRecord===>>>" + JSON.toJSONString(uploadCheckRecord));


        //Results<Page<OpenParkingDriveRecordDto>> pageResults = client.driveRecordList(OpenParkingDriveRecordCmd.builder().build());
        //System.out.println(JSON.toJSONString(pageResults));

    }


    public static Date strToDate(String string, String format) {
        if (StringUtil.isEmpty(string)) {
            return null;
        }
        SimpleDateFormat sd = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sd.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


}
