package com.example.autobuses.autobuses.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Autobus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer AutobusID;

    private String licencia;
    private String matricula;

    @OneToMany(mappedBy = "autobus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Conduce> conductores = new ArrayList<>();

    public Integer getAutobusID() {
        return AutobusID;
    }

    public void setAutobusID(Integer autobusID) {
        this.AutobusID = autobusID;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Conduce> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conduce> conductores) {
        this.conductores = conductores;
    }
}
