package com.museolba.controlador.controladorObra;

import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.entidades.obra.Sala;
import com.museolba.modelo.dao.obraDAO.SalaDAOImpl;
import java.util.List;
import javax.persistence.EntityNotFoundException;


public class ControladorSala {
    private final SalaDAOImpl salaJpaController;

    public ControladorSala() {
        this.salaJpaController = new SalaDAOImpl();
    }
    /*

    public Sala encontrarSalaByNombre(String nombre){
        return salaJpaController.encontrarSalaByNombre(nombre);
    }
    
    
    // Método para buscar una sala por ID
    public Sala buscarSalaPorId(Long id) {
        return salaJpaController.find(id);
    }

    // Método para buscar salas por nombre
    public List<Sala> buscarSalasPorNombre(String nombre) {
        return salaJpaController.findSalasByNombre(nombre);
    }

    // Método para obtener todas las obras en una sala
    public List<Obra> obtenerObrasEnSala(Long salaId) {
        return salaJpaController.getObrasBySala(salaId);
    }

    // Método para eliminar una sala
    public void eliminarSala(Long id) throws EntityNotFoundException {
        salaJpaController.destroy(id);
    }

    // Método para actualizar una sala
    public void actualizarSala(Sala sala) throws Exception {
        salaJpaController.edit(sala, sala.getId());
    }*/
}
