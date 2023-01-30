/*
 * This file is generated by jOOQ.
 */
package jooq.tables.records;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import jooq.tables.Alumnos;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(
    name = "alumnos",
    schema = "public"
)
public class AlumnosRecord extends UpdatableRecordImpl<AlumnosRecord> implements Record5<Integer, String, String, String, Boolean> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.alumnos.id_alumno</code>.
     */
    public AlumnosRecord setIdAlumno(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.alumnos.id_alumno</code>.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno", nullable = false, precision = 32)
    public Integer getIdAlumno() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.alumnos.nombre</code>.
     */
    public AlumnosRecord setNombre(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.alumnos.nombre</code>.
     */
    @Column(name = "nombre", length = 80)
    @Size(max = 80)
    public String getNombre() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.alumnos.ap_paterno</code>.
     */
    public AlumnosRecord setApPaterno(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.alumnos.ap_paterno</code>.
     */
    @Column(name = "ap_paterno", length = 80)
    @Size(max = 80)
    public String getApPaterno() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.alumnos.ap_materno</code>.
     */
    public AlumnosRecord setApMaterno(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.alumnos.ap_materno</code>.
     */
    @Column(name = "ap_materno", length = 80)
    @Size(max = 80)
    public String getApMaterno() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.alumnos.activo</code>.
     */
    public AlumnosRecord setActivo(Boolean value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.alumnos.activo</code>.
     */
    @Column(name = "activo", nullable = false)
    public Boolean getActivo() {
        return (Boolean) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, String, Boolean> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, String, String, Boolean> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Alumnos.ALUMNOS.ID_ALUMNO;
    }

    @Override
    public Field<String> field2() {
        return Alumnos.ALUMNOS.NOMBRE;
    }

    @Override
    public Field<String> field3() {
        return Alumnos.ALUMNOS.AP_PATERNO;
    }

    @Override
    public Field<String> field4() {
        return Alumnos.ALUMNOS.AP_MATERNO;
    }

    @Override
    public Field<Boolean> field5() {
        return Alumnos.ALUMNOS.ACTIVO;
    }

    @Override
    public Integer component1() {
        return getIdAlumno();
    }

    @Override
    public String component2() {
        return getNombre();
    }

    @Override
    public String component3() {
        return getApPaterno();
    }

    @Override
    public String component4() {
        return getApMaterno();
    }

    @Override
    public Boolean component5() {
        return getActivo();
    }

    @Override
    public Integer value1() {
        return getIdAlumno();
    }

    @Override
    public String value2() {
        return getNombre();
    }

    @Override
    public String value3() {
        return getApPaterno();
    }

    @Override
    public String value4() {
        return getApMaterno();
    }

    @Override
    public Boolean value5() {
        return getActivo();
    }

    @Override
    public AlumnosRecord value1(Integer value) {
        setIdAlumno(value);
        return this;
    }

    @Override
    public AlumnosRecord value2(String value) {
        setNombre(value);
        return this;
    }

    @Override
    public AlumnosRecord value3(String value) {
        setApPaterno(value);
        return this;
    }

    @Override
    public AlumnosRecord value4(String value) {
        setApMaterno(value);
        return this;
    }

    @Override
    public AlumnosRecord value5(Boolean value) {
        setActivo(value);
        return this;
    }

    @Override
    public AlumnosRecord values(Integer value1, String value2, String value3, String value4, Boolean value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AlumnosRecord
     */
    public AlumnosRecord() {
        super(Alumnos.ALUMNOS);
    }

    /**
     * Create a detached, initialised AlumnosRecord
     */
    public AlumnosRecord(Integer idAlumno, String nombre, String apPaterno, String apMaterno, Boolean activo) {
        super(Alumnos.ALUMNOS);

        setIdAlumno(idAlumno);
        setNombre(nombre);
        setApPaterno(apPaterno);
        setApMaterno(apMaterno);
        setActivo(activo);
    }

    /**
     * Create a detached, initialised AlumnosRecord
     */
    public AlumnosRecord(jooq.tables.pojos.Alumnos value) {
        super(Alumnos.ALUMNOS);

        if (value != null) {
            setIdAlumno(value.getIdAlumno());
            setNombre(value.getNombre());
            setApPaterno(value.getApPaterno());
            setApMaterno(value.getApMaterno());
            setActivo(value.getActivo());
        }
    }
}
