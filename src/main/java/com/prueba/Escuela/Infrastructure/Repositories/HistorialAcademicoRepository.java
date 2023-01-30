package com.prueba.Escuela.Infrastructure.Repositories;

import com.prueba.Escuela.Domain.Aggregates.HistorialAcademico;
import com.prueba.Escuela.Domain.Repositories.IHistorialAcademico;
import com.prueba.Escuela.Domain.ValueObject.Boleta;
import jakarta.inject.Inject;
import jooq.Tables;
import org.jooq.DSLContext;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class HistorialAcademicoRepository implements IHistorialAcademico {

    @Inject
    DSLContext dslContext;

    @Override
    public List<Boleta> getBoletaByIdAlumno(int id) {
        var query = dslContext
                .select(
                        Tables.ALUMNOS.ID_ALUMNO,
                        Tables.ALUMNOS.NOMBRE,
                        Tables.ALUMNOS.AP_PATERNO,
                        Tables.ALUMNOS.AP_MATERNO,
                        Tables.ALUMNOS.ACTIVO,
                        Tables.CALIFICACIONES.ID_CALIFICACION,
                        Tables.CALIFICACIONES.CALIFICACION,
                        Tables.CALIFICACIONES.FECHA_REGISTRO,
                        Tables.MATERIAS.ID_MATERIA,
                        Tables.MATERIAS.NOMBRE
                ).from(Tables.ALUMNOS)
                .join(Tables.CALIFICACIONES)
                .on(Tables.CALIFICACIONES.ID_ALUMNO.eq(Tables.ALUMNOS.ID_ALUMNO))
                .join(Tables.MATERIAS)
                .on(Tables.MATERIAS.ID_MATERIA.eq(Tables.CALIFICACIONES.ID_MATERIA))
                .where(Tables.ALUMNOS.ID_ALUMNO.eq(id))
                .fetch(d -> {
                    return new Boleta(
                            Optional.ofNullable(d.get(Tables.CALIFICACIONES.ID_CALIFICACION)).orElseGet(() -> -1),
                            Optional.ofNullable(d.get(Tables.ALUMNOS.NOMBRE)).orElseGet(() -> ""),
                            makeFullName(d.get(Tables.ALUMNOS.AP_PATERNO), d.get(Tables.ALUMNOS.AP_MATERNO)),
                            Optional.ofNullable(d.get(Tables.MATERIAS.NOMBRE)).orElseGet(() -> ""),
                            Optional.ofNullable(d.get(Tables.CALIFICACIONES.CALIFICACION)).orElseGet(() -> BigDecimal.ZERO),
                            d.get(Tables.CALIFICACIONES.FECHA_REGISTRO)
                    );
                });
        return query;
    }

    private final String makeFullName(String paterno, String materno){
        return Optional.ofNullable(paterno).orElseGet(() -> "")
                +" "+
                Optional.ofNullable(materno).orElseGet(() -> "");
    }
}
