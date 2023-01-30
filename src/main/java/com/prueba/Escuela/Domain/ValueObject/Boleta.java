package com.prueba.Escuela.Domain.ValueObject;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Boleta {

    private final int idCalificacion;
    private final String nombre;
    private final String apellidos;
    private final String materia;
    private final BigDecimal calificacion;
    private final LocalDateTime fechaRegistro;

    public Boleta(int idCalificacion, String nombre, String apellidos, String materia, BigDecimal calificacion, LocalDateTime fechaRegistro) {
        this.idCalificacion = idCalificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.materia = materia;
        this.calificacion = calificacion;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getMateria() {
        return materia;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString() {
        return "Boleta{" +
                "idCalificacion=" + idCalificacion +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", materia='" + materia + '\'' +
                ", calificacion=" + calificacion +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
