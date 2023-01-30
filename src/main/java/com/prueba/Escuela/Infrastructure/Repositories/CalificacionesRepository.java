package com.prueba.Escuela.Infrastructure.Repositories;

import com.prueba.Escuela.Domain.Entities.Calificacion;
import com.prueba.Escuela.Domain.Repositories.ICalificacionesRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jooq.Tables;
import org.jooq.DSLContext;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Singleton
public class CalificacionesRepository implements ICalificacionesRepository {

    @Inject
    DSLContext dslContext;

    @Override
    public Calificacion getById(int id) {
        var query = dslContext
                .select(
                        Tables.CALIFICACIONES.ID_CALIFICACION,
                        Tables.CALIFICACIONES.ID_MATERIA,
                        Tables.CALIFICACIONES.ID_ALUMNO,
                        Tables.CALIFICACIONES.CALIFICACION,
                        Tables.CALIFICACIONES.FECHA_REGISTRO,
                        Tables.CALIFICACIONES.ACTIVO
                )
                .from(Tables.CALIFICACIONES)
                .where(Tables.CALIFICACIONES.ID_CALIFICACION.eq(id))
                .fetchOne(d -> {
                    return new Calificacion(
                            Optional.ofNullable(d.get(Tables.CALIFICACIONES.ID_CALIFICACION)).orElseGet(() -> -1),
                            Optional.ofNullable(d.get(Tables.CALIFICACIONES.ID_MATERIA)).orElseGet(() -> -1),
                            Optional.ofNullable(d.get(Tables.CALIFICACIONES.ID_ALUMNO)).orElseGet(() -> -1),
                            Optional.ofNullable(d.get(Tables.CALIFICACIONES.CALIFICACION)).orElseGet(() -> BigDecimal.ZERO),
                            d.get(Tables.CALIFICACIONES.FECHA_REGISTRO),
                            d.get(Tables.CALIFICACIONES.ACTIVO)
                    );
                });
        return query;
    }

    @Override
    public List<Calificacion> getByIdMateriaAndAlumno(int idMateria, int idAlumno) {
        var query = dslContext
                .select(
                        Tables.CALIFICACIONES.ID_CALIFICACION,
                        Tables.CALIFICACIONES.ID_MATERIA,
                        Tables.CALIFICACIONES.ID_ALUMNO,
                        Tables.CALIFICACIONES.CALIFICACION,
                        Tables.CALIFICACIONES.FECHA_REGISTRO,
                        Tables.CALIFICACIONES.ACTIVO
                )
                .from(Tables.CALIFICACIONES)
                .where(Tables.CALIFICACIONES.ID_MATERIA.eq(idMateria))
                .and(Tables.CALIFICACIONES.ID_ALUMNO.eq(idAlumno))
                .fetch(d -> {
                    return new Calificacion(
                            Optional.ofNullable(d.get(Tables.CALIFICACIONES.ID_CALIFICACION)).orElseGet(() -> -1),
                            Optional.ofNullable(d.get(Tables.CALIFICACIONES.ID_MATERIA)).orElseGet(() -> -1),
                            Optional.ofNullable(d.get(Tables.CALIFICACIONES.ID_ALUMNO)).orElseGet(() -> -1),
                            Optional.ofNullable(d.get(Tables.CALIFICACIONES.CALIFICACION)).orElseGet(() -> BigDecimal.ZERO),
                            d.get(Tables.CALIFICACIONES.FECHA_REGISTRO),
                            d.get(Tables.CALIFICACIONES.ACTIVO)
                    );
                });
        return query;
    }

    @Override
    public List<Calificacion> getAll() {
        return null;
    }

    @Override
    public int save(Calificacion calificacion) {
        var insert = dslContext.insertInto(Tables.CALIFICACIONES,
                Tables.CALIFICACIONES.ID_MATERIA,
                Tables.CALIFICACIONES.ID_ALUMNO,
                Tables.CALIFICACIONES.ACTIVO,
                Tables.CALIFICACIONES.FECHA_REGISTRO,
                Tables.CALIFICACIONES.ID_MATERIA,
                Tables.CALIFICACIONES.CALIFICACION
        ).values(
                calificacion.getIdMateria(),
                calificacion.getIdAlumno(),
                calificacion.isActivo(),
                calificacion.getFecha_registro(),
                calificacion.getIdMateria(),
                calificacion.getCalificacion()
        ).execute();
        return insert;
    }

    @Override
    public boolean update(Calificacion calificacion, int idCalificacion) {
        var update = dslContext.update(Tables.CALIFICACIONES)
                .set(Tables.CALIFICACIONES.ID_MATERIA, calificacion.getIdMateria())
                .set(Tables.CALIFICACIONES.ID_ALUMNO, calificacion.getIdAlumno())
                .set(Tables.CALIFICACIONES.ACTIVO, calificacion.isActivo())
                .set(Tables.CALIFICACIONES.FECHA_REGISTRO, calificacion.getFecha_registro())
                .set(Tables.CALIFICACIONES.ID_MATERIA, calificacion.getIdMateria())
                .set(Tables.CALIFICACIONES.CALIFICACION, calificacion.getCalificacion())
                .where(Tables.CALIFICACIONES.ID_CALIFICACION.eq(idCalificacion))
                .execute();
        return (update > 0) ? true : false;
    }

    @Override
    public boolean updateOnlyCalificacion(BigDecimal calificacion, int idCalificacion) {
        var update = dslContext.update(Tables.CALIFICACIONES)
                .set(Tables.CALIFICACIONES.CALIFICACION, calificacion)
                .where(Tables.CALIFICACIONES.ID_CALIFICACION.eq(idCalificacion))
                .execute();
        return (update > 0) ? true : false;
    }

    @Override
    public boolean delete(int id) {
        var delete = dslContext.delete(Tables.CALIFICACIONES)
                .where(Tables.CALIFICACIONES.ID_CALIFICACION.eq(id))
                .execute();
        return (delete > 0) ? true : false;
    }
}
