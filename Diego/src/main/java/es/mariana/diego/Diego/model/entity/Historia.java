package es.mariana.diego.Diego.model.entity;

import jakarta.persistence.*;

@Entity
public class Historia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historiaID;

    @Column(name = "Titulo", nullable = false, length = 100, unique = true)
    private String titulo;

    @Column(name = "Descripcion", nullable = false, length = 100, unique = true)
    private String descripcion;

    public Historia() {}

    public int getHistoriaID() {
        return historiaID;
    }

    public void setHistoriaID(int historiaID) {
        this.historiaID = historiaID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
