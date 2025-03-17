package com.museolba.controlador.controladorUsuario;

import com.museolba.modelo.dao.usuarioDAO.UsuarioDAOImpl;
import com.museolba.modelo.entidades.enums.EstadoPersonal;
import com.museolba.modelo.entidades.HistorialUsuario;
import com.museolba.modelo.entidades.enums.RolUsuario;
import com.museolba.modelo.entidades.Usuario;
import com.museolba.modelo.jpaController.UsuarioJpaController;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.PersistenceException;


public class ControladorUsuario {
    private final UsuarioJpaController usuarioJpaController;
    private final UsuarioDAOImpl usuarioDAO;
    
    public ControladorUsuario(){
        this.usuarioJpaController = new UsuarioJpaController();
        this.usuarioDAO = new UsuarioDAOImpl();
    }
    
    public String crearUsuario(Usuario usuario) throws Exception {
        try{
            if (!puedeAgregarUsuarioConRol(usuario.getRolUsuario())) { 
                return "Error: Ya existe un usuario con el rol " + usuario.getRolUsuario();
            }
            usuarioJpaController.create(usuario);
            return "Usuario creado exitosamente.";
   
        }catch(Exception e){
            //e.printStackTrace();
            //System.out.println(e.getMessage());
            return "Error hay datos duplicados de usuario!";
        }
        
    }
    public void editarUsuario(Usuario usuario, RolUsuario rolUsuarioOriginal) throws Exception {
        if (usuario.getEstado() == EstadoPersonal.ACTIVO) {
        RolUsuario rolUsuarioModificado = usuario.getRolUsuario();

        // Si el rol no cambia, solo editar el usuario
        if (rolUsuarioModificado == rolUsuarioOriginal) {
            usuarioJpaController.edit(usuario, usuario.getnLegajo());
            return;
        }

        // Verificar si el nuevo rol es Jefe de Departamento o Jefe de Personal
        if (rolUsuarioModificado == RolUsuario.JEFEDEDEPARTAMENTO || rolUsuarioModificado == RolUsuario.JEFEDEPERSONAL) {
            long cantidadActual = this.usuarioDAO.contarUsuariosPorRol(rolUsuarioModificado);

            // Si ya hay un jefe con ese rol, impedir la edición
            if (cantidadActual > 0) {
                throw new PersistenceException("Ya existe un usuario con el rol " + rolUsuarioModificado + ". No se puede asignar a otro.");
            }
        }

        // Si todo está correcto, editar usuario
        usuarioJpaController.edit(usuario, usuario.getnLegajo());
    } else {
        throw new IllegalAccessException("Usuario dado de baja no se puede modificar");
    }
        
    }

    
    public Usuario obtenerUsuario(long id) {
        return usuarioJpaController.findUsuario(id);
    }

    
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioJpaController.findAll();
    }
    
    private boolean puedeAgregarUsuarioConRol(RolUsuario rolUsuario) {
        if (rolUsuario == RolUsuario.JEFEDEDEPARTAMENTO || rolUsuario == RolUsuario.JEFEDEPERSONAL) {
            long cantidad = usuarioDAO.contarUsuariosPorRol(rolUsuario);
            return cantidad == 0;
        }
        return true;
    }
    
    //0:Eliminar 1:Activo 2:Inactivo
    public String cambiarEstadoHistorialYUsuario(long id, String razonInactividad, int seleccionOperacion){
        try {
            String operacion= "";
            String historial= "";
            Usuario usuario = usuarioJpaController.findUsuario(id);
            
            if (usuario == null) {
                return "Usuario no encontrado.";
            }
            
            switch(seleccionOperacion){
                case 0 -> {
                    operacion = eliminarUsuario(usuario);
                    if(operacion.startsWith("ERROR.")){
                        return operacion;
                    }
                    historial = ModificarHistorialUsuario(usuario, EstadoPersonal.INACTIVO, "ELIMINADO: Usuario eliminado permanentemente.");
                    break;
                }
                case  1 -> {
                    operacion = activarUsuario(usuario);
                    if(operacion.startsWith("ERROR.")){
                        return operacion;
                    }
                    historial = ModificarHistorialUsuario(usuario, EstadoPersonal.ACTIVO, "-");
                    break;
                }
                case 2 -> {
                    operacion = desactivarUsuario(usuario);
                    if(operacion.startsWith("ERROR.")){
                        return operacion;
                    }
                    historial = ModificarHistorialUsuario(usuario, EstadoPersonal.INACTIVO, razonInactividad);
                    break;
                }   
                default -> {
                    return "Operacion incorrecta.";
                }
            }
  
            if (historial.startsWith("Error")) {
                return historial;
            }

            return operacion;
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar el usuario: " + e.getMessage();
        }
    }
    
    private String ModificarHistorialUsuario(Usuario usuario, EstadoPersonal estado, String razon){
        ControladorHistorialUsuario controladorHistorial = new ControladorHistorialUsuario();
            String resultadoHistorial = controladorHistorial.actualizarHistorial(
                usuario.getnLegajo(),
                LocalDateTime.now(),
                estado,
                razon
            );
    
        return resultadoHistorial;
   
    }
    
    private String eliminarUsuario(Usuario usuario){
        try{
            // Validar si es seguro eliminar al usuario según su rol
            if (usuario.getRolUsuario() == RolUsuario.JEFEDEDEPARTAMENTO || usuario.getRolUsuario() == RolUsuario.JEFEDEPERSONAL) {

                RolUsuario rolACambiar = usuario.getRolUsuario();
                long cantidadConRol = 0;
                
                if(rolACambiar == RolUsuario.JEFEDEDEPARTAMENTO){
                    cantidadConRol = usuarioDAO.contarUsuariosPorRol(RolUsuario.JEFEDEPERSONAL);
                }else if(rolACambiar == RolUsuario.JEFEDEPERSONAL){
                    cantidadConRol = usuarioDAO.contarUsuariosPorRol(RolUsuario.JEFEDEDEPARTAMENTO);
                }
                
                if (cantidadConRol <= 0) {
                    return "ERROR. No se puede eliminar. Debe haber al menos un usuario con rol superior";
                }
            }
            
            // Cambiar el estado del usuario a eliminado
            usuario.setEstado(EstadoPersonal.INACTIVO);
            usuario.setRolUsuario(RolUsuario.PERSONAL);
            usuarioJpaController.edit(usuario, usuario.getnLegajo());
            
            return "Usuario eliminado correctamente.";     
        }catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar el usuario: " + e.getMessage();
        }    
    }
    
    private String activarUsuario(Usuario usuario){
        
        try{
            ControladorHistorialUsuario controladorHistorial = new ControladorHistorialUsuario();
           
            HistorialUsuario hu = controladorHistorial.obtenerHistorialPorUsuario(usuario.getnLegajo());

            if(hu.getRazonInactividad().equals("ELIMINADO: Usuario eliminado permanentemente.")){
                return "ERROR. No se puede dar de alta este usuario ya que fue eliminado";
            }

            // Cambiar el estado del usuario a inactivo
            usuario.setEstado(EstadoPersonal.ACTIVO);
            usuarioJpaController.edit(usuario, usuario.getnLegajo());

            return "Usuario dado de alta conrrectamente";
            
        }catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar el usuario: " + e.getMessage();
        }    
    }
    
    private long contadorEstadoPorRol(){
        long cantidadActivoRolJDD = usuarioDAO.contarUsuarioPorRolYEstado(RolUsuario.JEFEDEDEPARTAMENTO, EstadoPersonal.ACTIVO);
        long cantidadActivoRolJDP = usuarioDAO.contarUsuarioPorRolYEstado(RolUsuario.JEFEDEPERSONAL, EstadoPersonal.ACTIVO);
        return cantidadActivoRolJDD + cantidadActivoRolJDP;
    }
    
    private String desactivarUsuario(Usuario usuario){
        try{
            if (contadorEstadoPorRol() > 1) {
               // Cambiar el estado del usuario a inactivo
                usuario.setEstado(EstadoPersonal.INACTIVO);
                usuarioJpaController.edit(usuario, usuario.getnLegajo());

                return "Usuario desactivado correctamente."; 
            }else
                return "ERROR. No se puede dar de baja. Debe haber al menos un usuario con rol Jefe de Departamento o Jefe de Personal activo!";

        }catch (Exception e) {
            e.printStackTrace();
            return "Error al desactivar el usuario: " + e.getMessage();
        }   
    }

}
