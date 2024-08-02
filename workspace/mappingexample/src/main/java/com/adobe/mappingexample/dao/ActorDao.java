package com.adobe.mappingexample.dao;

import com.adobe.mappingexample.entity.Actor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorDao extends JpaRepository<Actor, Integer> {
}
