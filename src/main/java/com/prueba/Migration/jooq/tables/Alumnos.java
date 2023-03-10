/*
 * This file is generated by jOOQ.
 */
package jooq.tables;


import jooq.Keys;
import jooq.Public;
import jooq.tables.records.AlumnosRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Alumnos extends TableImpl<AlumnosRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.alumnos</code>
     */
    public static final Alumnos ALUMNOS = new Alumnos();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AlumnosRecord> getRecordType() {
        return AlumnosRecord.class;
    }

    /**
     * The column <code>public.alumnos.id_alumno</code>.
     */
    public final TableField<AlumnosRecord, Integer> ID_ALUMNO = createField(DSL.name("id_alumno"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.alumnos.nombre</code>.
     */
    public final TableField<AlumnosRecord, String> NOMBRE = createField(DSL.name("nombre"), SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>public.alumnos.ap_paterno</code>.
     */
    public final TableField<AlumnosRecord, String> AP_PATERNO = createField(DSL.name("ap_paterno"), SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>public.alumnos.ap_materno</code>.
     */
    public final TableField<AlumnosRecord, String> AP_MATERNO = createField(DSL.name("ap_materno"), SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>public.alumnos.activo</code>.
     */
    public final TableField<AlumnosRecord, Boolean> ACTIVO = createField(DSL.name("activo"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field("true", SQLDataType.BOOLEAN)), this, "");

    private Alumnos(Name alias, Table<AlumnosRecord> aliased) {
        this(alias, aliased, null);
    }

    private Alumnos(Name alias, Table<AlumnosRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.alumnos</code> table reference
     */
    public Alumnos(String alias) {
        this(DSL.name(alias), ALUMNOS);
    }

    /**
     * Create an aliased <code>public.alumnos</code> table reference
     */
    public Alumnos(Name alias) {
        this(alias, ALUMNOS);
    }

    /**
     * Create a <code>public.alumnos</code> table reference
     */
    public Alumnos() {
        this(DSL.name("alumnos"), null);
    }

    public <O extends Record> Alumnos(Table<O> child, ForeignKey<O, AlumnosRecord> key) {
        super(child, key, ALUMNOS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<AlumnosRecord, Integer> getIdentity() {
        return (Identity<AlumnosRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<AlumnosRecord> getPrimaryKey() {
        return Keys.ALUMNOS_PKEY;
    }

    @Override
    public Alumnos as(String alias) {
        return new Alumnos(DSL.name(alias), this);
    }

    @Override
    public Alumnos as(Name alias) {
        return new Alumnos(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Alumnos rename(String name) {
        return new Alumnos(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Alumnos rename(Name name) {
        return new Alumnos(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, String, Boolean> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
