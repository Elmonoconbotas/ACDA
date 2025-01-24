package com.example.balneario.balneario.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Balneario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer COD_B;

    private String Nombre;
    @OneToMany(mappedBy = "balneario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public Integer getCOD_B() {
        return COD_B;
    }

    public void setCOD_B(Integer COD_B) {
        this.COD_B = COD_B;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }
}
