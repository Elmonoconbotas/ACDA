package es.mariana.diego.Diego.model.entity;

import jakarta.persistence.*;

@Entity
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private String apellidos;
    @OneToOne(fetch = FetchType.LAZY)
    // Nombre de la columna de relación
    @JoinColumn(name = "historiaID", nullable = false, unique = true)
    private Historia historia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Historia getHistoria() {
        return historia;
    }

    public void setHistoria(Historia historia) {
        this.historia = historia;
    }
}
