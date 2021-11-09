package com.hfcsbc.client.command;

import com.alibaba.fastjson.annotation.JSONField;
import com.hfcsbc.constants.TyhConstants;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

/**
 * @author qidongliang
 * @email 18919656953@163.com
 * @dateTime 2021/11/9
 * @description 下载驶入驶出orderId
 */
@Data
@Builder
public class UploadUIDCmd {

    @JSONField(name = "parking_code")
    private String parkingCode;

    @JSONField(name = "check_date")
    private Date checkDate;

    @TyhConstants.DriveType
    private Integer type;

}
