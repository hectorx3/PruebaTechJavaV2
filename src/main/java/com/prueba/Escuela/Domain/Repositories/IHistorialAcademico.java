package com.prueba.Escuela.Domain.Repositories;


import com.prueba.Escuela.Domain.Aggregates.HistorialAcademico;
import com.prueba.Escuela.Domain.ValueObject.Boleta;

import java.util.List;

public interface IHistorialAcademico {
    public List<Boleta> getBoletaByIdAlumno(int id);
}
