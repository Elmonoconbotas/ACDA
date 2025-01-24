package es.mariana.acda.ut4.ejemplorelacion1n.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personaID;

    private String nombre;
    private String apellidos;
    private Integer edad;

    @OneToMany(mappedBy = "propietaria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Coche> coches = new ArrayList<>();

    public Integer getPersonaID() {
        return personaID;
    }

    public void setPersonaID(Integer personaID) {
        this.personaID = personaID;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }
}
