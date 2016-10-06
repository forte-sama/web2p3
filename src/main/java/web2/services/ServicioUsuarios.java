package web2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web2.models.Authority;
import web2.models.User;
import web2.repositories.RepoAuthorities;
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
        defaultAdmin.setCedula("admin");
        defaultAdmin.setUsername("admin");
        defaultAdmin.setApellido("admin apellido");
        defaultAdmin.setNombre("admin nombre");
        defaultAdmin.setPassword("admin");
        repoUsuarios.save(defaultAdmin);

        Authority nuevoRol = new Authority();
        nuevoRol.setUsername(defaultAdmin.getUsername());
        nuevoRol.setAuthority("ADMIN");
        repoRoles.save(nuevoRol);

        User defaultAdmin2 = new User();
        defaultAdmin2.setCedula("otro");
        defaultAdmin2.setUsername("otro");
        defaultAdmin2.setApellido("otro apellido");
        defaultAdmin2.setNombre("otro nombre");
        defaultAdmin2.setPassword("otro");
        repoUsuarios.save(defaultAdmin2);

        Authority nuevoRol2 = new Authority();
        nuevoRol2.setUsername(defaultAdmin2.getUsername());
        nuevoRol2.setAuthority("OTRO");
        repoRoles.save(nuevoRol2);

        System.out.println("Admin por defecto ha sido creado");
    }
}
