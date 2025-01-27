package com.example.autobuses.autobuses.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ConduceID implements Serializable {
    private Integer conductorID;
    private Integer autobusID;

    public ConduceID(int conductorID, int autobusID) {
        this.conductorID = conductorID;
        this.autobusID = autobusID;
    }

    public ConduceID() {}

    public int getConductorID() {
        return conductorID;
    }

    public void setConductorID(int conductorID) {
        this.conductorID = conductorID;
    }

    public int getAutobusID() {
        return autobusID;
    }

    public void setAutobusID(int autobusID) {
        this.autobusID = autobusID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConduceID that = (ConduceID) o;
        return conductorID == that.conductorID && autobusID == that.autobusID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conductorID, autobusID);
    }

    @Override
    public String toString() {
        return  conductorID + "," + autobusID;
    }
}
