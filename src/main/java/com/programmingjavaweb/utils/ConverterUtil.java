package com.programmingjavaweb.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;

public class ConverterUtil {

    public <T> T resultToModel (T t, ResultSet rs) {
        Class currentClass = t.getClass();
        Field[] currentFields = currentClass.getDeclaredFields();
        convert(currentFields, t, rs);
        Class parentClass = currentClass.getSuperclass();
        while(parentClass != null) {
            convert(parentClass.getDeclaredFields(), t, rs);
            parentClass = parentClass.getSuperclass();
        }
        return t;
    }

    private <T> T convert(Field[] fields, T t, ResultSet rs) {
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
