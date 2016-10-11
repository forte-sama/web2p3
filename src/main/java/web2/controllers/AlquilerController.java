package web2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.dao.SystemWideSaltSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web2.models.AlquilerEquipo;
import web2.models.Equipo;
import web2.services.ServicioAlquilerEquipo;
import web2.services.ServicioEquipos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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
    public String formCrearAlquiler(@RequestParam(required = false,name = "error") String error,
                                        Model model, Locale locale) {
        model.addAttribute("equipos",servicioEquipos.findAll());

        return "form_alquiler";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping(value = "/processAlquiler", method = RequestMethod.POST)
    public String processForm(@ModelAttribute AlquilerEquipo alquiler, RedirectAttributes redirectAttributes) {

        //validar que el cliente existe
        boolean falloNoCliente = alquiler.getCliente() == null;
        //validar que la fecha es posterior
        boolean falloNoFecha;
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd MMMM, yyyy");
            Date parsedDate = df.parse(alquiler.getFechaEntrega());
            falloNoFecha = new Date().after(parsedDate);

        } catch (ParseException exp) {
            falloNoFecha = true;
        }
        //validar que hay existencia
        boolean falloNoCantidad = alquiler.getEquipo().getCantidad() < alquiler.getCantidad();

        if(falloNoFecha || falloNoCliente || falloNoCantidad) {
            //retornar al mismo formulario pero con error
            if(falloNoFecha)
                redirectAttributes.addFlashAttribute("errorfecha", "No se puede fecha de entrega anterior a hoy");
            if(falloNoCliente)
                redirectAttributes.addFlashAttribute("errorcliente", "El cliente indicado no se encuentra");
            if(falloNoCantidad)
                redirectAttributes.addFlashAttribute("errorcantidad", "No hay tantas unidades disponibles");

            return "redirect:/alquiler/crear";
        }

        try {
            SimpleDateFormat df = new SimpleDateFormat("dd MMMM, yyyy");
            alquiler.setFechaRealizacion(df.format(new Date()));
        } catch (Exception e) {
            System.out.println("Ocurrio un error con la fecha de realizacion");
        }

//        servicioAlquiler.guardar(alquiler);

        return "redirect:/alquiler/";
    }

}
