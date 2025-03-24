package com.museolba.controlador.controladorSala;

import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.entidades.sala.Sala;
import com.museolba.modelo.dao.salaDAO.SalaDAOImpl;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;


public class ControladorSala {
    private final SalaDAOImpl salaDAO;

    public ControladorSala() {
        this.salaDAO = new SalaDAOImpl();
    }
    
    public List<Sala> obtenerTodasLasSalas(){
        return salaDAO.obtenerTodasLasSalas();
    }
    
    public Optional<Sala> buscarSalaPorNombre(String nombre){
        return salaDAO.buscarSalaPorNombre(nombre);
    } 
    
    public List<Sala> obtenerTodasLasSalasConObras(){
        return salaDAO.obtenerTodasLasSalasConObras();
    }
}
