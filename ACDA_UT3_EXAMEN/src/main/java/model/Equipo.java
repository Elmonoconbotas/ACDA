package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int equipoID;

    @Size(min = 3, max = 30, message = "Nombres entre 3 y 30 caracteres")
    @Column(name = "Nombre", nullable = false, length = 30)
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "F_Fundacion", nullable = false)
    private Date fFundacion;

    @Column(name = "Pais", nullable = false, length = 50)
    private String pais;

    @Column(name = "Presupuesto", nullable = false, precision = 8, scale = 2)
    private BigDecimal presupuesto;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Participa> participaciones = new ArrayList<>();

    @OneToMany(mappedBy = "equipoVisitante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Partida> partidasVisitante = new ArrayList<>();

    @OneToMany(mappedBy = "equipoLocal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Partida> partidasLocal = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jugadorID", unique = true)
    private Jugador capitan;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Jugador> jugadores = new ArrayList<>();

    public Equipo(String nombre, Date fFundacion, String pais, BigDecimal presupuesto, Jugador capitan) {
        this.nombre = nombre;
        this.fFundacion = fFundacion;
        this.pais = pais;
        this.presupuesto = presupuesto;
        this.capitan = capitan;
    }

    public Equipo() {}

    public int getEquipoID() {
        return equipoID;
    }

    public void setEquipoID(int equipoID) {
        this.equipoID = equipoID;
    }

    public @Size(min = 3, max = 30, message = "Nombres entre 3 y 30 caracteres") String getNombre() {
        return nombre;
    }

    public void setNombre(@Size(min = 3, max = 30, message = "Nombres entre 3 y 30 caracteres") String nombre) {
        this.nombre = nombre;
    }

    public Date getfFundacion() {
        return fFundacion;
    }

    public void setfFundacion(Date fFundacion) {
        this.fFundacion = fFundacion;
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

    public List<Partida> getPartidasVisitante() {
        return partidasVisitante;
    }

    public void setPartidasVisitante(List<Partida> partidasVisitante) {
        this.partidasVisitante = partidasVisitante;
    }

    public List<Partida> getPartidasLocal() {
        return partidasLocal;
    }

    public void setPartidasLocal(List<Partida> partidasLocal) {
        this.partidasLocal = partidasLocal;
    }

    public Jugador getCapitan() {
        return capitan;
    }

    public void setCapitan(Jugador capitan) {
        this.capitan = capitan;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo{\n" + "\tequipoID=").append(equipoID)
                .append("\n\tnombre='").append(nombre).append("'")
                .append("\n\tfFundacion=").append(fFundacion)
                .append("\n\tpais='").append(pais).append("'")
                .append("\n\tpresupuesto=").append(presupuesto);

        if (Hibernate.isInitialized(partidasVisitante))
            sb.append("\n\tpartidasVisitante=").append(partidasVisitante.size());

        if (Hibernate.isInitialized(partidasLocal))
            sb.append("\n\tpartidasLocal=").append(partidasLocal.size());

        if (Hibernate.isInitialized(capitan))
            sb.append("\n\tcapitan=").append(capitan);

        if (Hibernate.isInitialized(jugadores))
            sb.append("\n\tjugadores=").append(jugadores.size());

        return sb.toString();
    }
}
