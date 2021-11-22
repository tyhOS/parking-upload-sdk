package com.hfcsbc.client;

import com.hfcsbc.client.command.upload.*;
import com.hfcsbc.client.model.TyhResponse;
import com.hfcsbc.constants.Options;
import com.hfcsbc.service.TyhUploadService;

public interface TyhUploadClient {

    static TyhUploadClient create(Options options) {
        return new TyhUploadService(options);
    }

    TyhResponse uploadSurplus(OpenParkingSurplusCmd openParkingSurplusCmd) throws Exception;

    TyhResponse uploadDriveIn(OpenParkingDriveInCmd openParkingDriveInCmd) throws Exception;

    TyhResponse uploadDriveOut(OpenParkingDriveOutCmd openParkingDriveOutCmd) throws Exception;

    TyhResponse uploadImage(OpenParkingImageCmd openParkingImageCmd) throws Exception;

    TyhResponse uploadHeartbeat(OpenParkingHeartbeatCmd openParkingHeartbeatCmd) throws Exception;

    TyhResponse uploadCheckRecord(OpenParkingCheckRecordCmd cmd) throws Exception;

    TyhResponse uploadUID(OpenParkingUIDCmd cmd) throws Exception;

}
