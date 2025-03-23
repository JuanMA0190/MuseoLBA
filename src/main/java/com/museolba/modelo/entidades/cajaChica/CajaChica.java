package com.museolba.modelo.entidades.cajaChica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "caja_chica")
public class CajaChica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caja_chica_id")
    private Long id;
    
    @Column(name = "fondo_inicial")
    private Double fondoInicial;
    
    @Column(name = "total_gasto")
    private Double totalGasto;//todo lo que se gasto de los recibos
    
    @Column(name = "mes_caja_chica")
    private LocalDate mes;//mes por numero
   
    
    @OneToMany(mappedBy = "cajaChica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recibo> recibos;

    public CajaChica() {
        this.recibos = new ArrayList<>();
    }

    public CajaChica(Double fondoInicial, Double totalGasto, LocalDate mes) {
        this.fondoInicial = fondoInicial;
        this.totalGasto = totalGasto;
        this.mes = mes;
        this.recibos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Double getFondoInicial() {
        return fondoInicial;
    }

    public void setFondoInicial(Double fondoInicial) {
        this.fondoInicial = fondoInicial;
    }

    public Double getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(Double totalGasto) {
        this.totalGasto = totalGasto;
    }

    public LocalDate getMes() {
        return mes;
    }

    public void setMes(LocalDate mes) {
        this.mes = mes;
    }

    public List<Recibo> getRecibos() {
        return recibos;
    }

    public void setRecibos(List<Recibo> recibos) {
        this.recibos = recibos;
    }
    
    public void agregarRecibo(Recibo recibo) {
        recibos.add(recibo);
        recibo.setCajaChica(this); // Establece la relación inversa
    }

    public void eliminarRecibo(Recibo recibo) {
        recibos.remove(recibo);
        recibo.setCajaChica(null); // Elimina la relación inversa
    }
}
