package com.prueba.Escuela.Infrastructure.Controllers;

import com.prueba.Escuela.Application.EscuelaQuery;
import com.prueba.Escuela.Application.EscuelaService;
import com.prueba.Escuela.Domain.Aggregates.HistorialAcademico;
import com.prueba.Escuela.Domain.Entities.Alumno;
import com.prueba.Escuela.Domain.Entities.Calificacion;
import com.prueba.Escuela.Domain.Entities.Materia;
import com.prueba.Share.Infrastructure.Controllers.CustomResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller("/escuela")
@Secured(SecurityRule.IS_ANONYMOUS)
public class EscuelaController {
    private static final Logger LOG = LoggerFactory.getLogger(EscuelaController.class);
    private final EscuelaService escuelaService;
    private final EscuelaQuery escuelaQuery;

    @Inject
    public EscuelaController(
            final EscuelaService escuelaService,
            final EscuelaQuery escuelaQuery
    ) {
        this.escuelaService = escuelaService;
        this.escuelaQuery = escuelaQuery;
    }

    @Get("boleta/{idAlumno}")
    public CustomResponse<HistorialAcademico> getCalificacionesByIdAlumno(@PathVariable Integer idAlumno) {
        try{
            return escuelaQuery.findBoletaByAlumno(idAlumno);
        }catch (Exception e){
            LOG.error(e.getMessage());
            return new CustomResponse("error","Erro al ejecutar la accion", null);
        }
    }

    @Get("alumnos")
    public CustomResponse<List<Alumno>> getAllAlumnos() {
        try{
            return escuelaQuery.findAllAlumnos();
        }catch (Exception e){
            LOG.error(e.getMessage());
            return new CustomResponse("error","Erro al ejecutar la accion", null);
        }
    }

    @Get("materias")
    public CustomResponse<List<Materia>> getAllMaterias() {
        try{
            return escuelaQuery.findAllMaterias();
        }catch (Exception e){
            LOG.error(e.getMessage());
            return new CustomResponse("error","Erro al ejecutar la accion", null);
        }
    }

    @Post("calificaciones")
    public CustomResponse<String> registerCalificacion(@Body Calificacion calificacion) {
        try{
            return escuelaService.registerCalificacion(calificacion);
        }catch (Exception err){
            LOG.error(err.getMessage());
            return new CustomResponse("error","Erro al ejecutar la accion", null);
        }

    }

    @Put("calificaciones/{idCalificacion}")
    public CustomResponse<String> updateCalificacion(@PathVariable Integer idCalificacion, @Body Calificacion calificacion) {
        try{
            return escuelaService.updateCalificacion(calificacion, idCalificacion);
        }catch (Exception err){
            LOG.error(err.getMessage());
            return new CustomResponse("error","Erro al ejecutar la accion", null);
        }
    }

    @Delete("calificaciones/{idCalificacion}")
    public CustomResponse<String> deleteCalificacion(@PathVariable Integer idCalificacion) {
        try{
            return escuelaService.removeCalificacion(idCalificacion);
        }catch (Exception err){
            LOG.error(err.getMessage());
            return new CustomResponse("error","Erro al ejecutar la accion", null);
        }

    }

}
