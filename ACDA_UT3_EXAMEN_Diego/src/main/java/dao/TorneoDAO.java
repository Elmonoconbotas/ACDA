package dao;

import model.Torneo;

public class TorneoDAO extends GenericDAOImpl<Torneo, Integer> {
    public TorneoDAO() {
        super(Torneo.class);
    }
}
