package web2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web2.models.Client;
import web2.models.User;
import web2.services.ServicioClientes;
import web2.services.ServicioUsuarios;

import java.io.IOException;
import java.util.Locale;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private ServicioUsuarios servicioUsuarios;
    @Autowired
    private MessageSource messageSource;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping("/")
    public String index(Model model, Locale locale) {
        model.addAttribute("usuarios",servicioUsuarios.findAll());
        model.addAttribute("titulo",messageSource.getMessage("user_list",null,locale));

        return "user_list";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping("/crear/")
    public String formCrear(Model model, Locale locale) {
        model.addAttribute("titulo",messageSource.getMessage("form_crear_usuario",null,locale));

        model.addAttribute("permisos",servicioUsuarios.findAllAuthorities());

        return "form_usuario";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping("/editar/{username}")
    public String formEditar(@PathVariable String username,
                       Model model, Locale locale) {
        model.addAttribute("titulo",messageSource.getMessage("form_editar_usuario",null,locale));

        model.addAttribute("permisos",servicioUsuarios.findAllAuthorities());
        model.addAttribute("u",servicioUsuarios.findByUsername(username));

        return "form_usuario";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value = "/processForm/", method = RequestMethod.POST)
    public String processForm(@ModelAttribute User user,
                              Locale locale, RedirectAttributes redirectAttributes) {

        //TODO validar datos
        servicioUsuarios.guardar(user);

        //meter mensajes flash
        redirectAttributes.addFlashAttribute("mensaje","Se han reflejado los cambios.");
        return "redirect:/usuarios/";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping("/borrar/{username}")
    public String borrar(@PathVariable String username,
                          Model model, Locale locale, RedirectAttributes redirectAttributes) {

        servicioUsuarios.borrar(username);

        redirectAttributes.addFlashAttribute("mensaje","El usuario ha sido borrado.");
        return "redirect:/usuarios/";
    }
}
