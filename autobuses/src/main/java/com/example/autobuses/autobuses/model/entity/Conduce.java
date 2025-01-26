package com.example.autobuses.autobuses.model.entity;

import jakarta.persistence.*;

@Entity
public class Conduce {

    @EmbeddedId
    private ConduceID conduceID = new ConduceID();

    private String trayecto;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("autobusID")
    @JoinColumn(name = "autobusID", nullable = false)
    private Autobus autobus;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("conductorID")
    @JoinColumn(name = "conductorID", nullable = false)
    private Conductor conductor;

    public ConduceID getConduceID() {
        return conduceID;
    }

    public void setConduceID(ConduceID conduceID) {
        this.conduceID = conduceID;
    }

    public String getTrayecto() {
        return trayecto;
    }

    public void setTrayecto(String trayecto) {
        this.trayecto = trayecto;
    }

    public Autobus getAutobus() {
        return autobus;
    }

    public void setAutobus(Autobus autobus) {
        this.autobus = autobus;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}
