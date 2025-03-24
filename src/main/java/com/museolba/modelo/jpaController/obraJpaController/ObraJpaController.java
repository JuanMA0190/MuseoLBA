package com.museolba.modelo.jpaController.obraJpaController;

import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.entidades.sala.Sala;
import com.museolba.modelo.entidades.artista.Artista;
import com.museolba.modelo.jpaController.BaseJpaController;
import java.util.Optional;
import javax.persistence.EntityManager;


public class ObraJpaController extends BaseJpaController<Obra, Long> {
    
    public ObraJpaController() {
        super(Obra.class);
    }
    
    public void crearObra(Obra obra) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();

            // Obtener la sala y el artista desde la base de datos (o crearlos)
            Sala sala = em.find(Sala.class, obra.getSala().getId()); // ID de la sala
            Artista artista = em.find(Artista.class, obra.getArtista().getId()); // ID del artista

            // Establecer las relaciones
            obra.setSala(sala); // Esto actualiza automáticamente la lista de obras en la sala
            obra.setArtista(artista); // Esto actualiza automáticamente la lista de obras en el artista

            // Persistir la obra
            em.persist(obra);

            em.getTransaction().commit();
       
        }catch (Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Error al crear la obra: " + e.getMessage(), e);
        }finally{
            em.close();
        }
        
    }
    
    public Optional<Obra> obtenerObraPorId(Long id) {
        EntityManager em = null;
        Optional<Obra> obra = Optional.empty();

        try {
            em = getEntityManager();
            // Busca la obra por su ID
            obra = Optional.ofNullable(em.find(Obra.class, id));
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones (puedes personalizarlo)
        } finally {
            em.close(); // Cierra el EntityManager
        }

        return obra;
    }
    
      /**
     * Edita una obra en la base de datos, actualizando sus relaciones con Artista y Sala.
     *
     * @param obra La obra con los datos actualizados.
     * @throws Exception Si ocurre un error durante la actualización.
     */
    public void editarObra(Obra obra) throws Exception {
         EntityManager em = null;

        try {
            em = getEmf().createEntityManager();
            em.getTransaction().begin();

            // Obtener la obra existente desde la base de datos
            Obra obraExistente = em.find(Obra.class, obra.getNumInv());

            if (obraExistente == null) {
                throw new Exception("No se encontró la obra con ID: " + obra.getNumInv());
            }

            // Actualizar los campos de la obra
            obraExistente.setTitulo(obra.getTitulo());
            obraExistente.setTipoObra(obra.getTipoObra());
            obraExistente.setAltura(obra.getAltura());
            obraExistente.setAncho(obra.getAncho());
            obraExistente.setDescripcion(obra.getDescripcion());
            obraExistente.setImagenUrl(obra.getImagenUrl());
            obraExistente.setEstadoObra(obra.getEstadoObra());
            obraExistente.setEstadoExpo(obra.getEstadoExpo());

            // Manejar la relación con Artista
            if (!obraExistente.getArtista().equals(obra.getArtista())) {
                // Remover la obra del artista anterior
                Artista artistaAnterior = obraExistente.getArtista();
                artistaAnterior.getObras().remove(obraExistente);

                // Asignar el nuevo artista
                Artista nuevoArtista = em.merge(obra.getArtista());
                obraExistente.setArtista(nuevoArtista);

                // Agregar la obra al nuevo artista
                nuevoArtista.getObras().add(obraExistente);
            }

            // Manejar la relación con Sala
            if (!obraExistente.getSala().equals(obra.getSala())) {
                // Remover la obra de la sala anterior
                Sala salaAnterior = obraExistente.getSala();
                salaAnterior.getObras().remove(obraExistente);

                // Asignar la nueva sala
                Sala nuevaSala = em.merge(obra.getSala());
                obraExistente.setSala(nuevaSala);

                // Agregar la obra a la nueva sala
                nuevaSala.getObras().add(obraExistente);
            }

            // Guardar los cambios en la base de datos
            em.merge(obraExistente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Error al editar la obra: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}


