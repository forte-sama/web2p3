package web2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web2.models.Client;
import web2.models.Equipo;
import web2.models.Grupo;
import web2.models.SubGrupo;
import web2.services.ServicioClientes;
import web2.services.ServicioEquipos;

import java.io.IOException;
import java.util.Locale;

@Controller
@RequestMapping("/equipos")
public class EquiposController {
    @Autowired
    private ServicioEquipos servicioEquipos;
    @Autowired
    private MessageSource messageSource;

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/")
    public String index(Model model, Locale locale) {
        model.addAttribute("equipos",servicioEquipos.findAll());
        model.addAttribute("titulo",messageSource.getMessage("equipo_list",null,locale));

        return "equipo_list";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/crear")
    public String formEquipo(Model model, Locale locale) {
        model.addAttribute("subgrupos",servicioEquipos.findAllSubGrupos());

        return "form_equipo";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/editar/{id}")
    public String formEditar(@PathVariable Long id,
                             Model model, Locale locale) {

        model.addAttribute("subgrupos",servicioEquipos.findAllSubGrupos());
        model.addAttribute("equipo",servicioEquipos.findById(id));

        return "form_equipo";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping(value = "/processEquipo/", method = RequestMethod.POST)
    public String processForm(@RequestParam("fotox") MultipartFile file, @ModelAttribute Equipo equipo) {

        //setear foto si se ha subido un archivo, independiente de edicion/creacion
        try {
            equipo.setFoto(procesar(file.getBytes()));
        } catch (IOException e) {
            System.out.println("Hubo un error subiendo foto");
        } catch (NullPointerException e) {
            System.out.println("Foto es nulo");
        }

        //para que la foto no se borre en caso de actualizar cliente y no se suba foto
        if(equipo.getId() != null && file.isEmpty()) {
            Equipo found = servicioEquipos.findById(equipo.getId());
            equipo.setFoto(found.getFotoCopy());
        }

        servicioEquipos.guardar(equipo);

        return "redirect:/equipos/";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/crear_grupo")
    public String formGrupo(Model model, Locale locale) {
        return "form_grupo";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/crear_subgrupo")
    public String formSubGrupo(Model model, Locale locale) {
        model.addAttribute("grupos",servicioEquipos.findAllGrupos());

        return "form_subgrupo";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping(value = "/processGrupo/", method = RequestMethod.POST)
    public String formGrupoPost(@ModelAttribute Grupo grupo) {
        servicioEquipos.crearGrupo(grupo);

        return "redirect:/equipos/";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping(value = "/processSubGrupo/", method = RequestMethod.POST)
    public String formSubGrupoPost(@ModelAttribute SubGrupo subgrupo) {
        servicioEquipos.crearSubGrupo(subgrupo);

        return "redirect:/equipos/";
    }

    private Byte[] procesar(byte[] bytesPrim) {
        Byte[] bytes = new Byte[bytesPrim.length];

        int i = 0;
        for (byte b : bytesPrim) bytes[i++] = b; // Autoboxing

        return bytes;
    }
}
