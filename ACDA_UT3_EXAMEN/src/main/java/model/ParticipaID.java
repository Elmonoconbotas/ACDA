package model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParticipaID implements Serializable {
    private int torneoID;
    private int equipoID;

    public ParticipaID(int torneoID, int equipoID) {
        this.torneoID = torneoID;
        this.equipoID = equipoID;
    }

    public ParticipaID() {}

    public int getTorneoID() {
        return torneoID;
    }

    public void setTorneoID(int torneoID) {
        this.torneoID = torneoID;
    }

    public int getEquipoID() {
        return equipoID;
    }

    public void setEquipoID(int equipoID) {
        this.equipoID = equipoID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipaID that = (ParticipaID) o;
        return torneoID == that.torneoID && equipoID == that.equipoID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(torneoID, equipoID);
    }

    @Override
    public String toString() {
        return "ParticipaID: torneoID=" + torneoID + ", equipoID=" + equipoID;
    }
}
