package com.museolba.modelo.entidades.obra;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Obra {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numInv;

    @Enumerated(EnumType.STRING)
    private TipoObra tipoObra;

    private String titulo;

    
    private String artista;

    private String medida;

    private LocalDateTime fechaEntrada;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    private String imagenUrl;


    public Obra() {
    }

    public Obra(Long numInv, TipoObra tipoObra, String titulo, String artista, String medida, LocalDateTime fechaEntrada, String descripcion, Sala sala, String imagenUrl) {
        this.numInv = numInv;
        this.tipoObra = tipoObra;
        this.titulo = titulo;
        this.artista = artista;
        this.medida = medida;
        this.fechaEntrada = fechaEntrada;
        this.descripcion = descripcion;
        this.sala = sala;
        this.imagenUrl = imagenUrl;
    }

    public Long getNumInv() {
        return numInv;
    }

    public void setNumInv(Long numInv) {
        this.numInv = numInv;
    }

    public TipoObra getTipoObra() {
        return tipoObra;
    }

    public void setTipoObra(TipoObra tipoObra) {
        this.tipoObra = tipoObra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
    
    
}
