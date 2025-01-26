package dao;

import connection.HibernateUtil;
import model.Equipo;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class EquipoDAO extends GenericDAOImpl<Equipo, Integer> {
    public EquipoDAO() {
        super(Equipo.class);
    }

    public Equipo findByIdWithJugadoresYPartidas(Integer equipoID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Equipo equipo = session.get(Equipo.class, equipoID);
            Hibernate.initialize(equipo.getJugadores());
            Hibernate.initialize(equipo.getPartidasLocal());
            Hibernate.initialize(equipo.getPartidasVisitante());
            return equipo;
        }
    }

    public List<Equipo> findByPresupuestoGreatherThan(BigDecimal presupuestoMinimo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Equipo WHERE presupuesto > :presupuestoMinimo";
            Query<Equipo> query = session.createQuery(hql, Equipo.class);
            query.setParameter("presupuestoMinimo", presupuestoMinimo);
            return query.getResultList();
        }
    }

    public List<Equipo> findWinners() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = """
                SELECT e 
                FROM Equipo e 
                JOIN Participa p ON e.id = p.equipo.id
                WHERE p.clasificacion = 1""";
            Query<Equipo> query = session.createQuery(hql, Equipo.class);
            return query.getResultList();
        }
    }
}