package com.example.balneario.balneario.model.service;

import com.example.balneario.balneario.model.dao.ITratamientoDAO;
import com.example.balneario.balneario.model.entity.Tratamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TratamientoService {
    @Autowired
    ITratamientoDAO tratamientoDAO;

    public Tratamiento getById(Integer id){
        // logica de negocio
        if(id == null)
            return null;

        return tratamientoDAO.getReferenceById(id);
    }

    public List<Tratamiento> findAll(){
        return tratamientoDAO.findAll();
    }

    public Integer save(Tratamiento tratamiento){
        tratamientoDAO.save(tratamiento);
        return 0;
    }

    public void delete(Integer id){
        tratamientoDAO.deleteById(id);
    }

}
