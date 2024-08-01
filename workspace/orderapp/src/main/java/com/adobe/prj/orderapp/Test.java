package com.adobe.prj.orderapp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception{
        String dateStr = "2014-10-22";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date d = sdf.parse(dateStr);
        System.out.println(d);
    }
}
