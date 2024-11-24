/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registro.Tabla_Incidente.service;

import com.registro.Tabla_Incidente.model.Incidente;
import com.registro.Tabla_Incidente.repository.IncidenteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidenteService {

    @Autowired

    private IncidenteRepository incidenteRepository;

    public List<Incidente> listarTodas() {
        return incidenteRepository.findAll();

    }

    public Incidente guardar(Incidente incidente) {
        return incidenteRepository.save(incidente);

    }

    public Incidente obtenerPorId(Long id) {
        return incidenteRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        incidenteRepository.deleteById(id);
    }

}
