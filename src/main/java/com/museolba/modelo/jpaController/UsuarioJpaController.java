package com.museolba.modelo.jpaController;

import com.museolba.modelo.entidades.HistorialUsuario;
import com.museolba.modelo.entidades.Usuario;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class UsuarioJpaController extends BaseJpaController<Usuario, Long> {

    public UsuarioJpaController() {
        super(Usuario.class);
    }

    public Usuario findUsuario(long id) {
        return find(id);
    }
    
    @Override
    public void edit(Usuario usuario, Long id) throws Exception {
            EntityManager em = null;
            try {
                em = getEntityManager();
                em.getTransaction().begin();

                // Actualizar el usuario
                Usuario existingUsuario = em.find(Usuario.class, usuario.getnLegajo());
                if (existingUsuario == null) {
                    throw new Exception("El usuario con legajo " + usuario.getnLegajo() + " no existe.");
                }

                existingUsuario.setNombreUsuario(usuario.getNombreUsuario());
                existingUsuario.setContrasenia(usuario.getContrasenia());
                existingUsuario.setRolUsuario(usuario.getRolUsuario());
                existingUsuario.setEstado(usuario.getEstado());
                em.merge(existingUsuario);

                // Actualizar el historial
                Query query = em.createQuery("SELECT h FROM HistorialUsuario h WHERE h.usuario.nLegajo = :nLegajo");
                query.setParameter("nLegajo", usuario.getnLegajo());
                HistorialUsuario historial = (HistorialUsuario) query.getSingleResult();

                if (historial != null) {
                    historial.registrarModificacion(LocalDateTime.now());
                    em.merge(historial);
                }

                em.getTransaction().commit();
            } catch (Exception e) {
                if (em != null && em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw e;
            } finally {
                if (em != null) {
                    em.close();
                }
            }
    }
    
}
