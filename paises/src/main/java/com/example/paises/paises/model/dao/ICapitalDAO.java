package com.example.paises.paises.model.dao;

import com.example.paises.paises.model.entity.Capital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICapitalDAO extends JpaRepository<Capital, Integer>{
}
