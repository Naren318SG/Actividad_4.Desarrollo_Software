/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registro.Tabla_Incidente.controller;

import com.registro.Tabla_Incidente.model.Incidente;
import com.registro.Tabla_Incidente.service.IncidenteService;
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
    private IncidenteService incidenteService;

    @GetMapping("/")
    public String listarIncidentes(Model model) {
        model.addAttribute("incidentes", incidenteService.listarTodas());
        return "incidente-list";
    }

   // @GetMapping("/")
    //public String mostrarPaginaInicio() {
      //  return "index";
    //}

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoIncidente(Model model) {
        model.addAttribute("incidente", new Incidente());
        return "incidente-form";
    }

    @PostMapping
    public String guardarIncidente(Incidente incidente) {
        incidenteService.guardar(incidente);
        return "redirect:/incidentes/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarIncidente(@PathVariable Long id, Model model) {
        model.addAttribute("incidente", incidenteService.obtenerPorId(id));
        return "incidente-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarIncidente(@PathVariable Long id) {
        incidenteService.eliminar(id);
        return "redirect:/incidentes/";
    }
}
