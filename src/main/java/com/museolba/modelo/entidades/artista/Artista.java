package com.museolba.modelo.entidades.artista;

import com.museolba.modelo.entidades.obra.Obra;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "artista")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "num_telefono")
    private String nTelefono;
    
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Obra> obras = new ArrayList<>();


    public Artista() {
    }

    public Artista(String nombre, String correo, String nTelefono, List<Obra> obras) {
        this.nombre = nombre;
        this.correo = correo;
        this.nTelefono = nTelefono;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
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
            obra.setArtista(this); // Establece la sala en la obra
        }
    }

    public void eliminarObra(Obra obra) {
        if (obra != null) {
            this.obras.remove(obra); // Elimina la obra de la lista de obras del artista
            obra.setArtista(null); // Elimina la referencia al artista en la obra
        }
    }
    
    @Override
    public String toString() {
        return id + " - " + nombre;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Artista artista = (Artista) obj;
        return Objects.equals(id, artista.id); // Compara por ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Usa el ID para el hashCode
    }
    
}
