package com.prueba.Escuela.Infrastructure.Repositories;

import com.prueba.Escuela.Domain.Entities.Materia;
import com.prueba.Escuela.Domain.Repositories.IMateriasRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jooq.Tables;
import org.jooq.DSLContext;

import java.util.List;
import java.util.Optional;

@Singleton
public class MateriasRepository implements IMateriasRepository {

    @Inject
    DSLContext dslContext;

    @Override
    public Materia getById(int id) {
        return null;
    }

    @Override
    public List<Materia> getAll() {
        var query = dslContext
                .select(
                        Tables.MATERIAS.ID_MATERIA,
                        Tables.MATERIAS.NOMBRE,
                        Tables.MATERIAS.ACTIVO
                )
                .from(Tables.MATERIAS)
                .fetch(d -> {
                    return new Materia(
                            Optional.ofNullable(d.get(Tables.MATERIAS.ID_MATERIA)).orElseGet(() -> -1),
                            Optional.ofNullable(d.get(Tables.MATERIAS.NOMBRE)).orElseGet(() -> ""),
                            d.get(Tables.MATERIAS.ACTIVO)
                    );
                });
        return query;
    }

    @Override
    public List<Materia> getAllById(int idMateria) {
        var query = dslContext
                .select(
                        Tables.MATERIAS.ID_MATERIA,
                        Tables.MATERIAS.NOMBRE,
                        Tables.MATERIAS.ACTIVO
                )
                .from(Tables.MATERIAS)
                .where(Tables.MATERIAS.ID_MATERIA.eq(idMateria))
                .fetch(d -> {
                    return new Materia(
                            Optional.ofNullable(d.get(Tables.MATERIAS.ID_MATERIA)).orElseGet(() -> -1),
                            Optional.ofNullable(d.get(Tables.MATERIAS.NOMBRE)).orElseGet(() -> ""),
                            d.get(Tables.MATERIAS.ACTIVO)
                    );
                });
        return query;
    }

    @Override
    public int save(Materia materia) {
        return 0;
    }

    @Override
    public boolean update(Materia materia, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
