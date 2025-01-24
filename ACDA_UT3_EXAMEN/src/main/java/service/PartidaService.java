package service;

import dao.PartidaDAO;
import model.Partida;

public class PartidaService extends GenericServiceImpl<Partida, Integer> {
    public PartidaService() {
        super(new PartidaDAO());
    }
}