package com.museolba.modelo.dao.artistaDAO;

import com.museolba.modelo.entidades.artista.Artista;
import java.util.List;


public interface ArtistaDAO {
    public List<Artista> obtenerTodosLosArtistas();
    public List<Artista> buscarArtistasPorNombre(String nombre);
}
