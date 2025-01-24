package com.example.paises.paises.model.service;

import com.example.paises.paises.model.dao.IPaisDAO;
import com.example.paises.paises.model.entity.Capital;
import com.example.paises.paises.model.entity.Pais;
import org.hibernate.HibernateError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.channels.Pipe;
import java.sql.SQLException;
import java.util.List;

@Service
public class PaisService {
    @Autowired
    IPaisDAO paisDAO;
    CapitalService capitalService;

    public Pais getById(Integer id){
        // logica de negocio
        if(id == null)
            return null;
        return paisDAO.getReferenceById(id);
    }

    public List<Pais> findAll(){
        return paisDAO.findAll();
    }

    public Integer save(Pais pais){
        /*Capital capital = capitalService.getById(pais.getCapital().getCOD_C());
        if(capital == null){
            System.out.println("[x] Error: La capital no existe, introduce una capital valida...");
            return 1;
        }else{*/
        try{
            paisDAO.save(pais);
            return 0;
        } catch (Exception e) {
            System.out.println("[x] Error: La capital no existe, introduce una capital valida...");
            return 1;
        }
    }

    public void delete(Integer id){
        paisDAO.deleteById(id);
    }

    public Pais getByCapital(Integer capitalID) {
        Pais pais = paisDAO.findPaisByCapitalId(capitalID);
        return pais;
    }
}
