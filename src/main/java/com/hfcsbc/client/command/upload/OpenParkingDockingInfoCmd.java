package com.hfcsbc.client.command.upload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author: HeQuanChao
 * @Date: 22/04/07
 * @Description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenParkingDockingInfoCmd {

    @NotNull(message = "osStoreCode不可为空")
    private Long osStoreCode;

    @NotNull(message = "queryDate不可为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date queryDate;
}
