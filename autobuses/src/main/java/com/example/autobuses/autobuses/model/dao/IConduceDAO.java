package com.example.autobuses.autobuses.model.dao;

import com.example.autobuses.autobuses.model.entity.Conduce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConduceDAO extends JpaRepository<Conduce, Integer> {
}
