package web2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web2.models.AlquilerEquipo;
import web2.models.Equipo;
import web2.services.ServicioAlquilerEquipo;
import web2.services.ServicioEquipos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/alquiler")
public class AlquilerController {
    @Autowired
    private ServicioAlquilerEquipo servicioAlquiler;
    @Autowired
    private ServicioEquipos servicioEquipos;
    @Autowired
    private MessageSource messageSource;

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/")
    public String index(Model model, Locale locale) {

        return "redirect:/alquiler/crear";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/crear")
    public String formCrearAlquiler(@RequestParam(required = false,name = "error") String error,
                                    Model model, Locale locale) {
        model.addAttribute("equipos",servicioEquipos.findAll());

        return "form_alquiler";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping(value = "/devolucion", method = RequestMethod.POST)
    public String formDevolverEquipo(@ModelAttribute AlquilerEquipo alquiler,
                                     Model model, Locale locale,
                                     RedirectAttributes redirectAttributes) {

        Long alquiler_id = alquiler.getId();

        AlquilerEquipo found = servicioAlquiler.findById(alquiler_id);
        found.setDevuelto(true);
        found.setMontoPagado(found.getMontoHastaLaFecha());

        Equipo equipoFound = found.getEquipo();
        equipoFound.setCantidad(equipoFound.getCantidad() + 1);

        servicioEquipos.guardar(equipoFound);
        servicioAlquiler.guardar(found);

        redirectAttributes.addFlashAttribute("mensaje","El equipo fue devuelto exitosamente");
        return "redirect:/alquiler/pendientes";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/devolverform/{id}")
    public String formEditar(@PathVariable Long id,
                             Model model, Locale locale) {

        model.addAttribute("a",servicioAlquiler.findById(id));

        return "form_devolver_equipo";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/pendientes")
    public String equiposNoDevueltos(Model model, Locale locale) {
        model.addAttribute("alquileres",servicioAlquiler.equiposPendientes());
        model.addAttribute("titulo",messageSource.getMessage("alquiler_pendiente",null,locale));

        return "equipos_pendientes";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping(value = "/processAlquiler", method = RequestMethod.POST)
    public String processForm(@ModelAttribute AlquilerEquipo alquiler,
                              RedirectAttributes redirectAttributes) {

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
        List<String> equiposNoExistencia = servicioAlquiler.buscarEquiposNoExistencia(alquiler);
        boolean falloNoCantidad = equiposNoExistencia.size() > 0;

        if(falloNoFecha || falloNoCliente || falloNoCantidad) {
            //retornar al mismo formulario pero con error
            if (falloNoFecha) {
                redirectAttributes.addFlashAttribute("errorfecha", "No se puede fecha de entrega anterior a hoy");
            }
            if(falloNoCliente) {
                redirectAttributes.addFlashAttribute("errorcliente", "El cliente indicado no se encuentra");
            }
            if(falloNoCantidad) {
                List<String> mensajes = new ArrayList<>();
                for(String equipo : equiposNoExistencia) {
                    mensajes.add("No hay mas ejemplares de: " + equipo);
                }

                redirectAttributes.addFlashAttribute("errorcantidad",mensajes);
            }
            return "redirect:/alquiler/pendientes";
        }

        try {
            SimpleDateFormat df = new SimpleDateFormat("dd MMMM, yyyy");
            alquiler.setFechaRealizacion(df.format(new Date()));
        } catch (Exception e) {
            System.out.println("Ocurrio un error con la fecha de realizacion");
        }

        servicioAlquiler.guardar(alquiler);

        redirectAttributes.addFlashAttribute("mensaje","Se ha alquilado un nuevo equipo");
        return "redirect:/alquiler/pendientes";
    }

}
