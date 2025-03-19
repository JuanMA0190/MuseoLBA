package com.museolba.modelo.entidades;

import javax.persistence.Embeddable;


@Embeddable
public class Producto {
    private String nombre;
    private Double precioUnitario;
    private Integer cantidad;

    public Producto() {
    }

    public Producto(String nombre, Double precioUnitario, Integer cantidad) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
   
}
