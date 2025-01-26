package dao;

import model.Participa;
import model.ParticipaID;

public class ParticipaDAO extends GenericDAOImpl<Participa, ParticipaID> {
    public ParticipaDAO() {
        super(Participa.class);
    }
}
