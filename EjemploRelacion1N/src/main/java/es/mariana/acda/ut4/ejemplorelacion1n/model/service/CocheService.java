package es.mariana.acda.ut4.ejemplorelacion1n.model.service;

import es.mariana.acda.ut4.ejemplorelacion1n.model.dao.ICocheDAO;
import es.mariana.acda.ut4.ejemplorelacion1n.model.entity.Coche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static es.mariana.acda.ut4.ejemplorelacion1n.constants.ErrorConstants.PARAM_NULL;
import static es.mariana.acda.ut4.ejemplorelacion1n.constants.ErrorConstants.RESULT_OK;

@Service
public class CocheService {

    @Autowired
    private ICocheDAO cocheDAO;

    public Integer save(Coche coche) {
        if (coche == null)
            return PARAM_NULL;
        cocheDAO.save(coche);
        return RESULT_OK;
    }

    public List<Coche> findAll() {
        return cocheDAO.findAll();
    }

    public Coche findById(Integer id) {
        if (id == null)
            return null;
        return cocheDAO.getReferenceById(id);
    }

    public Integer deleteById(Integer id) {
        if (id == null)
            return PARAM_NULL;
        cocheDAO.deleteById(id);
        return RESULT_OK;
    }

    public Integer delete(Coche coche) {
        if (coche == null)
            return PARAM_NULL;
        cocheDAO.delete(coche);
        return RESULT_OK;
    }
}
