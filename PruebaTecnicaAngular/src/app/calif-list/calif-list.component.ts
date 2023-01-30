import { Component, OnInit } from '@angular/core';
import { map, mergeMap, Observable, tap, toArray } from 'rxjs';

import { EscuelaService } from '../services/escuela.service';

@Component({
  selector: 'app-calif-list',
  templateUrl: './calif-list.component.html',
  styleUrls: ['./calif-list.component.css']
})
export class CalifListComponent implements OnInit {

  getAllAlumnos$: Observable<any>;

  constructor(private escuelaService: EscuelaService) { 
    this.getAllAlumnos$ = this.escuelaService
      .getAllAlumnos()
      .pipe(
        map(d => d.data),
        mergeMap(d => d),
        map((d: any) => ({nombreCompleto: `${d.nombre} ${d.apellido_paterno} ${d.apellido_materno}`, id: d.id })),
        toArray(),
        tap(console.log),
      )
  }

  ngOnInit() {}

  share() {
    window.alert('Lo has compartido en facebook!');
  }
}