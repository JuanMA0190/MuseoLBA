package com.museolba.controlador.controladorUsuario;

import com.museolba.modelo.dao.personalDAO.PersonalDAOImpl;
import com.museolba.modelo.entidades.Personal;
import com.museolba.modelo.jpaController.PersonalJpaController;
import java.util.List;
import javax.persistence.NoResultException;

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
    
    /*public void cargarTablaPersonal(JTable tabla, String[] titulos) {
        List<Object[]> datos = personalDAO.obtenerPersonalConDetalles();

        UtilsValidacion.cargarTabla(tabla, datos, titulos, fila -> fila);
        if (datos.isEmpty()) {
            UtilsValidacion.MsjAlert("No se encontraron resultados para el filtro y término proporcionados.", 1, "Sin Resultados");
        }
    }*/
    
    public List<Object[]> obtenerDatosPersonal() {
    List<Object[]> datos = personalDAO.obtenerPersonalConDetalles();
    if (datos.isEmpty()) {
        throw new NoResultException("No se encontraron resultados para el filtro y término proporcionados.");
    }
    return datos;
}
    /*
    public void buscarYMostrarResultados(String filtro, String termino, JTable tabla, String[] titulos) {
        if (termino.isEmpty()) {
            //UtilsValidacion.MsjAlert(, 2, "Búsqueda Vacía");
            throw new NoResultException("Por favor, ingrese un término de búsqueda.");
            return
        }
        List<Object[]> resultados = personalDAO.buscarPorFiltro(filtro, termino);
        UtilsValidacion.cargarTabla(tabla, resultados, titulos, fila -> fila);
        if (resultados.isEmpty()) {
            throw new NoResultException("No se encontraron resultados para el filtro y término proporcionados.");
            //UtilsValidacion.MsjAlert(, 1, "Sin Resultados");
        }
    }*/
    
     public List<Object[]> buscarYMostrarResultados(String filtro, String termino) {
        if (termino.isEmpty()) {
            //UtilsValidacion.MsjAlert(, 2, "Búsqueda Vacía");
            throw new NoResultException("Por favor, ingrese un término de búsqueda.");
        }
        List<Object[]> resultados = personalDAO.buscarPorFiltro(filtro, termino);
        //UtilsValidacion.cargarTabla(tabla, resultados, titulos, fila -> fila);
        if (resultados.isEmpty()) {
            throw new NoResultException("No se encontraron resultados para el filtro y término proporcionados.");
            //UtilsValidacion.MsjAlert(, 1, "Sin Resultados");
        }
        return resultados;
    }
}
