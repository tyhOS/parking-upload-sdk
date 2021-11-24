package com.hfcsbc.client;

import com.hfcsbc.client.command.upload.*;
import com.hfcsbc.client.dto.OpenParkingCheckRecordDto;
import com.hfcsbc.client.dto.OpenParkingHeartbeatDto;
import com.hfcsbc.client.dto.OpenParkingUIDDto;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.constants.Options;
import com.hfcsbc.service.TyhUploadService;

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

}
