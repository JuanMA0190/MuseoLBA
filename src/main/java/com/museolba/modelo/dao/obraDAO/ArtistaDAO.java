package com.museolba.modelo.dao.obraDAO;

import com.museolba.modelo.entidades.obra.Artista;
import java.util.List;


public interface ArtistaDAO {
    public List<Artista> obtenerTodosLosArtistas();
    public List<Artista> buscarArtistasPorNombre(String nombre);
}
