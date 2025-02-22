package com.example.autobuses.autobuses.model.service;

import com.example.autobuses.autobuses.model.dao.IConduceDAO;
import com.example.autobuses.autobuses.model.entity.Conduce;
import com.example.autobuses.autobuses.model.entity.ConduceID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.autobuses.autobuses.constants.ErrorConstants.PARAM_NULL;
import static com.example.autobuses.autobuses.constants.ErrorConstants.RESULT_OK;
@Service
public class ConduceService {
    @Autowired
    private IConduceDAO conduceDAO;

    public Integer save(Conduce conduce) {
        if (conduce == null || conduce.getConduceID() == null) {
            return PARAM_NULL; // Asegúrate de manejar este caso
        }
        conduceDAO.save(conduce);
        return RESULT_OK;
    }

    public List<Conduce> findAll() {
        return conduceDAO.findAll();
    }

    public Conduce findById(ConduceID conduceID) {
        if (conduceID == null)
            return null;
        return conduceDAO.getReferenceById(conduceID);
    }

    public Integer delete(ConduceID conduceID) {
        if (conduceID == null)
            return PARAM_NULL;
        conduceDAO.deleteById(conduceID);
        return RESULT_OK;
    }
    /*public Integer deleteById(Integer id) {
        if (id == null)
            return PARAM_NULL;
        conduceDAO.deleteById(id);
        return RESULT_OK;
    }*/
}
