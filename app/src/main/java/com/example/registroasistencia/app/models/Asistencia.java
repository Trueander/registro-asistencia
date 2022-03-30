package com.example.registroasistencia.app.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaIngreso;

    @Column(name = "ingreso_confirmado")
    private Boolean ingresoConfirmado;

    private Boolean salidaConfirmado;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

}
