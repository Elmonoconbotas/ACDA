package es.mariana.acda.ut4.ejemplorelacion1n.model.entity;

import jakarta.persistence.*;

@Entity
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cocheID;

    private String marca;
    private String modelo;
    private String color;
    private String matricula;
    private Integer anioMatriculacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_ID", nullable = false)
    private Persona propietaria;

    public Integer getCocheID() {
        return cocheID;
    }

    public void setCocheID(Integer cocheID) {
        this.cocheID = cocheID;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getAnioMatriculacion() {
        return anioMatriculacion;
    }

    public void setAnioMatriculacion(Integer anioMatriculacion) {
        this.anioMatriculacion = anioMatriculacion;
    }

    public Persona getPropietaria() {
        return propietaria;
    }

    public void setPropietaria(Persona propietaria) {
        this.propietaria = propietaria;
    }
}
