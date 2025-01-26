package model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Partida")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partidaID;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Fecha_hora")
    private Date fechaHora;

    @Column(name = "Duracion")
    private Integer duracion;

    @Column(name = "Resultado", nullable = false)
    private int resultado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TorneoID", nullable = false)
    private Torneo torneo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Equipo_Local_ID", nullable = false)
    private Equipo equipoLocal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EquipoID_Visitante_ID", nullable = false)
    private Equipo equipoVisitante;

    public Partida(Equipo equipoVisitante, Equipo equipoLocal, Torneo torneo, int resultado, Integer duracion, Date fechaHora) {
        this.equipoVisitante = equipoVisitante;
        this.equipoLocal = equipoLocal;
        this.torneo = torneo;
        this.resultado = resultado;
        this.duracion = duracion;
        this.fechaHora = fechaHora;
    }

    public Partida() {}

    public int getPartidaID() {
        return partidaID;
    }

    public void setPartidaID(int partidaID) {
        this.partidaID = partidaID;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "partidaID=" + partidaID +
                ", fechaHora=" + fechaHora +
                ", duracion=" + duracion +
                ", resultado=" + resultado +
                ", torneo=" + torneo +
                ", equipoLocal=" + equipoLocal +
                ", equipoVisitante=" + equipoVisitante +
                '}';
    }
}
