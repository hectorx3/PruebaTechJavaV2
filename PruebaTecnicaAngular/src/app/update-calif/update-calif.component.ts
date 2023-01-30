import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { map, tap, of, Observable } from 'rxjs';
import { EscuelaService } from '../services/escuela.service';

@Component({
  selector: 'app-update-calif',
  templateUrl: './update-calif.component.html',
  styleUrls: ['./update-calif.component.css']
})
export class UpdateCalifComponent implements OnInit {

  calificacionText:any;
  calificacionId: number = 0;
  alumnoId: number = 0;

  nombreMateria: string = '';

  constructor(
    private route: ActivatedRoute,
    private escuelaService: EscuelaService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const queryParams = this.route.snapshot.queryParamMap
    console.log(queryParams)
    this.nombreMateria = queryParams.get('materia') || ''
    this.alumnoId = Number(queryParams.get('alumnoId')) || -1
    const calificacionIdFromRoute = Number(routeParams.get('calificacionId'));
    this.calificacionId = calificacionIdFromRoute
  }

  save(){

    
    const califToNumber = parseFloat(this.calificacionText)
    console.log(this.calificacionId, califToNumber)
    if(califToNumber < 1 || califToNumber > 10){
      alert("Minimo 1 y maximo 10")
      return;
    }

    this.escuelaService.updateCalificacion(this.calificacionId, califToNumber)
    .subscribe(d => {
      console.log(d, 'respuesta del registro de calificaciones')
      if(d.statusCode && d.statusCode != 'error'){
        this.router.navigate(['/kardex/'+this.alumnoId])
      }
    });
  }


}
