package es.mariana.acda.ut4.ejemplorelacion1n.model.dao;

import es.mariana.acda.ut4.ejemplorelacion1n.model.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaDAO extends JpaRepository<Persona, Integer> {
}
