package com.parcial.parcialwebbackend.service;

import com.parcial.parcialwebbackend.model.Torneo;
import com.parcial.parcialwebbackend.repository.TorneoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TorneoService {

    private final TorneoRepository torneoRepository;

    public TorneoService(TorneoRepository torneoRepository) {
        this.torneoRepository = torneoRepository;
    }

    // Crear un nuevo torneo
    public Torneo crearTorneo(Torneo torneo) {
        return torneoRepository.save(torneo);
    }

    // Listar todos los torneos
    public List<Torneo> listarTorneos() {
        return torneoRepository.findAll();
    }

    // Consultar un torneo por ID
    public Optional<Torneo> obtenerTorneoPorId(Long id) {
        return torneoRepository.findById(id);
    }

    // Actualizar un torneo existente
    public Torneo actualizarTorneo(Long id, Torneo torneoActualizado) {
        return torneoRepository.findById(id)
                .map(torneoExistente -> {
                    torneoExistente.setNombre(torneoActualizado.getNombre());
                    torneoExistente.setDeporte(torneoActualizado.getDeporte());
                    torneoExistente.setFechaInicio(torneoActualizado.getFechaInicio());
                    torneoExistente.setCiudad(torneoActualizado.getCiudad());
                    return torneoRepository.save(torneoExistente);
                })
                .orElseThrow(() -> new RuntimeException("Torneo no encontrado con id: " + id));
    }

    // Eliminar un torneo por ID
    public void eliminarTorneo(Long id) {
        if (!torneoRepository.existsById(id)) {
            throw new RuntimeException("Torneo no encontrado con id: " + id);
        }
        torneoRepository.deleteById(id);
    }

}
