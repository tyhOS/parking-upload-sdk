package com.hfcsbc.client;

import com.hfcsbc.client.command.*;
import com.hfcsbc.client.model.TyhResponse;
import com.hfcsbc.constants.Options;
import com.hfcsbc.service.TyhUploadService;

public interface TyhUploadClient {

    static TyhUploadClient create(Options options) {
        return new TyhUploadService(options);
    }

    TyhResponse uploadSurplus(UploadSurplusCmd uploadSurplusCmd) throws Exception;

    TyhResponse uploadDriveIn(UploadDriveInCmd uploadDriveInCmd) throws Exception;

    TyhResponse uploadDriveOut(UploadDriveOutCmd uploadDriveOutCmd) throws Exception;

    TyhResponse uploadImage(UploadImageCmd uploadImageCmd) throws Exception;

    TyhResponse uploadHeartbeat(UploadHeartbeatCmd uploadHeartbeatCmd) throws Exception;

    TyhResponse uploadCheckRecord(UploadCheckRecordCmd cmd) throws Exception;

    TyhResponse uploadUID(UploadUIDCmd cmd) throws Exception;

}
