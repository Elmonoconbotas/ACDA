package com.example.balneario.balneario.model.entity;

import jakarta.persistence.*;

@Entity
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer COD_T;

    private String Nombre;
    private Float Coste;
    @ManyToOne(fetch = FetchType.EAGER)
    private Balneario balneario;

    public Integer getCOD_T() {
        return COD_T;
    }

    public void setCOD_T(Integer COD_T) {
        this.COD_T = COD_T;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Float getCoste() {
        return Coste;
    }

    public void setCoste(Float coste) {
        Coste = coste;
    }

    public Balneario getBalneario() {
        return balneario;
    }

    public void setBalneario(Balneario balneario) {
        this.balneario = balneario;
    }
}
