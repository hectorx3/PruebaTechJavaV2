import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EscuelaService {

  private readonly API_BASE: string = '/escuela'

  constructor(private http: HttpClient) { }

  getBoleta(idAlumno: number) {
    return this.http.get<any>(`${this.API_BASE}/boleta/${idAlumno}`);
  }

  getAllAlumnos() {
    return this.http.get<any>(`${this.API_BASE}/alumnos`);
  }

  getAllMaterias() {
    return this.http.get<any>(`${this.API_BASE}/materias`);
  }

  saveCalificacion(idMateria: number, idAlumno: number, calificacion: number) {
    return this.http.post<any>(`${this.API_BASE}/calificaciones`, { idMateria:idMateria, idAlumno:idAlumno,  calificacion:calificacion });
  }

  updateCalificacion(calificacionId: number, calificacion: number) {
    return this.http.put<any>(`${this.API_BASE}/calificaciones/${calificacionId}`, { calificacion:calificacion});
  }
}
