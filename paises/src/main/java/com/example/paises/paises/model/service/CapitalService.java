package com.example.paises.paises.model.service;

import com.example.paises.paises.model.dao.ICapitalDAO;
import com.example.paises.paises.model.entity.Capital;
import com.example.paises.paises.model.entity.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapitalService {
    @Autowired
    ICapitalDAO capitalDAO;

    @Autowired
    PaisService paisService;

    public Capital getById(Integer id){
        // logica de negocio
        if(id == null)
            return null;

        return capitalDAO.getReferenceById(id);
    }

    public List<Capital> findAll(){
        return capitalDAO.findAll();
    }

    public Integer save(Capital capital){
        capitalDAO.save(capital);
        return 0;
    }

    public void delete(Integer id){
        Pais pais = paisService.getByCapital(id);
        if (pais == null)
            capitalDAO.deleteById(id);
        else paisService.delete(pais.getCOD_P());
    }
}
