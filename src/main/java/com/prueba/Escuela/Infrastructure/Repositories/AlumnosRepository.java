package com.prueba.Escuela.Infrastructure.Repositories;

import com.prueba.Escuela.Domain.Entities.Alumno;
import com.prueba.Escuela.Domain.Repositories.IAlumnosRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jooq.Tables;
import org.jooq.DSLContext;

import java.util.List;
import java.util.Optional;

@Singleton
public class AlumnosRepository implements IAlumnosRepository {

    @Inject
    DSLContext dslContext;
    @Override
    public Alumno getById(int id) {
        var query = dslContext
                .select(
                        Tables.ALUMNOS.ID_ALUMNO,
                        Tables.ALUMNOS.NOMBRE,
                        Tables.ALUMNOS.AP_PATERNO,
                        Tables.ALUMNOS.AP_MATERNO,
                        Tables.ALUMNOS.ACTIVO
                )
                .from(Tables.ALUMNOS)
                .where(Tables.ALUMNOS.ID_ALUMNO.eq(id))
                .fetchOne(d -> {
                    return new Alumno(
                            Optional.ofNullable(d.get(Tables.ALUMNOS.ID_ALUMNO)).orElseGet(() -> -1),
                            Optional.ofNullable(d.get(Tables.ALUMNOS.NOMBRE)).orElseGet(() -> ""),
                            Optional.ofNullable(d.get(Tables.ALUMNOS.AP_PATERNO)).orElseGet(() -> ""),
                            Optional.ofNullable(d.get(Tables.ALUMNOS.AP_MATERNO)).orElseGet(() -> ""),
                            d.get(Tables.ALUMNOS.ACTIVO)
                    );
                });
        return query;
    }

    @Override
    public List<Alumno> getAll() {
        var query = dslContext
                .select(
                        Tables.ALUMNOS.ID_ALUMNO,
                        Tables.ALUMNOS.NOMBRE,
                        Tables.ALUMNOS.AP_PATERNO,
                        Tables.ALUMNOS.AP_MATERNO,
                        Tables.ALUMNOS.ACTIVO
                )
                .from(Tables.ALUMNOS)
                .fetch(d -> {
                    return new Alumno(
                            Optional.ofNullable(d.get(Tables.ALUMNOS.ID_ALUMNO)).orElseGet(() -> -1),
                            Optional.ofNullable(d.get(Tables.ALUMNOS.NOMBRE)).orElseGet(() -> ""),
                            Optional.ofNullable(d.get(Tables.ALUMNOS.AP_PATERNO)).orElseGet(() -> ""),
                            Optional.ofNullable(d.get(Tables.ALUMNOS.AP_MATERNO)).orElseGet(() -> ""),
                            d.get(Tables.ALUMNOS.ACTIVO)
                    );
                });
        return query;
    }

    @Override
    public int save(Alumno alumno) {
        return 0;
    }

    @Override
    public boolean update(Alumno alumno, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
