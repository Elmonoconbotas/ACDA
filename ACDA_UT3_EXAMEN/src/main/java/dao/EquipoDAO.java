package dao;

import connection.HibernateUtil;
import model.Equipo;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import service.JugadorService;

import java.util.List;

public class EquipoDAO extends GenericDAOImpl<Equipo, Integer>{
    public EquipoDAO(){super(Equipo.class);}

    public List<Equipo> findByIdWithPartidasYJugadores(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Equipo> equipos = findAll();
        for(Equipo equipo : equipos){
            Hibernate.initialize(equipo.getJugadores());
            Hibernate.initialize(equipo.getParticipaciones());
        }
        return equipos;
    }
    public List<Equipo> findEquiposPresupuestoMayor(Integer presupuestoMinimo) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String hql = "SELECT * FROM Equipo" +
                "WHERE presupuesto > :presupuestoMinimo";
        return session.createQuery(hql, Equipo.class).setParameter("presupuestoMinimo", presupuestoMinimo).getResultList();
    }
}
