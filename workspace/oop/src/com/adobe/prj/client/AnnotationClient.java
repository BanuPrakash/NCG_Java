package com.adobe.prj.client;

import com.adobe.prj.entity.Book;
import com.adobe.prj.entity.Employee;
import com.adobe.prj.util.AnnotationProcessor;

public class AnnotationClient {
    public static void main(String[] args) {
        String createSQL = AnnotationProcessor.generateCreateSQL(Book.class);
        System.out.println(createSQL);

        createSQL = AnnotationProcessor.generateCreateSQL(Employee.class);
        System.out.println(createSQL);
    }
}
