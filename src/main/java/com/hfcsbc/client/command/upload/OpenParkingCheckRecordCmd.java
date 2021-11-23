package com.hfcsbc.client.command.upload;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author qidongliang
 * @email 18919656953@163.com
 * @dateTime 2021/11/8
 * @description 停车日对账
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenParkingCheckRecordCmd {

    @JSONField(name = "os_store_id")
    @NotNull(message = "os_store_id不可为空")
    private Long osStoreId;

    @JSONField(name = "check_date")
    @NotNull(message = "check_date不可为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkDate;

    @JSONField(name = "drive_in_num")
    @NotNull(message = "drive_in_num不可为空")
    @Min(value = 0, message = "drive_in_num不可小于0")
    private Integer driveInNum;

    @JSONField(name = "drive_out_num")
    @NotNull(message = "drive_out_num不可为空")
    @Min(value = 0, message = "drive_out_num不可小于0")
    private Integer driveOutNum;

}
