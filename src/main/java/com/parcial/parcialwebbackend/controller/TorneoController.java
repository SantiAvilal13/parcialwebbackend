package com.parcial.parcialwebbackend.controller;

import com.parcial.parcialwebbackend.model.Torneo;
import com.parcial.parcialwebbackend.service.TorneoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/torneos")
@CrossOrigin(origins = "*")
public class TorneoController {

    private final TorneoService torneoService;

    public TorneoController(TorneoService torneoService) {
        this.torneoService = torneoService;
    }

    // POST - Crear un nuevo torneo
    @PostMapping
    public ResponseEntity<Torneo> crearTorneo(@RequestBody Torneo torneo) {
        Torneo nuevoTorneo = torneoService.crearTorneo(torneo);
        return new ResponseEntity<>(nuevoTorneo, HttpStatus.CREATED);
    }

    // GET - Listar todos los torneos
    @GetMapping
    public ResponseEntity<List<Torneo>> listarTorneos() {
        List<Torneo> torneos = torneoService.listarTorneos();
        return new ResponseEntity<>(torneos, HttpStatus.OK);
    }

    // GET - Consultar un torneo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Torneo> obtenerTorneoPorId(@PathVariable Long id) {
        return torneoService.obtenerTorneoPorId(id)
                .map(torneo -> new ResponseEntity<>(torneo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // PUT - Actualizar un torneo existente
    @PutMapping("/{id}")
    public ResponseEntity<Torneo> actualizarTorneo(@PathVariable Long id, @RequestBody Torneo torneo) {
        try {
            Torneo torneoActualizado = torneoService.actualizarTorneo(id, torneo);
            return new ResponseEntity<>(torneoActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE - Eliminar un torneo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTorneo(@PathVariable Long id) {
        try {
            torneoService.eliminarTorneo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
