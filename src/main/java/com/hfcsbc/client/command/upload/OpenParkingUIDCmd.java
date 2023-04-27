package com.hfcsbc.client.command.upload;

import com.alibaba.fastjson.annotation.JSONField;
import com.hfcsbc.constants.TyhConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
public class OpenParkingUIDCmd {

    @NotNull(message = "osStoreCode不可为空")
    private Long osStoreCode;

    @NotNull(message = "checkDate不可为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkDate;

    @TyhConstants.DriveType
    @NotNull(message = "type不可为空")
    private Integer type;

}
