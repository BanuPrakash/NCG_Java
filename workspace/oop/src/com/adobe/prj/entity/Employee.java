package com.adobe.prj.entity;

import com.adobe.prj.annotation.Column;
import com.adobe.prj.annotation.Table;

@Table(name="EMP")
public class Employee {

    private int empId;

    private String email;

    @Column(name="EMPID", type = "int")
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Column(name = "EMP_EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
