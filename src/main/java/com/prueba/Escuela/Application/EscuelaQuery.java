package com.prueba.Escuela.Application;

import com.prueba.Escuela.Domain.Aggregates.HistorialAcademico;
import com.prueba.Escuela.Domain.Entities.Alumno;
import com.prueba.Escuela.Domain.Entities.Materia;
import com.prueba.Escuela.Infrastructure.Repositories.AlumnosRepository;
import com.prueba.Escuela.Infrastructure.Repositories.HistorialAcademicoRepository;
import com.prueba.Escuela.Infrastructure.Repositories.MateriasRepository;
import com.prueba.Share.Infrastructure.Controllers.CustomResponse;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class EscuelaQuery {

    private final HistorialAcademicoRepository historialAcademicoRepository;
    private final AlumnosRepository alumnosRepository;
    private final MateriasRepository materiasRepository;

    @Inject
    public EscuelaQuery(final HistorialAcademicoRepository historialAcademicoRepository,
                        final AlumnosRepository alumnosRepository,
                        final MateriasRepository materiasRepository
    ) {
        this.historialAcademicoRepository = historialAcademicoRepository;
        this.alumnosRepository = alumnosRepository;
        this.materiasRepository = materiasRepository;
    }
    public CustomResponse<HistorialAcademico> findBoletaByAlumno(int idAlumno) throws Exception {
        var boleta = historialAcademicoRepository.getBoletaByIdAlumno(idAlumno);
        if(boleta.size()<=0) return new CustomResponse("error","Alumno no encontrado", null);
        var firstRecordHistorial = boleta.stream().findFirst();
        var alumnoFullName = firstRecordHistorial
                .map(d -> d.getNombre()+" "+d.getApellidos())
                .orElseGet(() -> "");
        var getOnlyCalif = boleta
                .stream()
                .map(d -> d.getCalificacion())
                .collect(Collectors.toList());

        var calcSumatoriaCalificaciones =
                getOnlyCalif.stream().reduce(BigDecimal.ZERO, (acc, val) -> acc.add(val));
        var calcPromedio = calcSumatoriaCalificaciones.divide(BigDecimal.valueOf(getOnlyCalif.size()));
        return new CustomResponse("ok", "Alumno encontrado!", new HistorialAcademico(idAlumno, alumnoFullName, boleta, calcPromedio));
    }

    public CustomResponse<List<Alumno>> findAllAlumnos() throws Exception {
        var alumnos = alumnosRepository.getAll();
        return new CustomResponse("ok", "todos", alumnos);
    }

    public CustomResponse<List<Materia>> findAllMaterias() throws Exception {
        var materias = materiasRepository.getAll();
        return new CustomResponse("ok", "todos", materias);
    }
}
