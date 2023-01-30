package com.prueba.Escuela.Domain.Repositories;

import com.prueba.Escuela.Domain.Entities.Alumno;
import com.prueba.Escuela.Domain.Entities.Calificacion;

import java.math.BigDecimal;
import java.util.List;

public interface ICalificacionesRepository {
    public Calificacion getById(int id);
    public List<Calificacion> getByIdMateriaAndAlumno(int idMateria, int idAlumno);
    public List<Calificacion> getAll();
    public int save(Calificacion calificacion);
    public boolean update(Calificacion calificacion, int id);
    public boolean updateOnlyCalificacion(BigDecimal calificacion, int idCalificacion);
    public boolean delete(int id);
}
