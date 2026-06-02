package com.parcial.parcialwebbackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "torneo")
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String deporte;

    @Column(name = "fecha_inicio", nullable = false)
    private String fechaInicio;

    @Column(nullable = false)
    private String ciudad;

    @OneToMany(mappedBy = "torneo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Equipo> equipos = new ArrayList<>();

    public Torneo() {
    }

    public Torneo(Long id, String nombre, String deporte, String fechaInicio, String ciudad, List<Equipo> equipos) {
        this.id = id;
        this.nombre = nombre;
        this.deporte = deporte;
        this.fechaInicio = fechaInicio;
        this.ciudad = ciudad;
        this.equipos = equipos;
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

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

}
