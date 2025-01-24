package dao;

import model.Jugador;

public class JugadorDAO extends GenericDAOImpl<Jugador, Integer> {
    public JugadorDAO() {
        super(Jugador.class);
    }
}

