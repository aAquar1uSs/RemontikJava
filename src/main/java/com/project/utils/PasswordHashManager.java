package com.project.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHashManager {
    public static String passwordEncryption(String st) {
        return DigestUtils.md5Hex(st);
    }
}
