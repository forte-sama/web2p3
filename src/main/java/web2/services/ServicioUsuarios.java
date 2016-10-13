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
import java.util.List;

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
        defaultAdmin.setPermiso("ADMIN");
        guardar(defaultAdmin);

        User defaultNormal = new User();
        defaultNormal.setUsername("normal");
        defaultNormal.setApellido("normal apellido");
        defaultNormal.setNombre("normal nombre");
        defaultNormal.setPassword("normal");
        defaultNormal.setPermiso("USUARIO_NORMAL");
        guardar(defaultNormal);

        System.out.println("Admin por defecto ha sido creado");
    }

    public Iterable<User> findAll() {
        return repoUsuarios.findAll();
    }

    public Iterable<String> findAllAuthorities() {
        return repoRoles.findDistinct();
    }

    public void guardar(User user) {
        repoUsuarios.save(user);

        //si el usuario tiene un permiso dentro, asignarlo
        if(user.getPermiso() != null) {
            List<Authority> roles = repoRoles.findByRolByUsername(user.getUsername());
            Authority nuevoRol2 = roles.size() > 0 ? roles.get(0) : new Authority();
            nuevoRol2.setUsername(user.getUsername());
            nuevoRol2.setAuthority(user.getPermiso());
            repoRoles.save(nuevoRol2);
        }
    }

    public User findByUsername(String username) {
        List<User> res = repoUsuarios.findByUsername(username);

        if(res.size() > 0)
            return res.get(0);
        else
            return null;
    }

    public void borrar(String username) {
        List<User> lista = repoUsuarios.findByUsername(username);

        if(lista.size() > 0) {
            repoUsuarios.delete(lista.get(0));
        }
    }
}
