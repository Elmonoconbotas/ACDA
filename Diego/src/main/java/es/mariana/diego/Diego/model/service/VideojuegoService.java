package es.mariana.diego.Diego.model.service;

import es.mariana.diego.Diego.model.dao.IVideojuegoDAO;
import es.mariana.diego.Diego.model.entity.Videojuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideojuegoService {
    @Autowired
    IVideojuegoDAO videojuegoDAO;

    public Videojuego getById(Integer id){
        // logica de negocio
        if(id == null)
            return null;
        return videojuegoDAO.getReferenceById(id);
    }

    public List<Videojuego> findAll(){
        return videojuegoDAO.findAll();
    }

    public Integer save(Videojuego videojuego){
        videojuegoDAO.save(videojuego);
        return 0;
    }

    public void delete(Integer id){
        videojuegoDAO.deleteById(id);
    }
}
