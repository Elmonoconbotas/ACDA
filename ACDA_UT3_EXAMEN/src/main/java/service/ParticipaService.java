package service;

import dao.ParticipaDAO;
import model.Participa;

public class ParticipaService extends GenericServiceImpl<Participa, Integer>{
    public ParticipaService() {super(new ParticipaDAO());}
}
