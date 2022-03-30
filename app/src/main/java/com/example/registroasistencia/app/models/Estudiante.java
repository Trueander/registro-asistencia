package com.example.registroasistencia.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellidos;

    private String codigo;

    @OneToMany(mappedBy = "estudiante")
    @JsonIgnoreProperties({"estudiante","hibernateLazyInitializer", "handler"})
    private List<Asistencia> asistencias;

}
