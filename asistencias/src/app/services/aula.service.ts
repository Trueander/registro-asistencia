import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Asistencia } from '../models/asistencia';

@Injectable({
  providedIn: 'root'
})
export class AulaService {

  urlBackend: string = 'http://localhost:8080/api/aulas';

  constructor(private http: HttpClient) { }

  obtenerAulaPorId(id: number): Observable<any> {
    return this.http.get<any>(`${this.urlBackend}/buscar-aula/${id}`);
  }

  registrarAsistencia(asistencia: Asistencia): Observable<any> {
    return this.http.post<any>(`${this.urlBackend}/registrar-asistencia`, asistencia);
  }

  registrarSalida(asistencia: Asistencia): Observable<any> {
    return this.http.put<any>(`${this.urlBackend}/registrar-salida`, asistencia);
  }

  buscarAsistenciaPorCodigo(codigoEstudiante: string): Observable<any> {
    return this.http.get<any>(`${this.urlBackend}/buscar-asistencia/${codigoEstudiante}`);
  }

}
