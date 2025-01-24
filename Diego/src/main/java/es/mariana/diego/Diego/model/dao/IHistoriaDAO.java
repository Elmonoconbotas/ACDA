package es.mariana.diego.Diego.model.dao;

import es.mariana.diego.Diego.model.entity.Historia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHistoriaDAO extends JpaRepository<Historia, Integer> {
}
