package com.adobe.mappingexample.dao;

import com.adobe.mappingexample.entity.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie, Integer> {
}
