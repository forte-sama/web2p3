package web2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web2.models.Client;
import web2.services.ServicioClientes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ServicioClientes servicioClientes;

    @Autowired
    private MessageSource messageSource;

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/")
    public String index(Model model, Locale locale) {
        model.addAttribute("clientes",servicioClientes.findAll());

        return "client_list";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/crear/")
    public String formCrear(Model model, Locale locale) {

        return "form_cliente";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/editar/{id}")
    public String formEditar(@PathVariable int id,
                       Model model, Locale locale) {

        model.addAttribute("cliente",servicioClientes.findById(id));

        return "form_cliente";
    }

    @RequestMapping(value = "/processForm/", method = RequestMethod.POST)
    public String processForm(@RequestParam("fotox") MultipartFile file, @ModelAttribute Client cliente) {

        //setear foto si se ha subido un archivo, independiente de edicion/creacion
        try {
            cliente.setFoto(procesar(file.getBytes()));
        } catch (IOException e) {
            System.out.println("Hubo un error subiendo foto");
        } catch (NullPointerException e) {
            System.out.println("Foto es nulo");
        }

        //para que la foto no se borre en caso de actualizar cliente y no se suba foto
        if(cliente.getId() != null && file.isEmpty()) {
            Client found = servicioClientes.findById(cliente.getId());
            cliente.setFoto(found.getFotoCopy());
        }

        servicioClientes.guardar(cliente);

        return "redirect:/clientes/";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/borrar/{id}")
    public String borrar(@PathVariable int id,
                          Model model, Locale locale) {

        servicioClientes.borrar(id);

        return "redirect:/clientes/";
    }

    private Byte[] procesar(byte[] bytesPrim) {
        Byte[] bytes = new Byte[bytesPrim.length];

        int i = 0;
        for (byte b : bytesPrim) bytes[i++] = b; // Autoboxing

        return bytes;
    }
}
