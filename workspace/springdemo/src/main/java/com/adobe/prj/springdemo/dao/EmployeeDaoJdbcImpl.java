package com.adobe.prj.springdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;

@Repository
@Profile("prod")
public class EmployeeDaoJdbcImpl  implements  EmployeeDao{
    @Autowired
    DataSource ds; // pool of DB connection

    @Override
    public void addEmployee() {
        try {
            Connection con = ds.getConnection();
            System.out.println(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("stored in database !!!");
    }
}

