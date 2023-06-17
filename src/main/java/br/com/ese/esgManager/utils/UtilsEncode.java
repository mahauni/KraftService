package br.com.ese.esgManager.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class UtilsEncode {
    public static String encode(String passwd) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(passwd.getBytes(StandardCharsets.ISO_8859_1));

        BigInteger hash = new BigInteger(1, md.digest());

        return hash.toString(16);
    }
}
