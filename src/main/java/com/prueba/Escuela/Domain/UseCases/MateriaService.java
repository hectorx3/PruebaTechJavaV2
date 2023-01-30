package com.prueba.Escuela.Domain.UseCases;

import com.prueba.Escuela.Domain.Entities.Alumno;
import com.prueba.Escuela.Domain.Entities.Materia;
import com.prueba.Share.Infrastructure.Controllers.CustomResponse;

public interface MateriaService {
    public CustomResponse registerMateria(Materia materia);
    public boolean updateMateria(Materia materia, int id);
    public boolean removeMateria(int id);
}
