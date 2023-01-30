/*
 * This file is generated by jOOQ.
 */
package jooq.tables;


import jooq.Keys;
import jooq.Public;
import jooq.tables.records.MateriasRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
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
public class Materias extends TableImpl<MateriasRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.materias</code>
     */
    public static final Materias MATERIAS = new Materias();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MateriasRecord> getRecordType() {
        return MateriasRecord.class;
    }

    /**
     * The column <code>public.materias.id_materia</code>.
     */
    public final TableField<MateriasRecord, Integer> ID_MATERIA = createField(DSL.name("id_materia"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.materias.nombre</code>.
     */
    public final TableField<MateriasRecord, String> NOMBRE = createField(DSL.name("nombre"), SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>public.materias.activo</code>.
     */
    public final TableField<MateriasRecord, Boolean> ACTIVO = createField(DSL.name("activo"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field("true", SQLDataType.BOOLEAN)), this, "");

    private Materias(Name alias, Table<MateriasRecord> aliased) {
        this(alias, aliased, null);
    }

    private Materias(Name alias, Table<MateriasRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.materias</code> table reference
     */
    public Materias(String alias) {
        this(DSL.name(alias), MATERIAS);
    }

    /**
     * Create an aliased <code>public.materias</code> table reference
     */
    public Materias(Name alias) {
        this(alias, MATERIAS);
    }

    /**
     * Create a <code>public.materias</code> table reference
     */
    public Materias() {
        this(DSL.name("materias"), null);
    }

    public <O extends Record> Materias(Table<O> child, ForeignKey<O, MateriasRecord> key) {
        super(child, key, MATERIAS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<MateriasRecord, Integer> getIdentity() {
        return (Identity<MateriasRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<MateriasRecord> getPrimaryKey() {
        return Keys.MATERIAS_PKEY;
    }

    @Override
    public Materias as(String alias) {
        return new Materias(DSL.name(alias), this);
    }

    @Override
    public Materias as(Name alias) {
        return new Materias(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Materias rename(String name) {
        return new Materias(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Materias rename(Name name) {
        return new Materias(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Boolean> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}