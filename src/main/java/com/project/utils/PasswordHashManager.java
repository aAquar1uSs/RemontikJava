package com.project.utils;


import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class PasswordHashManager {
    public static String passwordEncryption(String st) {

        String md5Hex = DigestUtils.md5Hex(st);

        return md5Hex;
    }
}
