package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Torneo")
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int torneoID;

    @Size(min = 5, max = 50, message = "Entre 5 y 50 caracteres")
    @Column(name = "Nombre", nullable = false, length = 50, unique = true)
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "F_inicio")
    private Date fInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "F_fin")
    private Date fFin;

    @Min(value = 100, message = "No se aceptan premios inferiores a 100")
    @Column(name = "Premio", precision = 8, scale = 2)
    private BigDecimal premio;

    @OneToMany(mappedBy = "torneo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Partida> partidas = new ArrayList<>();

    @OneToMany(mappedBy = "torneo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Participa> participantes = new ArrayList<>();

    public Torneo(String nombre, Date fInicio, Date fFin, BigDecimal premio) {
        this.nombre = nombre;
        this.fInicio = fInicio;
        this.fFin = fFin;
        this.premio = premio;
    }

    public Torneo() {}

    public int getTorneoID() {
        return torneoID;
    }

    public void setTorneoID(int torneoID) {
        this.torneoID = torneoID;
    }

    public @Size(min = 5, max = 50, message = "Entre 5 y 50 caracteres") String getNombre() {
        return nombre;
    }

    public void setNombre(@Size(min = 5, max = 50, message = "Entre 5 y 50 caracteres") String nombre) {
        this.nombre = nombre;
    }

    public Date getfInicio() {
        return fInicio;
    }

    public void setfInicio(Date fInicio) {
        this.fInicio = fInicio;
    }

    public Date getfFin() {
        return fFin;
    }

    public void setfFin(Date fFin) {
        this.fFin = fFin;
    }

    public @Min(value = 100, message = "No se aceptan premios inferiores a 100") BigDecimal getPremio() {
        return premio;
    }

    public void setPremio(@Min(value = 100, message = "No se aceptan premios inferiores a 100") BigDecimal premio) {
        this.premio = premio;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    public List<Participa> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participa> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Torneo{" +
                "torneoID=" + torneoID +
                ", nombre='" + nombre + '\'' +
                ", fInicio=" + fInicio +
                ", fFin=" + fFin +
                ", premio=" + premio +
                ", participantes=" + participantes.size() +
                '}';
    }
}
