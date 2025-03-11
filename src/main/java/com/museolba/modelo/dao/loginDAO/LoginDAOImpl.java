package com.museolba.modelo.dao.loginDAO;

import com.museolba.modelo.entidades.EstadoPersonal;
import com.museolba.modelo.entidades.Usuario;
import com.museolba.modelo.jpaController.PersistenceJpaController;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class LoginDAOImpl extends PersistenceJpaController implements LoginDAO{

    @Override
    public Usuario verificarCredenciales(String nombreUsuario, String contrasenia) {
        EntityManager em = getEmf().createEntityManager();

        try {
            String queryStr = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario AND u.contrasenia = :contrasenia";
            Query query = em.createQuery(queryStr);
            query.setParameter("nombreUsuario", nombreUsuario);
            query.setParameter("contrasenia", contrasenia);

            return (Usuario) query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
    
}
