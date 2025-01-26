package service;

import dao.JugadorDAO;
import model.Jugador;

public class JugadorService extends GenericServiceImpl<Jugador, Integer> {
    public JugadorService() {
        super(new JugadorDAO());
    }
}