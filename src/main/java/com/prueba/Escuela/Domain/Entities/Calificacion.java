package com.prueba.Escuela.Domain.Entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Calificacion {
    private int id;
    private int idMateria;
    private int idAlumno;
    private BigDecimal calificacion;
    private LocalDateTime fecha_registro;
    private boolean activo;

    public Calificacion() {
    }

    public Calificacion(int idMateria, int idAlumno, BigDecimal calificacion) {
        this.idMateria = idMateria;
        this.idAlumno = idAlumno;
        this.calificacion = calificacion;
    }

    public Calificacion(int id, int idMateria, int idAlumno, BigDecimal calificacion, LocalDateTime fecha_registro, boolean activo) {
        this.id = id;
        this.idMateria = idMateria;
        this.idAlumno = idAlumno;
        this.calificacion = calificacion;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Calificacion{" +
                "id=" + id +
                ", idMateria=" + idMateria +
                ", idAlumno=" + idAlumno +
                ", calificacion=" + calificacion +
                ", fecha_registro=" + fecha_registro +
                ", activo=" + activo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calificacion)) return false;
        Calificacion that = (Calificacion) o;
        return getId() == that.getId() && getIdMateria() == that.getIdMateria() && getIdAlumno() == that.getIdAlumno() && isActivo() == that.isActivo() && Objects.equals(getCalificacion(), that.getCalificacion()) && Objects.equals(getFecha_registro(), that.getFecha_registro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIdMateria(), getIdAlumno(), getCalificacion(), getFecha_registro(), isActivo());
    }
}
