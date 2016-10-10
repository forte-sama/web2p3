package web2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web2.models.Client;
import web2.services.ServicioClientes;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ServicioClientes servicioClientes;

    @Autowired
    private MessageSource messageSource;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping("/")
    public String index(Model model, Locale locale) {
        model.addAttribute("clientes",servicioClientes.findAll());
        return "client_list";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping("/editar/{id}")
    public String form(@PathVariable int id,
                          Model model, Locale locale) {

        System.out.println(id);

        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String formPost(@ModelAttribute Client cliente) {

        return "redirect:/";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/borrar/{id}")
    public String borrar(@PathVariable int id,
                          Model model, Locale locale) {

        servicioClientes.borrar(id);

        return "redirect:/clientes/";
    }
}
