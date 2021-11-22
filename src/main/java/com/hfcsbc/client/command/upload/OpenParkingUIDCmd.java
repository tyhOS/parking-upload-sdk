package com.hfcsbc.client.command.upload;

import com.alibaba.fastjson.annotation.JSONField;
import com.hfcsbc.constants.TyhConstants;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author qidongliang
 * @email 18919656953@163.com
 * @dateTime 2021/11/9
 * @description 下载驶入驶出orderId
 */
@Data
@Builder
public class OpenParkingUIDCmd {

    @JSONField(name = "os_store_id")
    @NotNull(message = "parking_code不可为空")
    private Long osStoreId;

    @JSONField(name = "check_date")
    @NotNull(message = "check_date不可为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkDate;

    @TyhConstants.DriveType
    @NotNull(message = "type不可为空")
    private Integer type;

}
