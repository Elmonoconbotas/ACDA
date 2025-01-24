package com.example.balneario.balneario.model.dao;

import com.example.balneario.balneario.model.entity.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITratamientoDAO extends JpaRepository<Tratamiento, Integer> {
}
