package com.example.balneario.balneario.model.dao;

import com.example.balneario.balneario.model.entity.Balneario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBalnearioDAO extends JpaRepository<Balneario, Integer> {
}
