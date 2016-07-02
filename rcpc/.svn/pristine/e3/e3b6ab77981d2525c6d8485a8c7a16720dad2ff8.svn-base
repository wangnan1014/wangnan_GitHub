package com.heag.rcpc.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.spec.AlgorithmParameterSpec;

/**
 * Created by Administrator on 2015-6-17 0017.
 */
public class EncryptUtil {

    static final Logger debugLogger = Logger.getLogger("report.debug");

    private final static byte[] KEY_64 = "741f5093".getBytes();

    private final static byte[] IV_64 = "cb4a8c85".getBytes();

    public static String encrypt(String uid, String time) {

        if (StringUtils.isEmpty(uid) || StringUtils.isEmpty(time) || time.length() != 14) {
            return null;
        }
        String newUid = uid + StringUtils.repeat("8", 8 - uid.length() % 8);
        String str = newUid + time;
        char[] array = str.toCharArray();
        int len = array.length;
        StringBuilder sb = new StringBuilder(len);
        int i = 0;
        while (i < len) {
            sb.append(array[i + 1]);
            sb.append(array[i]);
            i += 2;
        }
        str = sb.toString();

        try {
            String code = encode(str);
            debugLogger.debug("EncryptUtil.encrypt code:" + code);
            return code;
        } catch (Exception e) {
            debugLogger.error("EncryptUtil.encrypt Exception", e);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("32761", "20101217190036"));
    }

    public static String encode(String data) throws Exception {
        DESKeySpec keySpec = new DESKeySpec(KEY_64);
        AlgorithmParameterSpec iv = new IvParameterSpec(IV_64);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(keySpec);
        Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        enCipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));
        return new String(Base64.encodeBase64(pasByte));
    }
}
