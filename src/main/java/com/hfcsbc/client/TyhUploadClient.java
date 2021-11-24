package com.hfcsbc.client;

import com.hfcsbc.client.command.upload.*;
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

    Results<String> uploadHeartbeat(OpenParkingHeartbeatCmd openParkingHeartbeatCmd) throws Exception;

    Results<String> uploadCheckRecord(OpenParkingCheckRecordCmd cmd) throws Exception;

    Results<String> uploadUID(OpenParkingUIDCmd cmd) throws Exception;

}
