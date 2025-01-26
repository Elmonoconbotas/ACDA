package service;

import dao.EquipoDAO;
import model.Equipo;

import java.math.BigDecimal;
import java.util.List;

public class EquipoService extends GenericServiceImpl<Equipo, Integer> {
    public EquipoService() {
        super(new EquipoDAO());
    }

    public Equipo findByIdWithJugadoresYPartidas(Integer equipoID) {
        EquipoDAO equipoDAO = (EquipoDAO) getDao();
        return equipoDAO.findByIdWithJugadoresYPartidas(equipoID);
    }

    public List<Equipo> findByPresupuestoGreatherThan(BigDecimal presupuestoMinimo) {
        EquipoDAO equipoDAO = (EquipoDAO) getDao();
        return equipoDAO.findByPresupuestoGreatherThan(presupuestoMinimo);
    }

    public List<Equipo> findWinners() {
        EquipoDAO equipoDAO = (EquipoDAO) getDao();
        return equipoDAO.findWinners();
    }
}
