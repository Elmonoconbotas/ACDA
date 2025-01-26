package com.example.autobuses.autobuses.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ConductorID;

    private String nombre;
    private String carnet;
    private int experiencia;

    @OneToMany(mappedBy = "conductor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Conduce> autobuses = new ArrayList<>();

    public Integer getConductorID() {
        return ConductorID;
    }

    public void setConductorID(Integer conductorID) {
        this.ConductorID = conductorID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public List<Conduce> getAutobuses() {
        return autobuses;
    }

    public void setAutobuses(List<Conduce> autobuses) {
        this.autobuses = autobuses;
    }
}
