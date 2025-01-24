package es.mariana.diego.Diego.model.dao;

import es.mariana.diego.Diego.model.entity.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IVideojuegoDAO extends JpaRepository<Videojuego, Integer> {

}
