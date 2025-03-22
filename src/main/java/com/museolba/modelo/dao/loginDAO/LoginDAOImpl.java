package com.museolba.modelo.dao.loginDAO;

import com.museolba.modelo.entidades.usuario.Usuario;
import com.museolba.modelo.jpaController.PersistenceJpaController;
import com.museolba.utils.ContraseniaEncriptacionUtils;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


public class LoginDAOImpl extends PersistenceJpaController implements LoginDAO{
    
     @Override
    public Usuario verificarCredenciales(String nombreUsuario, String contrasenia) {
        EntityManager em = getEmf().createEntityManager();

        try {
            // Primero buscamos al usuario solo por nombre de usuario
            String queryStr = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario";
            Query query = em.createQuery(queryStr);
            query.setParameter("nombreUsuario", nombreUsuario);

            Usuario usuario = (Usuario) query.getSingleResult();
            
            // Verificamos la contraseña usando BCrypt
            if (usuario != null && ContraseniaEncriptacionUtils.checkContrasenia(contrasenia, usuario.getContrasenia())) {
                return usuario;
            } else {
                return null;
            }
        } catch (NoResultException e) {
            // Usuario no encontrado
            return null;
        } catch (Exception e) {
            // Otra excepción
            return null;
        } finally {
            em.close();
        }
    }
    
}
