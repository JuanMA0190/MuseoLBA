package com.museolba.controlador.controladorObra;

import com.museolba.modelo.dao.obraDAO.ObraDAOImpl;
import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.entidades.obra.Sala;
import com.museolba.modelo.dao.obraDAO.SalaDAOImpl;
import java.util.List;
import javax.persistence.EntityNotFoundException;


public class ControladorObra {
     private final ObraDAOImpl obraJpaController;
    private final SalaDAOImpl salaJpaController;

    public ControladorObra() {
        this.obraJpaController = new ObraDAOImpl();
        this.salaJpaController = new SalaDAOImpl();
    }
    /*
    // Método para agregar una obra
    public void agregarObra(Obra obra, Sala sala) {
        obra.setSala(sala);  // Asignar la sala a la obra
        obraJpaController.create(obra); 
    }

    public List<Sala> obtenerTodasLasSalas() {
        return salaJpaController.findAll();
    }

    // Método para buscar una obra por ID
    public Obra buscarObraPorId(Long id) {
        return obraJpaController.find(id);
    }

    // Método para buscar obras por artista
    public List<Obra> buscarObrasPorArtista(String artista) {
        return obraJpaController.findObrasByArtista(artista);
    }

    // Método para buscar obras por sala
    public List<Obra> buscarObrasPorSala(Long salaId) {
        return obraJpaController.findObrasBySala(salaId);
    }

    // Método para eliminar una obra
    public void eliminarObra(Long id) throws EntityNotFoundException {
        obraJpaController.destroy(id);
    }

    // Método para actualizar una obra
    public void actualizarObra(Obra obra) throws Exception {
        if (obra != null && obra.getNumInv() != null) {
            obraJpaController.edit(obra, obra.getNumInv());
        } else {
            throw new Exception("La obra no existe o no tiene un número de inventario válido");
        }
    }
    
    public List<Obra> todasObras() {
        return obraJpaController.findAllObras();
    }
    
    public List<Obra> findObrasByTerminoArtista(String termino){
        return obraJpaController.findObrasByTerminoArtista(termino);
    }*/
    
}
