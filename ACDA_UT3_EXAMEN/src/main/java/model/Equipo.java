package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int equipoID;

    @Size(min = 3, max = 30, message = "Entre 3 y 30 caracteres")
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "F_Fundacion")
    private Date f_fundacion;

    @Column(name = "nombre", nullable = false, length = 50)
    private String pais;

    @Column(name = "presupusto", precision = 8, scale = 2)
    private BigDecimal presupuesto;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true,
    fetch = FetchType.EAGER)
    private List<Participa> participaciones = new ArrayList<>();

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Jugador> jugadores = new ArrayList<>();

    @OneToOne(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "jugadorID", nullable = false, unique = true)
    private Jugador capitan;

    @OneToMany(mappedBy = "equipoVisitante", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Partida> partidasVisitante = new ArrayList<>();

    @OneToMany(mappedBy = "equipoLocal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Partida> partidasLocal = new ArrayList<>();

    public Equipo(){}

    public int getEquipoID() {
        return equipoID;
    }

    public void setEquipoID(int equipoID) {
        this.equipoID = equipoID;
    }

    public @Size(min = 3, max = 30, message = "Entre 3 y 30 caracteres") String getNombre() {
        return nombre;
    }

    public void setNombre(@Size(min = 3, max = 30, message = "Entre 3 y 30 caracteres") String nombre) {
        this.nombre = nombre;
    }

    public Date getF_fundacion() {
        return f_fundacion;
    }

    public void setF_fundacion(Date f_fundacion) {
        this.f_fundacion = f_fundacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public List<Participa> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(List<Participa> participaciones) {
        this.participaciones = participaciones;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Jugador getCapitan() {
        return capitan;
    }

    public void setCapitan(Jugador capitan) {
        this.capitan = capitan;
    }
}
