import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistrarAsistenciaComponent } from './registrar-asistencia/registrar-asistencia.component';
import { RegistrarSalidaComponent } from './registrar-salida/registrar-salida.component';
import { ReporteComponent } from './reporte/reporte.component';

const routes: Routes = [
  {path: 'registro-asistencia', component: RegistrarAsistenciaComponent},
  {path: 'registro-salida', component: RegistrarSalidaComponent},
  {path: 'reporte', component: ReporteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
