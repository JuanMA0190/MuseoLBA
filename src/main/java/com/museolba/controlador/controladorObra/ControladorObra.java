package com.museolba.controlador.controladorObra;

import com.museolba.modelo.dao.obraDAO.ObraDAOImpl;
import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.entidades.sala.Sala;
import com.museolba.modelo.dao.salaDAO.SalaDAOImpl;
import com.museolba.modelo.entidades.obra.EstadoExposicion;
import com.museolba.modelo.jpaController.obraJpaController.ObraJpaController;
import java.util.List;
import java.util.Optional;


public class ControladorObra {
    private final ObraDAOImpl obraDAO;
    private final ObraJpaController obraJpaController;
    
    public ControladorObra() {
        this.obraDAO = new ObraDAOImpl();
        this.obraJpaController = new ObraJpaController();
    }
   
    public void crearObra(Obra obra) throws Exception{
        if(obra.getSala().getNombre().equals("Entregado al Artista")){
            throw new IllegalStateException("Seleccione una sala válida!");
        }
        
        obraJpaController.crearObra(obra);
    }
    
    public void editarObra(Obra obra) throws Exception{
        obraJpaController.editarObra(obra);
    }
    
    
    public List<Obra> obtenerTodasLasObras(){
        return obraDAO.obtenerTodasLasObras();
    }
    
    public Optional<Obra> obtenerObraPorId(Long id){
        return obraJpaController.obtenerObraPorId(id);
    }
    
    public Optional<Obra> obtenerObraPorIdConRelaciones(Long id) {
        return obraDAO.obtenerObraPorIdConRelaciones(id);
    }
}
