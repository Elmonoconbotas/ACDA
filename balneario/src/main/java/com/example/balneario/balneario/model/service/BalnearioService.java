package com.example.balneario.balneario.model.service;

import com.example.balneario.balneario.model.dao.IBalnearioDAO;
import com.example.balneario.balneario.model.entity.Balneario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalnearioService {
    @Autowired
    IBalnearioDAO balnearioDAO;

    public Balneario getById(Integer id){
        // logica de negocio
        if(id == null)
            return null;

        return balnearioDAO.getReferenceById(id);
    }

    public List<Balneario> findAll(){
        return balnearioDAO.findAll();
    }

    public Integer save(Balneario balneario){
        balnearioDAO.save(balneario);
        return 0;
    }

    public void delete(Integer id){
        balnearioDAO.deleteById(id);
    }
}
