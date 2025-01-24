package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Participa")
public class Participa {
    @EmbeddedId
    private ParticipaID participaID = new ParticipaID();


    @Size(min = 1)
    @Transient
    private int clasificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipoID", nullable = false)
    private Equipo equipo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "torneoID", nullable = false)
    private Torneo torneo;

    public Participa(){}

    public ParticipaID getParticipaID() {
        return participaID;
    }

    public void setParticipaID(ParticipaID participaID) {
        this.participaID = participaID;
    }

    @Size(min = 1)
    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(@Size(min = 1) int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }
}
