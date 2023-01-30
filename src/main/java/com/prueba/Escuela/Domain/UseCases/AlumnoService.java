package com.prueba.Escuela.Domain.UseCases;

import com.prueba.Escuela.Domain.Entities.Alumno;
import com.prueba.Share.Infrastructure.Controllers.CustomResponse;

public interface AlumnoService {
    public CustomResponse registerAlumno(Alumno alumno);
    public boolean updateAlumno(Alumno alumno, int id);
    public boolean removeAlumno(int id);
}
