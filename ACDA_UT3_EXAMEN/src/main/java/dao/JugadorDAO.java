package dao;

import connection.HibernateUtil;
import model.Jugador;
import org.hibernate.Session;

public class JugadorDAO extends GenericDAOImpl<Jugador, Integer> {
    public JugadorDAO() {
        super(Jugador.class);
    }
}

