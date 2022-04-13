package com.hfcsbc.client;

import com.alibaba.fastjson.JSONObject;
import com.hfcsbc.client.command.upload.*;
import com.hfcsbc.client.dto.*;
import com.hfcsbc.client.dto.trade.TradeRecordNormalDto;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.constants.Options;
import com.hfcsbc.service.TyhUploadService;
import com.hfcsbc.utils.Page;

import java.util.Map;

public interface TyhUploadClient {

    static TyhUploadClient create(Options options) {
        return new TyhUploadService(options);
    }

    Results<String> uploadSurplus(OpenParkingSurplusCmd openParkingSurplusCmd) throws Exception;

    Results<String> uploadDriveIn(OpenParkingDriveInCmd openParkingDriveInCmd) throws Exception;

    Results<String> uploadDriveOut(OpenParkingDriveOutCmd openParkingDriveOutCmd) throws Exception;

    Results<String> uploadImage(OpenParkingImageCmd openParkingImageCmd) throws Exception;

    Results<OpenParkingHeartbeatDto> uploadHeartbeat(OpenParkingHeartbeatCmd openParkingHeartbeatCmd) throws Exception;

    Results<OpenParkingCheckRecordDto> uploadCheckRecord(OpenParkingCheckRecordCmd cmd) throws Exception;

    Results<OpenParkingUIDDto> uploadUID(OpenParkingUIDCmd cmd) throws Exception;

    Results<String> creditPaySet(OpenParkingCreditPayCmd cmd) throws Exception;

    /** 停车数据接入异常判定详细信息 */
    Results<OpenParkingDockingInfoDto> dockingInfo(OpenParkingDockingInfoCmd cmd) throws Exception;

    /** 停车数据接入异常判定统计 */
    Results<OpenParkingDockingStatistDto> dockingStatist(OpenParkingDockingStatistCmd cmd) throws Exception;

    /** 停车数据停车记录列表 */
    Results<Page<OpenParkingDriveRecordDto>> driveRecordList(OpenParkingDriveRecordCmd cmd)throws Exception;

    Results<OpenParkingDockingStatusDto> parkingDockingStatus()throws Exception;
}
