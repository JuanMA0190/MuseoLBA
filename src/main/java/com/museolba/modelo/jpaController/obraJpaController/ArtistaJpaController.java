package com.museolba.modelo.jpaController.obraJpaController;

import com.museolba.modelo.entidades.obra.Artista;
import com.museolba.modelo.jpaController.BaseJpaController;
import java.util.Optional;
import javax.persistence.EntityManager;


public class ArtistaJpaController extends BaseJpaController<Artista, Long> {
   
    public ArtistaJpaController() {
        super(Artista.class);
    }
    
     /**
     * Método para crear un nuevo artista en la base de datos.
     *
     * @param artista El objeto Artista a persistir.
     * @throws Exception Si ocurre un error durante la persistencia.
     */
    public void crearArtista(Artista artista) throws Exception {
        EntityManager em = null;

        try {
            em = getEntityManager();
            // Inicia una transacción
            em.getTransaction().begin();

            // Persiste el artista en la base de datos
            em.persist(artista);

            // Finaliza la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            // Si ocurre un error, realiza un rollback
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Error al crear el artista: " + e.getMessage(), e);
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }
    
    /**
     * Método para obtener un artista por su ID.
     *
     * @param id El ID del artista a buscar.
     * @return Un Optional que contiene el artista si se encuentra, o vacío si no.
     */
    public Optional<Artista> obtenerArtistaPorId(Long id) {
        EntityManager em = null;
        Optional<Artista> artista = Optional.empty();

        try {
            em = getEntityManager();
            // Busca el artista por su ID
            artista = Optional.ofNullable(em.find(Artista.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return artista;
    }
    
    /**
     * Método para editar un artista existente en la base de datos.
     *
     * @param id          El ID del artista a editar.
     * @param nuevoNombre El nuevo nombre del artista.
     * @param nuevoCorreo El nuevo correo del artista.
     * @param nuevoTelefono El nuevo número de teléfono del artista.
     * @throws Exception Si ocurre un error durante la actualización.
     */
    public void editarArtista(Long id, String nuevoNombre, String nuevoCorreo, String nuevoTelefono) throws Exception {
        EntityManager em = null;

        try {
            em = getEntityManager();
            // Inicia una transacción
            em.getTransaction().begin();

            // Busca el artista por su ID
            Artista artista = em.find(Artista.class, id);

            if (artista != null) {
                // Actualiza los campos del artista
                artista.setNombre(nuevoNombre);
                artista.setCorreo(nuevoCorreo);
                artista.setnTelefono(nuevoTelefono);

                // Guarda los cambios en la base de datos
                em.merge(artista);
            } else {
                throw new Exception("No se encontró ningún artista con el ID: " + id);
            }

            // Finaliza la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            // Si ocurre un error, realiza un rollback
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Error al editar el artista: " + e.getMessage(), e);
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    
}
