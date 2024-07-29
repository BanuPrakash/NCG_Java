package com.adobe.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {
    private  static String DAO = "";
    static  {
        ResourceBundle res = ResourceBundle.getBundle("config");
        DAO = res.getString("MOBILE_DAO");
    }
    public static MobileDao getMobileDao() {
       // return new MobileDaoFileImpl();
        try {
           return (MobileDao)  Class.forName(DAO).getConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
