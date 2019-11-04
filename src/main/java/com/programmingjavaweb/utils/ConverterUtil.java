package com.programmingjavaweb.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;

public class ConverterUtil {

    public <T> T resultToModel (T t, ResultSet rs) {
        Field[] fields = t.getClass().getDeclaredFields();
        for(Field field : fields) {
            try {
                field.setAccessible(true);
                field.set(t, rs.getObject(field.getName().toLowerCase(), field.getType()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return t;
    }
}
