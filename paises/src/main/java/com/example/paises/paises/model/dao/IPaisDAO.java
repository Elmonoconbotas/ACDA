package com.example.paises.paises.model.dao;


import com.example.paises.paises.model.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPaisDAO extends JpaRepository<Pais, Integer> {

    @Query("SELECT p FROM Pais p WHERE p.capital.id = :id")
    Pais findPaisByCapitalId(@Param("id") Integer id);
}
