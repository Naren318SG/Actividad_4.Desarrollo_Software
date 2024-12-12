/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.registro.Tabla_Incidente.controller;

import com.registro.Tabla_Incidente.model.Incidente;
import com.registro.Tabla_Incidente.service.IncidenteQueryService;
import com.registro.Tabla_Incidente.service.IncidenteCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/incidentes")
public class IncidenteController {

    @Autowired
    private IncidenteQueryService incidenteQueryService;  // Servicio de consulta

    @Autowired
    private IncidenteCommandService incidenteCommandService;  // Servicio de comandos

    @GetMapping("/")
    public String listarIncidentes(Model model) {
        model.addAttribute("incidentes", incidenteQueryService.obtenerTodosLosIncidentes());  // Usar el servicio de consulta
        return "incidente-list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoIncidente(Model model) {
        model.addAttribute("incidente", new Incidente());
        return "incidente-form";
    }

    @PostMapping("/guardar")
    public String guardarIncidente(Incidente incidente) {
        if (incidente.getId() != null) {
            Incidente incidenteExistente = incidenteQueryService.obtenerIncidentePorId(incidente.getId()).orElse(null);  // Usar servicio de consulta
            if (incidenteExistente != null) {
                // Si el incidente existe, lo actualizamos
                incidenteExistente.setDescripcion(incidente.getDescripcion());
                incidenteExistente.setSeveridad(incidente.getSeveridad());
                incidenteExistente.setCosto(incidente.getCosto());
                incidenteExistente.setFechaIncidente(incidente.getFechaIncidente());
                incidenteCommandService.guardarIncidente(incidenteExistente);  
                return "redirect:/incidentes/";
            }
        }

        // Si es un nuevo incidente, lo guardamos
        incidenteCommandService.guardarIncidente(incidente);  
        return "redirect:/incidentes/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarIncidente(@PathVariable Long id, Model model) {
        model.addAttribute("incidente", incidenteQueryService.obtenerIncidentePorId(id).orElse(null));  
        return "incidente-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarIncidente(@PathVariable Long id) {
        incidenteCommandService.eliminarIncidente(id);  
        return "redirect:/incidentes/";
   }
    
    
    @GetMapping("/reportes")
    public String mostrarReportes(Model model) {
        model.addAttribute("totalIncidentes", incidenteQueryService.obtenerTotalIncidentes());
        model.addAttribute("incidentesPorSeveridad", incidenteQueryService.contarIncidentesPorSeveridad());
        model.addAttribute("incidentesPorFecha", incidenteQueryService.contarIncidentesPorFecha());
        return "incidente-reportes"; // Vista para reportes
    
    }
}
