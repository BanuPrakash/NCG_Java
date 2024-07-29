package com.adobe.prj.dao;

import com.adobe.prj.entity.Mobile;

public class MobileDaoDbImpl implements MobileDao{
    @Override
    public void addMobile(Mobile m) {
        System.out.println(m.getName() + " stored in database!!!");
    }

    @Override
    public Mobile getMobile(int id) {
        return null;
    }
}

