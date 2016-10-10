package web2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web2.models.Authority;
import web2.models.Client;
import web2.models.User;
import web2.repositories.RepoAuthorities;
import web2.repositories.RepoClients;
import web2.repositories.RepoUsers;

import javax.annotation.PostConstruct;

@Service
public class ServicioUsuarios {
    @Autowired
    private RepoUsers repoUsuarios;
    @Autowired
    private RepoAuthorities repoRoles;

    @PostConstruct
    public void init() {
        User defaultAdmin = new User();
        defaultAdmin.setUsername("admin");
        defaultAdmin.setApellido("admin apellido");
        defaultAdmin.setNombre("admin nombre");
        defaultAdmin.setPassword("admin");
        repoUsuarios.save(defaultAdmin);

        Authority nuevoRol = new Authority();
        nuevoRol.setUsername(defaultAdmin.getUsername());
        nuevoRol.setAuthority("ADMIN");
        repoRoles.save(nuevoRol);

        System.out.println("Admin por defecto ha sido creado");
    }
}
