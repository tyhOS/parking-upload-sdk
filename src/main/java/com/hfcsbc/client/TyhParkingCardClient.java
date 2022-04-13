package com.hfcsbc.client;

import com.hfcsbc.client.command.parkingcard.TalentCardCreateCmd;
import com.hfcsbc.client.command.parkingcard.TalentCardInvalidCmd;
import com.hfcsbc.client.command.parkingcard.TalentCardUpdateCmd;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.constants.Options;
import com.hfcsbc.service.TyhParkingCardService;

/**
 * @Author Liu Chong
 * @DateTime 2022/4/13
 * @Description 停宜慧停车卡相关请求
 */
public interface TyhParkingCardClient {


    static TyhParkingCardClient create(Options options) {
        return new TyhParkingCardService(options);
    }

    /**
     * 为人才码创建停车卡
     */
    Results<String> createTalentCard(TalentCardCreateCmd cmd) throws Exception;


    /**
     * 为人才码编辑停车卡
     */
    Results<String> updateTalentCard(TalentCardUpdateCmd cmd) throws Exception;


    /**
     * 为人才码作废停车卡
     */
    Results<String> invalidTalentCard(TalentCardInvalidCmd cmd) throws Exception;

}
