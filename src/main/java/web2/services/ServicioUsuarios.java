package web2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web2.models.enums.Rol;
import web2.models.Usuario;
import web2.repositories.RepoUsuario;

import javax.annotation.PostConstruct;

@Service
public class ServicioUsuarios {
    @Autowired
    private RepoUsuario repoUsuarios;

    @PostConstruct
    public void init() {
        Usuario defaultAdmin = new Usuario();
        defaultAdmin.setCedula("admin");
        defaultAdmin.setEmail("admin");
        defaultAdmin.setRol(Rol.ADMIN);
        defaultAdmin.setApellido("admin apellido");
        defaultAdmin.setNombre("admin nombre");
        defaultAdmin.setPassword("admin");

        repoUsuarios.save(defaultAdmin);

        System.out.println("Admin por defecto ha sido creado");
    }
}
