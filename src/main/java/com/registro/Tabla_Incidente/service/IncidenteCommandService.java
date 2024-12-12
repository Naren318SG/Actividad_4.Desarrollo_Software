/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registro.Tabla_Incidente.service;

import com.registro.Tabla_Incidente.model.Incidente;
import com.registro.Tabla_Incidente.repository.IncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

        
/**
 *
 * @author Estudiante
 */
@Service
public class IncidenteCommandService {
      @Autowired
    private IncidenteRepository incidenteRepository;

    // Método para guardar un nuevo incidente o actualizar uno existente
    public Incidente guardarIncidente(Incidente incidente) {
        return incidenteRepository.save(incidente);
    }

    // Método para eliminar un incidente por su ID
    public void eliminarIncidente(Long id) {
        incidenteRepository.deleteById(id);
    }
}
