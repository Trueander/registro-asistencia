package com.example.registroasistencia.app.repository;

import com.example.registroasistencia.app.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudianteRepo extends JpaRepository<Estudiante, Long> {

    Optional<Estudiante> findByCodigo(String codigo);

}
