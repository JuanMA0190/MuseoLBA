package com.museolba.controlador.controladorUsuario;

import com.museolba.modelo.dao.personalDAO.PersonalDAOImpl;
import com.museolba.modelo.entidades.Personal;
import com.museolba.modelo.jpaController.PersonalJpaController;
import java.util.List;

public class ControladorPersonal {
    
    private final PersonalJpaController personalJpaController;
    private final PersonalDAOImpl personalDAO;
    
    public ControladorPersonal(){
        this.personalJpaController = new PersonalJpaController();
        this.personalDAO = new PersonalDAOImpl();
      
    }
    
    public void crearPersonal(Personal personal) throws Exception {
        personalJpaController.create(personal);
    }
    public void editarPersonal(Personal personal) throws Exception {
        personalJpaController.edit(personal, personal.getnLegajo());
    }

    
    public void eliminarPersonal(long id) throws Exception {
        personalJpaController.destroy(id);
    }

    
    public Personal obtenerPersonal(long id) {
        return personalJpaController.findPersonal(id);
    }

    
    public List<Personal> obtenerTodosLosPersonal() {
        return personalJpaController.findAll();
    }
    
    
    public boolean verificarLegajo(long nLegajo) {
        return personalDAO.existeLegajo(nLegajo);
    }
}
