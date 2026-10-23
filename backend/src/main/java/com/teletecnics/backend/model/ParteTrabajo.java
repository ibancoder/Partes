package com.teletecnics.backend.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity 
@Table(name = "partes_trabajo")
public class ParteTrabajo {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 150)
    private String cliente;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false, length = 30)
    private String estado = "PENDIENTE";

    public ParteTrabajo(){}

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

     public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }
}
