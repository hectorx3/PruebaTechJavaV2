package com.prueba.Escuela.Application;

import com.prueba.Escuela.Domain.Entities.Alumno;
import com.prueba.Escuela.Domain.Entities.Calificacion;
import com.prueba.Escuela.Domain.Entities.Materia;
import com.prueba.Escuela.Domain.UseCases.AlumnoService;
import com.prueba.Escuela.Domain.UseCases.CalificacionService;
import com.prueba.Escuela.Domain.UseCases.MateriaService;
import com.prueba.Escuela.Infrastructure.Repositories.AlumnosRepository;
import com.prueba.Escuela.Infrastructure.Repositories.CalificacionesRepository;
import com.prueba.Escuela.Infrastructure.Repositories.MateriasRepository;
import com.prueba.Share.Infrastructure.Controllers.CustomResponse;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Optional;


@Singleton
public class EscuelaService implements AlumnoService, MateriaService, CalificacionService {

    private static final Logger LOG = LoggerFactory.getLogger(EscuelaService.class);
    private final AlumnosRepository alumnosRepository;
    private final MateriasRepository materiasRepository;
    private final CalificacionesRepository calificacionesRepository;

    @Inject
    public EscuelaService(AlumnosRepository alumnosRepository, MateriasRepository materiasRepository, CalificacionesRepository calificacionesRepository) {
        this.alumnosRepository = alumnosRepository;
        this.materiasRepository = materiasRepository;
        this.calificacionesRepository = calificacionesRepository;
    }

    @Override
    public CustomResponse registerAlumno(Alumno alumno) {
        var save = alumnosRepository.save(alumno);
        if(save > 0) return new CustomResponse("ok","Alumno registrado!",null);
        return new CustomResponse("error", "Error al registrar un alumno", null);
    }

    @Override
    public boolean updateAlumno(Alumno alumno, int id) {
        return false;
    }

    @Override
    public boolean removeAlumno(int id) {
        return false;
    }

    @Override
    public CustomResponse registerCalificacion(Calificacion calificacion) {
        var findMateria = materiasRepository.getAllById(calificacion.getIdMateria());
        if(findMateria.size()==0) return new CustomResponse("error", "La materia no existe",null);
        var findAlumno = alumnosRepository.getById(calificacion.getIdAlumno());
        if(findAlumno == null) return new CustomResponse("error", "El alumno no existe",null);
        var findCalifByMateriaAndAlumno = calificacionesRepository.getByIdMateriaAndAlumno(calificacion.getIdMateria(), calificacion.getIdAlumno());
        if(findCalifByMateriaAndAlumno.size()>0) return new CustomResponse("error", "La calificacion de la materia ya ha sido registrada",null);
        calificacion.setFecha_registro(LocalDateTime.now());
        var save = calificacionesRepository.save(calificacion);
        if(save > 0) return new CustomResponse("ok", "Calificacion registrada",null);
        return new CustomResponse("error", "Error al registrar la calificacion",null);
    }

    @Override
    public CustomResponse updateCalificacion(Calificacion calificacion, int idCalificacion) {
        var findCalif = Optional.ofNullable(calificacionesRepository.getById(idCalificacion));
        var result = findCalif.map(d -> {
            var save = calificacionesRepository.updateOnlyCalificacion(calificacion.getCalificacion(), idCalificacion);
            if(save) return new CustomResponse("ok", "Calificacion actualizada",null);
            return new CustomResponse("error", "Error al actualizar la calificacion",null);
        }).orElseGet(() -> new CustomResponse("error", "calificacion no encontrada",null));
        return result;
    }

    @Override
    public CustomResponse removeCalificacion(int idCalificacion) {
        var save = calificacionesRepository.delete(idCalificacion);
        if(save) return new CustomResponse("ok", "Calificacion eliminada",null);
        return new CustomResponse("error", "Error al eliminar la calificacion",null);
    }

    @Override
    public CustomResponse registerMateria(Materia materia) {
        return null;
    }

    @Override
    public boolean updateMateria(Materia materia, int id) {
        return false;
    }

    @Override
    public boolean removeMateria(int id) {
        return false;
    }
}
