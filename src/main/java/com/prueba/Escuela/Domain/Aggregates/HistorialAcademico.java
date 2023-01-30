package com.prueba.Escuela.Domain.Aggregates;

import com.prueba.Escuela.Domain.ValueObject.Boleta;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class HistorialAcademico {
    private final int id;
    private final String nombreCompleto;
    private final List<Boleta> calificaciones;
    private final BigDecimal promedio;

    public HistorialAcademico(int id, String nombreCompleto, List<Boleta> calificaciones, BigDecimal promedio) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.calificaciones = calificaciones;
        this.promedio = promedio;
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public List<Boleta> getCalificaciones() {
        return calificaciones;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    @Override
    public String toString() {
        return "HistorialAcademico{" +
                "id=" + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", calificaciones=" + calificaciones +
                ", promedio=" + promedio +
                '}';
    }
}
