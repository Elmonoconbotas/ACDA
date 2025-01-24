package ACDA_UT4_1a1.model.service;

import ACDA_UT4_1a1.model.dao.ICapitalDAO;
import ACDA_UT4_1a1.model.dao.IPaisDAO;
import ACDA_UT4_1a1.model.entity.Capital;
import ACDA_UT4_1a1.model.entity.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {
    @Autowired
    private IPaisDAO paisDAO;
    private CapitalService capitalService;
    public Pais getByID(Integer id) {
        if (id == null) {
            return null;
        }

        return paisDAO.getReferenceById(id);
    }

    public List<Pais> findAll() {
        return paisDAO.findAll();
    }

    public Integer save(Pais pais) {

        paisDAO.save(pais);
        return 0;
    }

    public void deleteAll() {
        paisDAO.deleteAll();
    }


    public void update(Pais pais) {
        paisDAO.save(pais);
    }

    public void deleteById(Integer id) {
        paisDAO.deleteById(id);
    }
}