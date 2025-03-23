package com.museolba.modelo.dao.obraDAO;

import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.entidades.obra.Sala;
import java.util.List;


public interface SalaDAO {
    public List<Sala> findSalasByNombre(String nombre);
    public List<Obra> getObrasBySala(Long salaId);
    public Sala encontrarSalaByNombre(String nombre);
}
