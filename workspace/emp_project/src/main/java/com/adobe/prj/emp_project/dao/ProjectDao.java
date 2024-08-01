package com.adobe.prj.emp_project.dao;

import com.adobe.prj.emp_project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDao extends JpaRepository<Project, Integer> {
}
