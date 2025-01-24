package ACDA_UT4_1a1.model.service;

import ACDA_UT4_1a1.model.dao.ICapitalDAO;
import ACDA_UT4_1a1.model.entity.Capital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapitalService {
    @Autowired
    private ICapitalDAO capitalDAO;

    public Capital getByID(Integer id){
        if (id == null){
            return null;
        }

        return capitalDAO.getReferenceById(id);
    }
    public List<Capital> findAll(){
        return capitalDAO.findAll();
    }

    public Integer save(Capital capital){
        capitalDAO.save(capital);
        return 0;
    }

    public void deleteAll(){
        capitalDAO.deleteAll();
    }

    public void update(Capital capital){
        capitalDAO.save(capital);
    }

    public void deleteById(Integer id){
        capitalDAO.deleteById(id);
    }
}

