import { Component, OnInit } from '@angular/core';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { Asistencia } from '../models/asistencia';
import { Estudiante } from '../models/estudiante';
import { AulaService } from '../services/aula.service';

@Component({
  selector: 'app-registrar-salida',
  templateUrl: './registrar-salida.component.html',
  styleUrls: ['./registrar-salida.component.css']
})
export class RegistrarSalidaComponent implements OnInit {

  asistencia: Asistencia = new Asistencia();
  estudiante: Estudiante = new Estudiante();
  mensaje: string = '';

  horizontalPosition: MatSnackBarHorizontalPosition = 'end';
  verticalPosition: MatSnackBarVerticalPosition = 'top';

  constructor(private aulaService: AulaService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  registrarSalida(){
    this.asistencia.estudiante = this.estudiante;
    this.aulaService.registrarSalida(this.asistencia)
        .subscribe({
          next: response => {
            this.mensaje = 'Se registro la salida';
            this.openSnackBar();
          },
          error: error => {
            console.log(error)
            this.mensaje = error.error;
            this.openSnackBar();
          }
        })
  }

  openSnackBar() {
    this._snackBar.open(this.mensaje, 'Cerrar', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
      duration: 3000
    });
  }

}
