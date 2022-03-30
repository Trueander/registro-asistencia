package com.example.registroasistencia.app.repository;

import com.example.registroasistencia.app.models.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface AsistenciaRepo extends JpaRepository<Asistencia, Long> {

    Optional<Asistencia> findByEstudiante_CodigoAndFechaIngreso(String codigo, LocalDate fechaIngreso);
}
