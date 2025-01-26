package service;

import dao.ParticipaDAO;
import model.Participa;
import model.ParticipaID;

public class ParticipaService extends GenericServiceImpl<Participa, ParticipaID> {
    public ParticipaService() {
        super(new ParticipaDAO());
    }
}