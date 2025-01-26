package com.example.autobuses.autobuses.model.dao;

import com.example.autobuses.autobuses.model.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConductorDAO extends JpaRepository<Conductor, Integer> {
}
