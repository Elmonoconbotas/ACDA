package service;

import dao.TorneoDAO;
import model.Torneo;

public class TorneoService extends GenericServiceImpl<Torneo, Integer> {
    public TorneoService() {
        super(new TorneoDAO());
    }
}