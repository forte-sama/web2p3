package web2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web2.models.AlquilerEquipo;
import web2.models.Equipo;
import web2.services.ServicioAlquilerEquipo;
import web2.services.ServicioEquipos;

import java.io.IOException;
import java.util.Collection;
import java.util.Locale;

@Controller
@RequestMapping("/alquiler")
public class AlquilerController {
    @Autowired
    private ServicioAlquilerEquipo servicioAlquiler;
    @Autowired
    private ServicioEquipos servicioEquipos;

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/")
    public String index(Model model, Locale locale) {

        return "basic";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/crear")
    public String formCrearAlquiler(Model model, Locale locale) {
        model.addAttribute("equipos",servicioEquipos.findAll());

        return "form_alquiler";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping(value = "/processAlquiler", method = RequestMethod.POST)
    public String processForm(@ModelAttribute AlquilerEquipo alquiler) {

        System.out.println(alquiler.getCliente() + " : " + alquiler.getFechaEntrega());

        return "redirect:/alquiler/";
    }
}
