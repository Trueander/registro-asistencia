package com.example.registroasistencia.app.controller;

import com.example.registroasistencia.app.models.Asistencia;
import com.example.registroasistencia.app.models.Aula;
import com.example.registroasistencia.app.models.Estudiante;
import com.example.registroasistencia.app.service.AulaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    private final AulaService aulaService;

    @GetMapping("/buscar-aula/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Optional<Aula> aulaEncontrada = aulaService.buscarAulaPorId(id);

        if(!aulaEncontrada.isPresent()) {
            return new ResponseEntity<>("No se encontró el aula: "+id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(aulaEncontrada.get(), HttpStatus.OK);
    }

    @PostMapping("/registrar-asistencia")
    public ResponseEntity<?> registrarAsistencia(@RequestBody Asistencia asistencia) {
        Optional<Estudiante> estudianteEncontrado = aulaService
                .buscarEstudiantePorCodigo(asistencia.getEstudiante().getCodigo());

        if(!estudianteEncontrado.isPresent()){
            return new ResponseEntity<>("No se encontró estudiante con código: "+ asistencia.getEstudiante().getCodigo(), HttpStatus.NOT_FOUND);
        }

        Optional<Asistencia> asistenciaEncontrada = aulaService.buscarAsistenciaPorCodigo(asistencia.getEstudiante().getCodigo());

        if(asistenciaEncontrada.isPresent()) {
            return new ResponseEntity<>("No se puede registrar 2 veces la asistencia.", HttpStatus.BAD_REQUEST);
        }

        asistencia.setEstudiante(estudianteEncontrado.get());
        aulaService.registrarAsistencia(asistencia);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/registrar-salida")
    public ResponseEntity<?> actualizarAsistencia(@RequestBody Asistencia asistencia) {
        Optional<Estudiante> estudianteEncontrado = aulaService
                .buscarEstudiantePorCodigo(asistencia.getEstudiante().getCodigo());

        if(!estudianteEncontrado.isPresent()){
            return new ResponseEntity<>("No se encontró estudiante con código: "+ asistencia.getEstudiante().getCodigo(), HttpStatus.NOT_FOUND);
        }

        Optional<Asistencia> asistenciaEncontrada = aulaService.buscarAsistenciaPorCodigo(asistencia.getEstudiante().getCodigo());

        if(!asistenciaEncontrada.isPresent()) {
            return new ResponseEntity<>("No hay asistencia registrada", HttpStatus.BAD_REQUEST);
        }

        aulaService.actualizarAsistencia(asistenciaEncontrada.get());

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/buscar-asistencia/{codigoEstudiante}")
    public ResponseEntity<?> buscarAsistenciaPorCodigo(@PathVariable String codigoEstudiante) {
        Optional<Asistencia> asistenciaEncontrada = aulaService.buscarAsistenciaPorCodigo(codigoEstudiante);

        if(!asistenciaEncontrada.isPresent()) {
            return new ResponseEntity<>("No se encontró asistencia con ese código:" + codigoEstudiante, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(asistenciaEncontrada.get(), HttpStatus.OK);
    }



}
