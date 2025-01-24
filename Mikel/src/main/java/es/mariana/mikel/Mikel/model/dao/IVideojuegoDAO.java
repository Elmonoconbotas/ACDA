package es.mariana.mikel.Mikel.model.dao;

import es.mariana.mikel.Mikel.model.entity.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface IVideojuegoDAO extends JpaRepository<Videojuego, Integer> {
}
