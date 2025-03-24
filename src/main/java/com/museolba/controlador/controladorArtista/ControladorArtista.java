package com.museolba.controlador.controladorArtista;

import com.museolba.modelo.entidades.artista.Artista;
import com.museolba.modelo.dao.artistaDAO.ArtistaDAOImpl;
import com.museolba.modelo.jpaController.artistaJpaController.ArtistaJpaController;
import java.util.List;
import java.util.Optional;


public class ControladorArtista {
   private final ArtistaDAOImpl artistaDAO;
   private final ArtistaJpaController artistaJpaController;

    public ControladorArtista() {
       this.artistaDAO = new ArtistaDAOImpl();
       this.artistaJpaController = new ArtistaJpaController();
    }
    
    public void crearArtista(Artista artista) throws Exception{
        artistaJpaController.crearArtista(artista);
    }
    
    public void editarArtista(Long id, String nuevoNombre, String nuevoCorreo, String nuevoTelefono) throws Exception{
        artistaJpaController.editarArtista(id, nuevoNombre, nuevoCorreo, nuevoTelefono);
    }
  
    public List<Artista> traerTodosLosArtistas(){
        return artistaDAO.obtenerTodosLosArtistas();
    }
    
    public Optional<Artista> buscarArtistaPorId(Long id) throws Exception{
        return artistaJpaController.obtenerArtistaPorId(id);
    }
    
    public List<Artista> buscarArtistaPorNombre(String nombre) throws Exception{
        return artistaDAO.buscarArtistasPorNombre(nombre);
    }
    
}
