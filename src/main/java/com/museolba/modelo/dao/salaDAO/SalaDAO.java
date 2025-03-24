package com.museolba.modelo.dao.salaDAO;

import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.entidades.sala.Sala;
import java.util.List;
import java.util.Optional;


public interface SalaDAO {
     public List<Sala> obtenerTodasLasSalas();
     public Optional<Sala> buscarSalaPorNombre(String nombre); 
     public List<Sala> obtenerTodasLasSalasConObras();
}
