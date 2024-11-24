/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.registro.Tabla_Incidente.repository;

import com.registro.Tabla_Incidente.model.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Estudiante
 */
public interface IncidenteRepository extends JpaRepository <Incidente, Long> {
    
}
