/*
 * This file is generated by jOOQ.
 */
package jooq;


import jooq.tables.Alumnos;
import jooq.tables.Calificaciones;
import jooq.tables.FlywaySchemaHistory;
import jooq.tables.Materias;
import jooq.tables.records.AlumnosRecord;
import jooq.tables.records.CalificacionesRecord;
import jooq.tables.records.FlywaySchemaHistoryRecord;
import jooq.tables.records.MateriasRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AlumnosRecord> ALUMNOS_PKEY = Internal.createUniqueKey(Alumnos.ALUMNOS, DSL.name("alumnos_pkey"), new TableField[] { Alumnos.ALUMNOS.ID_ALUMNO }, true);
    public static final UniqueKey<CalificacionesRecord> CALIFICACIONES_PKEY = Internal.createUniqueKey(Calificaciones.CALIFICACIONES, DSL.name("calificaciones_pkey"), new TableField[] { Calificaciones.CALIFICACIONES.ID_CALIFICACION }, true);
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, DSL.name("flyway_schema_history_pk"), new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
    public static final UniqueKey<MateriasRecord> MATERIAS_PKEY = Internal.createUniqueKey(Materias.MATERIAS, DSL.name("materias_pkey"), new TableField[] { Materias.MATERIAS.ID_MATERIA }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CalificacionesRecord, AlumnosRecord> CALIFICACIONES__CALIFICACIONES_ID_ALUMNO_FKEY = Internal.createForeignKey(Calificaciones.CALIFICACIONES, DSL.name("calificaciones_id_alumno_fkey"), new TableField[] { Calificaciones.CALIFICACIONES.ID_ALUMNO }, Keys.ALUMNOS_PKEY, new TableField[] { Alumnos.ALUMNOS.ID_ALUMNO }, true);
    public static final ForeignKey<CalificacionesRecord, MateriasRecord> CALIFICACIONES__CALIFICACIONES_ID_MATERIA_FKEY = Internal.createForeignKey(Calificaciones.CALIFICACIONES, DSL.name("calificaciones_id_materia_fkey"), new TableField[] { Calificaciones.CALIFICACIONES.ID_MATERIA }, Keys.MATERIAS_PKEY, new TableField[] { Materias.MATERIAS.ID_MATERIA }, true);
}
