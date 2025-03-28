package com.museolba.modelo.entidades.obra;

import com.museolba.modelo.entidades.sala.Sala;
import com.museolba.modelo.entidades.artista.Artista;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "obra")
public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_inv", nullable = false, unique = true)
    private Long numInv;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_obra")
    private TipoObra tipoObra;

    @Column(name = "titulo")
    private String titulo;
    
    @ManyToOne
    @JoinColumn(name = "artista_id") // Columna que referencia al artista
    private Artista artista;

    @Column(name = "altura")
    private Double altura;
    
    @Column(name = "ancho")
    private Double ancho;

    @Column(name = "fecha_entrada")
    private LocalDateTime fechaEntrada;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;
    
    @Column(name = "imagen_url")
    private String imagenUrl;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_obra")
    private EstadoObra estadoObra;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_exposicion")
    private EstadoExposicion estadoExpo;

    public Obra() {
    }
    
    public Obra(Long numInv, String titulo, Artista artista, TipoObra tipoObra, String descripcion, Double ancho, Double altura, EstadoObra estadoObra, String imagenUrl, EstadoExposicion estadoExpo, Sala sala) {
        this.numInv = numInv;
        this.tipoObra = tipoObra;
        this.titulo = titulo;
        this.artista = artista;
        this.altura = altura;
        this.ancho = ancho;
        this.descripcion = descripcion;
        this.sala = sala;
        this.imagenUrl = imagenUrl;
        this.estadoObra = estadoObra;
        this.estadoExpo = estadoExpo;
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

    public Artista getArtista() {
        return artista;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
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

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public EstadoObra getEstadoObra() {
        return estadoObra;
    }

    public void setEstadoObra(EstadoObra estadoObra) {
        this.estadoObra = estadoObra;
    }

    public EstadoExposicion getEstadoExpo() {
        return estadoExpo;
    }

    public void setEstadoExpo(EstadoExposicion estadoExpo) {
        this.estadoExpo = estadoExpo;
    }
    
    public void setSala(Sala sala) {
        if (this.sala != null) {
            // Elimina la obra de la lista de obras de la sala actual
            this.sala.getObras().remove(this);
        }
        this.sala = sala;
        if (sala != null) {
            // Agrega la obra a la lista de obras de la nueva sala
            sala.getObras().add(this);
        }
    }

    public void setArtista(Artista artista) {
        if (this.artista != null) {
            // Elimina la obra de la lista de obras del artista actual
            this.artista.getObras().remove(this);
        }
        this.artista = artista;
        if (artista != null) {
            // Agrega la obra a la lista de obras del nuevo artista
            artista.getObras().add(this);
        }
    }

   
}
