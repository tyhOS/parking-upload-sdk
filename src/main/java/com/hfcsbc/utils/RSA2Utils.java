package com.hfcsbc.utils;

import org.bouncycastle.util.encoders.Base64;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @program: tyh-os
 * @description: RSA签名算法
 * @author: wangdan
 * @create: 2021-09-23 18:04
 **/
public class RSA2Utils {
    private static final String KEY_ALGORITHM = "RSA";
    private static final String SIGN_ALGORITHM = "SHA1WithRSA";

    /**
     * 私钥签名
     *
     * @param content
     * @param charset
     * @return
     * @throws Exception
     */
    public static String doSign(String content, String charset, PrivateKey priKey) throws Exception {
        Signature signature = Signature.getInstance(SIGN_ALGORITHM);
        signature.initSign(priKey);
        if (StringUtil.isEmpty(charset)) {
            signature.update(content.getBytes());
        } else {
            signature.update(content.getBytes(charset));
        }

        byte[] signed = signature.sign();
        return new String(Base64.encode(signed));
    }

    /**
     * 公钥验签
     *
     * @param content
     * @param charset
     * @param sign
     * @return
     * @throws Exception
     */
    public static boolean doVerify(String content, String charset, PublicKey pubKey, String sign) throws Exception {
        Signature signature = Signature.getInstance(SIGN_ALGORITHM);
        signature.initVerify(pubKey);
        if (StringUtil.isEmpty(charset)) {
            signature.update(content.getBytes());
        } else {
            signature.update(content.getBytes(charset));
        }

        return signature.verify(Base64.decode(sign.getBytes()));
    }

    /**
     * 生成私钥对象
     *
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKeyFromPKCS8(String privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        byte[] encodedKey = Base64.decode(privateKey);
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
    }

    /**
     * 生成公钥对象
     *
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKeyFromX509(String publicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        byte[] encodedKey = Base64.decode(publicKey);
        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
    }
}