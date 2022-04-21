package com.hfcsbc.client.command.parkingcard;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Liu Chong
 * @DateTime 2022/4/13
 * @Description xxx
 */
@Data
@Builder
public class TalentCarCreateCmd {

    /**
     * 车牌号
     */
    private String plateNumber;

    /**
     * 优惠标识 0：一天免4小时 1：一天免8小时 2：一天全免
     */
    private Integer discountType;

}
