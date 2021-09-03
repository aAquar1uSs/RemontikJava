package com.project.utils;


import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHashManager {
    public static String passwordEncryption(String st) {

        String md5Hex = DigestUtils.md5Hex(st);

        return md5Hex;
    }
}
