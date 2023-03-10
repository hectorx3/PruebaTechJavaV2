/*
 * This file is generated by jOOQ.
 */
package jooq.tables.pojos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(
    name = "calificaciones",
    schema = "public"
)
public class Calificaciones implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer       idCalificacion;
    private Integer       idMateria;
    private Integer       idAlumno;
    private Boolean       activo;
    private LocalDateTime fechaRegistro;
    private BigDecimal    calificacion;

    public Calificaciones() {}

    public Calificaciones(Calificaciones value) {
        this.idCalificacion = value.idCalificacion;
        this.idMateria = value.idMateria;
        this.idAlumno = value.idAlumno;
        this.activo = value.activo;
        this.fechaRegistro = value.fechaRegistro;
        this.calificacion = value.calificacion;
    }

    public Calificaciones(
        Integer       idCalificacion,
        Integer       idMateria,
        Integer       idAlumno,
        Boolean       activo,
        LocalDateTime fechaRegistro,
        BigDecimal    calificacion
    ) {
        this.idCalificacion = idCalificacion;
        this.idMateria = idMateria;
        this.idAlumno = idAlumno;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
        this.calificacion = calificacion;
    }

    /**
     * Getter for <code>public.calificaciones.id_calificacion</code>.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion", nullable = false, precision = 32)
    public Integer getIdCalificacion() {
        return this.idCalificacion;
    }

    /**
     * Setter for <code>public.calificaciones.id_calificacion</code>.
     */
    public Calificaciones setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
        return this;
    }

    /**
     * Getter for <code>public.calificaciones.id_materia</code>.
     */
    @Column(name = "id_materia", nullable = false, precision = 32)
    @NotNull
    public Integer getIdMateria() {
        return this.idMateria;
    }

    /**
     * Setter for <code>public.calificaciones.id_materia</code>.
     */
    public Calificaciones setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
        return this;
    }

    /**
     * Getter for <code>public.calificaciones.id_alumno</code>.
     */
    @Column(name = "id_alumno", nullable = false, precision = 32)
    @NotNull
    public Integer getIdAlumno() {
        return this.idAlumno;
    }

    /**
     * Setter for <code>public.calificaciones.id_alumno</code>.
     */
    public Calificaciones setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
        return this;
    }

    /**
     * Getter for <code>public.calificaciones.activo</code>.
     */
    @Column(name = "activo", nullable = false)
    public Boolean getActivo() {
        return this.activo;
    }

    /**
     * Setter for <code>public.calificaciones.activo</code>.
     */
    public Calificaciones setActivo(Boolean activo) {
        this.activo = activo;
        return this;
    }

    /**
     * Getter for <code>public.calificaciones.fecha_registro</code>.
     */
    @Column(name = "fecha_registro", precision = 6)
    public LocalDateTime getFechaRegistro() {
        return this.fechaRegistro;
    }

    /**
     * Setter for <code>public.calificaciones.fecha_registro</code>.
     */
    public Calificaciones setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
        return this;
    }

    /**
     * Getter for <code>public.calificaciones.calificacion</code>.
     */
    @Column(name = "calificacion", precision = 10, scale = 2)
    public BigDecimal getCalificacion() {
        return this.calificacion;
    }

    /**
     * Setter for <code>public.calificaciones.calificacion</code>.
     */
    public Calificaciones setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Calificaciones (");

        sb.append(idCalificacion);
        sb.append(", ").append(idMateria);
        sb.append(", ").append(idAlumno);
        sb.append(", ").append(activo);
        sb.append(", ").append(fechaRegistro);
        sb.append(", ").append(calificacion);

        sb.append(")");
        return sb.toString();
    }
}
