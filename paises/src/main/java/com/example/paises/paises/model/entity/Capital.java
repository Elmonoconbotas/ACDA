package com.example.paises.paises.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Capital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer COD_C;

    private String nombre;
    private int habitantes;
    private String latitud;

    public Integer getCOD_C() {
        return COD_C;
    }

    public void setCOD_C(Integer COD_C) {
        this.COD_C = COD_C;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
}
