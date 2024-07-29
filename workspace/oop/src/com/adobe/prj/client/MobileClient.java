package com.adobe.prj.client;

import com.adobe.prj.dao.MobileDao;
import com.adobe.prj.dao.MobileDaoDbImpl;
import com.adobe.prj.dao.MobileDaoFactory;
import com.adobe.prj.dao.MobileDaoFileImpl;
import com.adobe.prj.entity.Mobile;

public class MobileClient {
    public static void main(String[] args) {
        Mobile m = new Mobile(1, "OnePlus 14", 78000.00, "5G");
//        MobileDao mobileDao = new MobileDaoDbImpl();
//        MobileDao mobileDao = new MobileDaoFileImpl();
        MobileDao mobileDao = MobileDaoFactory.getMobileDao();
                mobileDao.addMobile(m);
    }
}
