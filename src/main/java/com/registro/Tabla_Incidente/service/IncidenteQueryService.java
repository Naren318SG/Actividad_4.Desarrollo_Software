/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registro.Tabla_Incidente.service;

import com.registro.Tabla_Incidente.model.Incidente;
import com.registro.Tabla_Incidente.repository.IncidenteRepository;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncidenteQueryService {

  
    @Autowired
    private IncidenteRepository incidenteRepository;

    // Método para obtener todos los incidentes
    public List<Incidente> obtenerTodosLosIncidentes() {
        return incidenteRepository.findAll();
    }

    // Método para obtener un incidente por su ID
    public Optional<Incidente> obtenerIncidentePorId(Long id) {
        return incidenteRepository.findById(id);
        
    }
       
    // Método para contar incidentes por severidad
     public Map<String, Long> contarIncidentesPorSeveridad() {
        List<Incidente> incidentes = incidenteRepository.findAll();
        return incidentes.stream()
                .collect(Collectors.groupingBy(Incidente::getSeveridad, Collectors.counting()));
    
}
    // Método para contar incidentes por fecha
    public Map<String, Long> contarIncidentesPorFecha() {
        List<Incidente> incidentes = incidenteRepository.findAll();
        return incidentes.stream()
                .collect(Collectors.groupingBy(incidente -> incidente.getFechaIncidente().toString(), Collectors.counting()));
    }

    // Método para obtener el total de incidentes
    public long obtenerTotalIncidentes() {
        return incidenteRepository.count();
        
    }

}
