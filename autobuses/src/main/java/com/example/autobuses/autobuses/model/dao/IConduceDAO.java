package com.example.autobuses.autobuses.model.dao;

import com.example.autobuses.autobuses.model.entity.Conduce;
import com.example.autobuses.autobuses.model.entity.ConduceID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConduceDAO extends JpaRepository<Conduce, ConduceID> {
}
