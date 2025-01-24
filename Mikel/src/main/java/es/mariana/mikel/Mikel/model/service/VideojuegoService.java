package es.mariana.mikel.Mikel.model.service;

import es.mariana.mikel.Mikel.model.dao.IVideojuegoDAO;
import es.mariana.mikel.Mikel.model.entity.Videojuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideojuegoService {

    @Autowired
    private IVideojuegoDAO videojuegoDAO;

    public Videojuego getById(Integer id) {
        // Lógica de negocio
        if (id == null)
            return null;

        return videojuegoDAO.getReferenceById(id);
    }

    public List<Videojuego> findAll() {
        return videojuegoDAO.findAll();
    }

    public Integer save(Videojuego videojuego) {
        videojuegoDAO.save(videojuego);
        return 0;
    }

    public void deleteById(Integer id) {
        videojuegoDAO.deleteById(id);
    }
}
