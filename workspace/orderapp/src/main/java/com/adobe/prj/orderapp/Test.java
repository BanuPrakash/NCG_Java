package com.adobe.prj.orderapp;

import com.adobe.prj.orderapp.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception{
        String dateStr = "2014-10-22";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date d = sdf.parse(dateStr);
        System.out.println(d);

        Product p = Product.builder().id(22).name("Bosch").price(53422).build();

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(p));
    }
}
