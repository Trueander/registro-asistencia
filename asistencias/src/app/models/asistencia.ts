import { Estudiante } from "./estudiante";

export class Asistencia {
    id!: number;
    fechaIngreso!: string;
    ingresoConfirmado!: boolean;
    salidaConfirmado!: boolean;
    estudiante!: Estudiante;
}
