package com.programmingjavaweb.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtils {
    private String value;

    public HttpUtils(String value) {
        this.value = value;
    }

    public static HttpUtils of (BufferedReader bufferedReader) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HttpUtils(stringBuilder.toString());
    }

    public <T> T toModel(Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(value, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
