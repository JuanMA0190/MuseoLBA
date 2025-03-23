package com.museolba.modelo.dao.obraDAO;

import com.museolba.modelo.entidades.obra.Obra;
import java.util.List;


public interface ObraDAO {
    public List<Obra> findObrasBySala(Long salaId);
    public List<Obra> findAllObras();
    public List<Obra> findObrasByNombre(String nombre);
    public List<Obra> findObrasByTerminoArtista(String termino);
}
