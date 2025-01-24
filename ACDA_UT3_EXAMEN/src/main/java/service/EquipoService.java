package service;

import dao.EquipoDAO;
import model.Equipo;

public class EquipoService extends GenericServiceImpl<Equipo, Integer>{
    public EquipoService(){super(new EquipoDAO());}
}
