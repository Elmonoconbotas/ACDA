package com.example.autobuses.autobuses.model.dao;

import com.example.autobuses.autobuses.model.entity.Autobus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAutobusDAO extends JpaRepository<Autobus, Integer> {
}
