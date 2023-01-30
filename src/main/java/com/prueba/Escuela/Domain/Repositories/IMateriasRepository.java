package com.prueba.Escuela.Domain.Repositories;

import com.prueba.Escuela.Domain.Entities.Calificacion;
import com.prueba.Escuela.Domain.Entities.Materia;

import java.util.List;

public interface IMateriasRepository {
    public Materia getById(int id);
    public List<Materia> getAll();
    public List<Materia> getAllById(int idMateria);
    public int save(Materia materia);
    public boolean update(Materia materia, int id);
    public boolean delete(int id);
}
