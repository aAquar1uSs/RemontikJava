package com.project.utils;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

public class EncodingManager {
    public static String encodingForRussiansSymbolsInRequest(HttpServletRequest request, String parameter) {
        String value = request.getParameter(parameter);
        byte[] bytes = value.getBytes(StandardCharsets.ISO_8859_1);
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
