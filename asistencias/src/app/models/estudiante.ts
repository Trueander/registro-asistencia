import { Asistencia } from "./asistencia";

export class Estudiante {
    id!: number;
    nombre!: string;
    apellidos!: string;
    codigo!: string;
    asistencias!: Asistencia[];
}
