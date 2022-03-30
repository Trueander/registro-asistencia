package com.example.registroasistencia.app.repository;

import com.example.registroasistencia.app.models.Aula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AulaRepo extends JpaRepository<Aula, Long> {
}
