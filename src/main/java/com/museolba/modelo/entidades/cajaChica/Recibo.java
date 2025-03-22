package com.museolba.modelo.entidades.cajaChica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recibos")
public class Recibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
   
    @Column(name = "responsable", nullable = false)
    private Long responsable;
    
    @Column(name = "precio_total", nullable = false)
    private Double precioTotal;
    
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
    
    @Column(name = "imagen_url")
    private String imagenUrl;
    
    @ElementCollection
    @CollectionTable(name = "recibo_productos", joinColumns = @JoinColumn(name = "recibo_id"))
    private List<Producto> productos;
    
    @ManyToOne
    @JoinColumn(name = "caja_chica_id")
    private CajaChica cajaChica;

    public Recibo(){ 
        this.productos = new ArrayList<>();
    }

    public Recibo(String nombre,Double precioTotal, LocalDateTime fechaRegistro) {
        this.nombre = nombre;
        this.precioTotal = precioTotal;
        this.fechaRegistro = fechaRegistro;
        this.productos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public CajaChica getCajaChica() {
        return cajaChica;
    }

    public void setCajaChica(CajaChica cajaChica) {
        this.cajaChica = cajaChica;
    }    

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Long getResponsable() {
        return responsable;
    }

    public void setResponsable(Long responsable) {
        this.responsable = responsable;
    }
    
    
    
}
