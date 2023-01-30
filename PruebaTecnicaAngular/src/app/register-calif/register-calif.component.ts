import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { map, Observable, of, tap } from 'rxjs';
import { EscuelaService } from '../services/escuela.service';

@Component({
  selector: 'app-register-calif',
  templateUrl: './register-calif.component.html',
  styleUrls: ['./register-calif.component.css']
})
export class RegisterCalifComponent implements OnInit {

  getAllMaterias$: Observable<any> = of();

  selectedObject:any;
  calificacionText:any;
  alumnoId: number = 0;

  constructor(
    private route: ActivatedRoute,
    private escuelaService: EscuelaService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const alumnoIdFromRoute = Number(routeParams.get('alumnoId'));
    this.alumnoId = alumnoIdFromRoute

    this.getAllMaterias$ = this.escuelaService
      .getAllMaterias()
      .pipe(
        map(d => d.data),
        tap(console.log),
      )
  }

  save(){
    console.log(this.selectedObject, this.calificacionText)
    const califToNumber = parseFloat(this.calificacionText)
    if(califToNumber < 1 || califToNumber > 10){
      alert("Minimo 1 y maximo 10")
      return;
    }

    this.escuelaService.saveCalificacion(this.selectedObject.id, this.alumnoId, califToNumber)
    .subscribe(d => {
      console.log(d, 'respuesta del registro de calificaciones')
      if(d.statusCode && d.statusCode != 'error'){
        this.router.navigate(['/kardex/'+this.alumnoId])
      }
    });
  }

}
