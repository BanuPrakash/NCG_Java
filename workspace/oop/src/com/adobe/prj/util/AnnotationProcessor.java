package com.adobe.prj.util;

import com.adobe.prj.annotation.Column;
import com.adobe.prj.annotation.Table;

import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static String generateCreateSQL(Class<?> clazz) {
        StringBuffer buffer = new StringBuffer();
        Table table = clazz.getAnnotation(Table.class);
        if( table != null) {
            buffer.append("create table ");
            buffer.append(table.name());
            buffer.append("(");
            Method[] methods = clazz.getDeclaredMethods();
            for(Method m : methods) {
                if(m.getName().startsWith("get")) {
                    Column col = m.getAnnotation(Column.class);
                    buffer.append(col.name());
                    buffer.append(" ");
                    buffer.append(col.type());
                    buffer.append(","); // create table books(ISBN VARCHAR(255),
                }
            }
        }
        buffer.setCharAt(buffer.lastIndexOf(","),')');
        return buffer.toString();
    }

    public static String generateInsertSQL(Object obj) {
        StringBuffer buffer = new StringBuffer();


        return buffer.toString();
    }
}
