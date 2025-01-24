package com.example.paises.paises.model.entity;

import jakarta.persistence.*;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer COD_P;

    private String nombre;
    private int extension;
    private String continente;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "capitalID", nullable = false, unique = true)
    private Capital capital;

    public Integer getCOD_P() {
        return COD_P;
    }

    public void setCOD_P(Integer COD_P) {
        this.COD_P = COD_P;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }
}
