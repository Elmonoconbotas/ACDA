package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "Jugador")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jugadorID;

    @Size(min = 5, max = 50, message = "Entre 5 y 50 caracteres")
    @Column(name = "Nombre_Apellidos", nullable = false, length = 50)
    private String nombreApellidos;

    @Size(min = 3, max = 20, message = "Entre 3 y 20 caracteres")
    @Column(name = "Alias", nullable = false, length = 20, unique = true)
    private String alias;

    @Temporal(TemporalType.DATE)
    @Column(name = "F_Nacimiento")
    private Date fNacimiento;

    @Column(name = "Nacionalidad", length = 50)
    private String nacionalidad;

    @ManyToOne(fetch = FetchType.EAGER)
    private Equipo equipo;

    public Jugador() {}

    public int getJugadorID() {
        return jugadorID;
    }

    public void setJugadorID(int jugadorID) {
        this.jugadorID = jugadorID;
    }

    public @Size(min = 5, max = 50, message = "Entre 5 y 50 caracteres") String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(@Size(min = 5, max = 50, message = "Entre 5 y 50 caracteres") String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public @Size(min = 3, max = 20, message = "Entre 3 y 20 caracteres") String getAlias() {
        return alias;
    }

    public void setAlias(@Size(min = 3, max = 20, message = "Entre 3 y 20 caracteres") String alias) {
        this.alias = alias;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
