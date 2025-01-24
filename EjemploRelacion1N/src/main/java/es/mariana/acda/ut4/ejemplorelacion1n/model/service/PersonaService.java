package es.mariana.acda.ut4.ejemplorelacion1n.model.service;

import es.mariana.acda.ut4.ejemplorelacion1n.model.dao.IPersonaDAO;
import es.mariana.acda.ut4.ejemplorelacion1n.model.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static es.mariana.acda.ut4.ejemplorelacion1n.constants.ErrorConstants.PARAM_NULL;
import static es.mariana.acda.ut4.ejemplorelacion1n.constants.ErrorConstants.RESULT_OK;

@Service
public class PersonaService {

    @Autowired
    private IPersonaDAO personaDAO;

    public Integer save(Persona persona) {
        if (persona == null)
            return PARAM_NULL;
        personaDAO.save(persona);
        return RESULT_OK;
    }

    public List<Persona> findAll() {
        return personaDAO.findAll();
    }

    public Persona findById(Integer id) {
        if (id == null)
            return null;
        return personaDAO.getReferenceById(id);
    }

    public Integer deleteById(Integer id) {
        if (id == null)
            return PARAM_NULL;
        personaDAO.deleteById(id);
        return RESULT_OK;
    }

    public Integer delete(Persona persona) {
        if (persona == null)
            return PARAM_NULL;
        personaDAO.delete(persona);
        return RESULT_OK;
    }

    /**
     * Devuelve una lista de personas con sus coches cargados.
     */
    public List<Persona> findAllWithCoches() {
        List<Persona> personas = personaDAO.findAll();
        // Carga explícita de la lista de coches para cada persona
        for (Persona persona : personas) {
            persona.getCoches().size(); // Forzar la inicialización de la colección
        }
        return personas;
    }
}
