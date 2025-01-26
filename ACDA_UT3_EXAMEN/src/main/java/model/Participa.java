package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "Participa")
public class Participa {
    @EmbeddedId
    private ParticipaID participaID = new ParticipaID();

    @Min(value = 1, message = "No se admiten valores menores a 1")
    @Column(name = "Clasificacion")
    private int clasificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("torneoID")
    @JoinColumn(name = "torneoID", nullable = false)
    private Torneo torneo;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("equipoID")
    @JoinColumn(name = "equipoID", nullable = false)
    private Equipo equipo;

    public Participa() {}

    public Participa(int clasificacion, Torneo torneo, Equipo equipo) {
        this.clasificacion = clasificacion;
        this.torneo = torneo;
        this.equipo = equipo;
    }

    public ParticipaID getParticipaID() {
        return participaID;
    }

    public void setParticipaID(ParticipaID participaID) {
        this.participaID = participaID;
    }

    @Min(value = 1, message = "No se admiten valores menores a 1")
    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(@Min(value = 1, message = "No se admiten valores menores a 1") int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Participa{" +
                "participaID=" + participaID +
                ", clasificacion=" + clasificacion +
                ", torneo=" + torneo +
                ", equipo=" + equipo +
                '}';
    }
}
