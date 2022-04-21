package com.hfcsbc.client;

import com.hfcsbc.client.command.parkingcard.TalentCarCreateCmd;
import com.hfcsbc.client.command.parkingcard.TalentCarInvalidCmd;
import com.hfcsbc.client.command.parkingcard.TalentCarUpdateCmd;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.constants.Options;
import com.hfcsbc.service.TyhTalentCarService;

/**
 * @Author Liu Chong
 * @DateTime 2022/4/13
 * @Description 停宜慧人才码政策车相关请求
 */
public interface TyhTalentCarClient {


    static TyhTalentCarClient create(Options options) {
        return new TyhTalentCarService(options);
    }

    /**
     * 为人才码创建停车卡
     */
    Results<String> createTalentCard(TalentCarCreateCmd cmd) throws Exception;


    /**
     * 为人才码编辑停车卡
     */
    Results<String> updateTalentCard(TalentCarUpdateCmd cmd) throws Exception;


    /**
     * 为人才码作废停车卡
     */
    Results<String> invalidTalentCard(TalentCarInvalidCmd cmd) throws Exception;

}
