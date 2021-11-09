package com.hfcsbc.client.command;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author qidongliang
 * @email 18919656953@163.com
 * @dateTime 2021/11/8
 * @description 停车日对账
 */
@Data
@Builder
public class UploadCheckRecordCmd {

    @JSONField(name = "parking_code")
    private String parkingCode;

    @JSONField(name = "check_date")
    private Date checkDate;

    @JSONField(name = "drive_in_num")
    private Integer driveInNum;

    @JSONField(name = "drive_out_num")
    private Integer driveOutNum;

}
