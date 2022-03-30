package com.example.registroasistencia.app.service;

import com.example.registroasistencia.app.models.Asistencia;
import com.example.registroasistencia.app.models.Aula;
import com.example.registroasistencia.app.models.Estudiante;

import java.util.Optional;

public interface AulaService {

    Optional<Aula> buscarAulaPorId(Long id);
    Optional<Asistencia> buscarAsistenciaPorCodigo(String codigo);
    Optional<Estudiante> buscarEstudiantePorCodigo(String codigo);
    void registrarAsistencia(Asistencia asistencia);
    void actualizarAsistencia(Asistencia asistencia);

}
