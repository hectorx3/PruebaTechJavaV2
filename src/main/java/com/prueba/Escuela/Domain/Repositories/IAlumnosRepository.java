package com.prueba.Escuela.Domain.Repositories;

import com.prueba.Escuela.Domain.Entities.Alumno;

import java.util.List;

public interface IAlumnosRepository {
    public Alumno getById(int id);
    public List<Alumno> getAll();
    public int save(Alumno alumno);
    public boolean update(Alumno alumno, int id);
    public boolean delete(int id);
}
