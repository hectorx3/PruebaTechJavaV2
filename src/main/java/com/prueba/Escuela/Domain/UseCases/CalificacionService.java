package com.prueba.Escuela.Domain.UseCases;

import com.prueba.Escuela.Domain.Entities.Calificacion;
import com.prueba.Share.Infrastructure.Controllers.CustomResponse;

public interface CalificacionService {
    public CustomResponse registerCalificacion(Calificacion calificacion);
    public CustomResponse updateCalificacion(Calificacion calificacion, int id);
    public CustomResponse removeCalificacion(int id);
}
