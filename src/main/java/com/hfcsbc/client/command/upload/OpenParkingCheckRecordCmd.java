package com.hfcsbc.client.command.upload;

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

    @NotNull(message = "osStoreId不可为空")
    private Long osStoreId;

    @NotNull(message = "checkDate不可为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkDate;

    @NotNull(message = "driveInNum不可为空")
    @Min(value = 0, message = "driveInNum不可小于0")
    private Integer driveInNum;

    @NotNull(message = "driveOutNum不可为空")
    @Min(value = 0, message = "driveOutNum不可小于0")
    private Integer driveOutNum;

}
