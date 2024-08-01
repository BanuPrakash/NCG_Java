package com.adobe.prj.emp_project.dao;

import com.adobe.prj.emp_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
