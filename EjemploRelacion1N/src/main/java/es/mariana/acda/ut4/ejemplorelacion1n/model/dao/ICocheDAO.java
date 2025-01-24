package es.mariana.acda.ut4.ejemplorelacion1n.model.dao;

import es.mariana.acda.ut4.ejemplorelacion1n.model.entity.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICocheDAO extends JpaRepository<Coche, Integer> {
}
