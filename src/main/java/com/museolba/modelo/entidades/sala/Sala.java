package com.museolba.modelo.entidades.sala;

import com.museolba.modelo.entidades.obra.Obra;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Obra> obras;
    
    public Sala() {
    }

    public Sala(Long id, String nombre, List<Obra> obras) {
        this.id = id;
        this.nombre = nombre;
        this.obras = obras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Obra> getObras() {
        return obras;
    }

    public void setObras(List<Obra> obras) {
        this.obras = obras;
    }
    
    public void agregarObra(Obra obra) {
        if (obra != null) {
            this.obras.add(obra); // Agrega la obra a la lista de obras de la sala
            obra.setSala(this); // Establece la sala en la obra
        }
    }

    public void eliminarObra(Obra obra) {
        if (obra != null) {
            this.obras.remove(obra); // Elimina la obra de la lista de obras de la sala
            obra.setSala(null); // Elimina la referencia a la sala en la obra
        }
    }
    
    @Override
    public String toString() {
        return this.nombre;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sala sala = (Sala) obj;
        return Objects.equals(id, sala.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}
