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
import jakarta.validation.constraints.Size;

import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(
    name = "alumnos",
    schema = "public"
)
public class Alumnos implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idAlumno;
    private String  nombre;
    private String  apPaterno;
    private String  apMaterno;
    private Boolean activo;

    public Alumnos() {}

    public Alumnos(Alumnos value) {
        this.idAlumno = value.idAlumno;
        this.nombre = value.nombre;
        this.apPaterno = value.apPaterno;
        this.apMaterno = value.apMaterno;
        this.activo = value.activo;
    }

    public Alumnos(
        Integer idAlumno,
        String  nombre,
        String  apPaterno,
        String  apMaterno,
        Boolean activo
    ) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.activo = activo;
    }

    /**
     * Getter for <code>public.alumnos.id_alumno</code>.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno", nullable = false, precision = 32)
    public Integer getIdAlumno() {
        return this.idAlumno;
    }

    /**
     * Setter for <code>public.alumnos.id_alumno</code>.
     */
    public Alumnos setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
        return this;
    }

    /**
     * Getter for <code>public.alumnos.nombre</code>.
     */
    @Column(name = "nombre", length = 80)
    @Size(max = 80)
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Setter for <code>public.alumnos.nombre</code>.
     */
    public Alumnos setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     * Getter for <code>public.alumnos.ap_paterno</code>.
     */
    @Column(name = "ap_paterno", length = 80)
    @Size(max = 80)
    public String getApPaterno() {
        return this.apPaterno;
    }

    /**
     * Setter for <code>public.alumnos.ap_paterno</code>.
     */
    public Alumnos setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
        return this;
    }

    /**
     * Getter for <code>public.alumnos.ap_materno</code>.
     */
    @Column(name = "ap_materno", length = 80)
    @Size(max = 80)
    public String getApMaterno() {
        return this.apMaterno;
    }

    /**
     * Setter for <code>public.alumnos.ap_materno</code>.
     */
    public Alumnos setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
        return this;
    }

    /**
     * Getter for <code>public.alumnos.activo</code>.
     */
    @Column(name = "activo", nullable = false)
    public Boolean getActivo() {
        return this.activo;
    }

    /**
     * Setter for <code>public.alumnos.activo</code>.
     */
    public Alumnos setActivo(Boolean activo) {
        this.activo = activo;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Alumnos (");

        sb.append(idAlumno);
        sb.append(", ").append(nombre);
        sb.append(", ").append(apPaterno);
        sb.append(", ").append(apMaterno);
        sb.append(", ").append(activo);

        sb.append(")");
        return sb.toString();
    }
}
