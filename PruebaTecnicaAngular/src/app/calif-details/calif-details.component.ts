import { Product, products } from '../products';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EscuelaService } from '../services/escuela.service';
import { map, Observable, of, tap } from 'rxjs';

@Component({
  selector: 'app-calif-details',
  templateUrl: './calif-details.component.html',
  styleUrls: ['./calif-details.component.css']
})
export class CalifDetailsComponent implements OnInit {

  getCalifAlumno$: Observable<any> = of();

  constructor(
    private route: ActivatedRoute,
    private escuelaService: EscuelaService
  ) { }

  ngOnInit() {
    
    const routeParams = this.route.snapshot.paramMap;
    const alumnoIdFromRoute = Number(routeParams.get('alumnoId'));

    this.getCalifAlumno$ = this.escuelaService
      .getBoleta(alumnoIdFromRoute)
      .pipe(
        map(d => d.data),
        tap(console.log),
      )
  }

}
