package com.hfcsbc.client.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.hfcsbc.constants.TyhConstants;
import lombok.Builder;
import lombok.Data;

/**
 * @author qidongliang
 * @email 18919656953@163.com
 * @dateTime 2021/11/8
 * @description 对账日返回对账标致
 */
@Data
@Builder
public class OpenParkingCheckRecordDto {

    @JSONField(name = "drive_in_flag")
    @TyhConstants.CheckRecordFlag
    private Integer driveInFlag;

    @JSONField(name = "drive_out_flag")
    @TyhConstants.CheckRecordFlag
    private Integer driveOutFlag;

}
