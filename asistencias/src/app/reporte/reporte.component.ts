import { Component, OnInit } from '@angular/core';
import { Asistencia } from '../models/asistencia';
import { Aula } from '../models/aula';
import { Estudiante } from '../models/estudiante';
import { AulaService } from '../services/aula.service';

@Component({
  selector: 'app-reporte',
  templateUrl: './reporte.component.html',
  styleUrls: ['./reporte.component.css']
})
export class ReporteComponent implements OnInit {

  estudiantes: Estudiante[] = [];
  asistencias: Asistencia[] = [];
  aula!: Aula;

  constructor(private aulaService: AulaService) { }

  ngOnInit(): void {
    this.aulaService.obtenerAulaPorId(1)
        .subscribe(response => {
          console.log(response)
          this.aula = response;
          this.estudiantes = this.aula.estudiantes;
          this.buscarAsistencias();
        })
  }

  buscarAsistencias() {
    this.estudiantes.forEach((e: Estudiante) => {
      this.aulaService.buscarAsistenciaPorCodigo(e.codigo)
          .subscribe({
            next: (asistencia: Asistencia) => {
              this.asistencias.push(asistencia);
            },
            error: err => {
              let nuevaAsistencia: Asistencia = new Asistencia();
              nuevaAsistencia.estudiante = e;
              this.asistencias.push(nuevaAsistencia);
            }
          })
    })
  }

}
