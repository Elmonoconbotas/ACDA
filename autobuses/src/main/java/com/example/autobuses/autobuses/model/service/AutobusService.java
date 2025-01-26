package com.example.autobuses.autobuses.model.service;

import com.example.autobuses.autobuses.model.dao.IAutobusDAO;
import com.example.autobuses.autobuses.model.entity.Autobus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.autobuses.autobuses.constants.ErrorConstants.PARAM_NULL;
import static com.example.autobuses.autobuses.constants.ErrorConstants.RESULT_OK;
import java.util.List;

@Service
public class AutobusService {
    @Autowired
    private IAutobusDAO autobusDAO;

    public Integer save(Autobus autobus) {
        if (autobus == null)
            return PARAM_NULL;
        autobusDAO.save(autobus);
        return RESULT_OK;
    }

    public List<Autobus> findAll() {
        return autobusDAO.findAll();
    }

    public Autobus findById(Integer id) {
        if (id == null)
            return null;
        return autobusDAO.getReferenceById(id);
    }

    public Integer deleteById(Integer id) {
        if (id == null)
            return PARAM_NULL;
        autobusDAO.deleteById(id);
        return RESULT_OK;
    }

    public Integer delete(Autobus autobus) {
        if (autobus == null)
            return PARAM_NULL;
        autobusDAO.delete(autobus);
        return RESULT_OK;
    }
}
