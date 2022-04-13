package com.hfcsbc.service;

import com.alibaba.fastjson.JSON;
import com.hfcsbc.client.TyhParkingCardClient;
import com.hfcsbc.client.command.parkingcard.TalentCardCreateCmd;
import com.hfcsbc.client.command.parkingcard.TalentCardInvalidCmd;
import com.hfcsbc.client.command.parkingcard.TalentCardUpdateCmd;
import com.hfcsbc.client.model.Results;
import com.hfcsbc.client.model.TyhRequest;
import com.hfcsbc.constants.Options;
import org.bouncycastle.util.encoders.Base64;

import java.nio.charset.StandardCharsets;

/**
 * @Author Liu Chong
 * @DateTime 2022/4/13
 * @Description
 */
public class TyhParkingCardService implements TyhParkingCardClient {


    public static final String SIGN_TYPE = "RSA2";
    public static final String APPLICATION_NAME = "/os-park";
    // 发放人才卡
    public static final String CREATE_TALENT_CARD = APPLICATION_NAME + "/ospark/card/open/api/talent/create";
    // 编辑人才卡
    public static final String UPDATE_TALENT_CARD = APPLICATION_NAME + "/ospark/card/open/api/talent/create";
    // 作废人才卡
    public static final String INVALID_TALENT_CARD = APPLICATION_NAME + "/ospark/card/open/api/talent/create";

    private final Options options;

    private final TyhRestConnection restConnection;

    public TyhParkingCardService(Options options) {
        this.options = options;
        restConnection = new TyhRestConnection(options);
    }

    public <T> Results<T> generalPostRequest(Object object, String path, Class<T> dtoClass) throws Exception {
        byte[] data = JSON.toJSONString(object).getBytes(StandardCharsets.UTF_8);
        TyhRequest tyhRequest = TyhRequest.builder().accessId(options.getAccessId())
                .timeStamp(System.currentTimeMillis()).signType(SIGN_TYPE)
                .data(new String(Base64.encode(data))).build();
        return restConnection.executePostWithSignature(path, tyhRequest, dtoClass);
    }

    /**
     * 为人才码创建停车卡
     */
    @Override
    public Results<String> createTalentCard(TalentCardCreateCmd cmd) throws Exception {
        return generalPostRequest(cmd, CREATE_TALENT_CARD, String.class);
    }

    /**
     * 为人才码编辑停车卡
     */
    @Override
    public Results<String> updateTalentCard(TalentCardUpdateCmd cmd) throws Exception {
        return generalPostRequest(cmd, UPDATE_TALENT_CARD, String.class);
    }

    /**
     * 为人才码作废停车卡
     */
    @Override
    public Results<String> invalidTalentCard(TalentCardInvalidCmd cmd) throws Exception {
        return generalPostRequest(cmd, INVALID_TALENT_CARD, String.class);
    }
}
