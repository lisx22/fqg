package com.fqg.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESTest {
    private static final String AE_S = "AES/ECB/PKCSSPadding";
    private static final String KEY_ALGORITHM = "AES";
    public static String encrypt(String password){
        try {
            Cipher cipher = Cipher.getInstance(AE_S);
            String content=null;
            byte [] byteCotent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE,getSecretKey(password));
            byte[] result = cipher.doFinal(byteCotent);
            return Base64.encodeBase64String(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private static SecretKeySpec getSecretKey(final String password) {
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            kg.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kg.generateKey();
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
