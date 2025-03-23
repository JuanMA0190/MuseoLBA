package com.museolba.config;

import com.museolba.modelo.entidades.obra.Sala;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class DataSalaInitializr {
    
    private final EntityManagerFactory emf;

    public DataSalaInitializr(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void initializeSalas() {
        EntityManager em = emf.createEntityManager();
        try {
            // Verificar si ya existen salas en la base de datos
            Query query = em.createQuery("SELECT COUNT(s) FROM Sala s");
            Long count = (Long) query.getSingleResult();

            if (count == 0) {
                System.out.println("Inicializando la base de datos con las salas...");

                em.getTransaction().begin();

                // Crear las 4 salas
                Sala pinacoteca = new Sala();
                pinacoteca.setNombre("Pinacoteca");
                em.persist(pinacoteca);

                Sala principal = new Sala();
                principal.setNombre("Principal");
                em.persist(principal);

                Sala mena = new Sala();
                mena.setNombre("Mena");
                em.persist(mena);

                Sala galeria = new Sala();
                galeria.setNombre("Galería");
                em.persist(galeria);
                
                Sala entregado = new Sala();
                entregado.setNombre("Entregado al Artista");
                em.persist(entregado);

                em.getTransaction().commit();

                System.out.println("Base de datos inicializada con las salas.");
            } else {
                System.out.println("La base de datos ya tiene salas.");
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al inicializar las salas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
