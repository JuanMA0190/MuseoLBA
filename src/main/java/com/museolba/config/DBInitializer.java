package com.museolba.config;

import com.museolba.modelo.entidades.EstadoPersonal;
import com.museolba.modelo.entidades.HistorialUsuario;
import com.museolba.modelo.entidades.RolUsuario;
import com.museolba.modelo.entidades.Usuario;
import com.museolba.utils.ContraseniaEncriptacionUtils;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


public class DBInitializer {
    private final EntityManagerFactory emf;

    public DBInitializer(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void initialize() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(u) FROM Usuario u");
            Long count = (Long) query.getSingleResult();

            if (count == 0) {
                System.out.println("Inicializando la base de datos con usuarios y sus historiales...");

                em.getTransaction().begin();

                // Usuario 1
                Usuario jefeDepartamento = new Usuario(
                    1, "Juan", "Pérez", "12345678", "1122334455",
                    "admin.departamento", ContraseniaEncriptacionUtils.hashContrasenia("admin123"),
                    RolUsuario.JEFEDEDEPARTAMENTO
                );
                jefeDepartamento.setEstado(EstadoPersonal.ACTIVO);
                em.persist(jefeDepartamento);

                HistorialUsuario historialJefeDepartamento = new HistorialUsuario(
                    jefeDepartamento,
                    LocalDateTime.now(), // Fecha de creación
                    null, // Fecha de modificación
                    null, // Fecha de eliminación
                    LocalDateTime.now(), // Fecha de alta
                    null, // Fecha de baja
                    "-", // Razón de inactividad
                    EstadoPersonal.ACTIVO
                );
                em.persist(historialJefeDepartamento);

                // Usuario 2
                Usuario jefePersonal = new Usuario(
                    2, "María", "Gómez", "87654321", "5544332211",
                    "admin.personal", ContraseniaEncriptacionUtils.hashContrasenia("admin123"),
                    RolUsuario.JEFEDEPERSONAL
                );
                jefePersonal.setEstado(EstadoPersonal.ACTIVO);
                em.persist(jefePersonal);

                HistorialUsuario historialJefePersonal = new HistorialUsuario(
                    jefePersonal,
                    LocalDateTime.now(),
                    null,
                    null,
                    LocalDateTime.now(),
                    null,
                    "-",
                    EstadoPersonal.ACTIVO
                );
                em.persist(historialJefePersonal);

                em.getTransaction().commit();
                
                System.out.println("Base de datos inicializada con usuarios y sus historiales.");
            } else {
                System.out.println("La base de datos ya tiene usuarios.");
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al inicializar la base de datos: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
}
