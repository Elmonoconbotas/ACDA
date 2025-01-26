package com.example.autobuses.autobuses.model.service;

import com.example.autobuses.autobuses.model.dao.IConductorDAO;
import com.example.autobuses.autobuses.model.entity.Conductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.autobuses.autobuses.constants.ErrorConstants.PARAM_NULL;
import static com.example.autobuses.autobuses.constants.ErrorConstants.RESULT_OK;
import java.util.List;

@Service
public class ConductorService {
    @Autowired
    private IConductorDAO conductorDAO;

    public Integer save(Conductor conductor) {
        if (conductor == null)
            return PARAM_NULL;
        conductorDAO.save(conductor);
        return RESULT_OK;
    }

    public List<Conductor> findAll() {
        return conductorDAO.findAll();
    }

    public Conductor findById(Integer id) {
        if (id == null)
            return null;
        return conductorDAO.getReferenceById(id);
    }

    public Integer deleteById(Integer id) {
        if (id == null)
            return PARAM_NULL;
        conductorDAO.deleteById(id);
        return RESULT_OK;
    }

    public Integer delete(Conductor conductor) {
        if (conductor == null)
            return PARAM_NULL;
        conductorDAO.delete(conductor);
        return RESULT_OK;
    }
}
