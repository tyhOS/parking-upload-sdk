package com.hfcsbc.service;

import com.alibaba.fastjson.JSON;
import com.hfcsbc.client.TyhTalentCarClient;
import com.hfcsbc.client.command.parkingcard.TalentCarCreateCmd;
import com.hfcsbc.client.command.parkingcard.TalentCarInvalidCmd;
import com.hfcsbc.client.command.parkingcard.TalentCarUpdateCmd;
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
public class TyhTalentCarService implements TyhTalentCarClient {


    public static final String SIGN_TYPE = "RSA2";
    public static final String APPLICATION_NAME = "/os-park";
    // 创建人才车
    public static final String CREATE_TALENT_CARD = APPLICATION_NAME + "/talent/open/api/create";
    // 编辑人才车
    public static final String UPDATE_TALENT_CARD = APPLICATION_NAME + "/talent/open/api/update";
    // 作废人才车
    public static final String INVALID_TALENT_CARD = APPLICATION_NAME + "/talent/open/api/invalid";

    private final Options options;

    private final TyhRestConnection restConnection;

    public TyhTalentCarService(Options options) {
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
     * 为人才码创建政策车
     */
    @Override
    public Results<String> createTalentCard(TalentCarCreateCmd cmd) throws Exception {
        return generalPostRequest(cmd, CREATE_TALENT_CARD, String.class);
    }

    /**
     * 为人才码编辑车牌号
     */
    @Override
    public Results<String> updateTalentCard(TalentCarUpdateCmd cmd) throws Exception {
        return generalPostRequest(cmd, UPDATE_TALENT_CARD, String.class);
    }

    /**
     * 为人才码作废政策车
     */
    @Override
    public Results<String> invalidTalentCard(TalentCarInvalidCmd cmd) throws Exception {
        return generalPostRequest(cmd, INVALID_TALENT_CARD, String.class);
    }
}
