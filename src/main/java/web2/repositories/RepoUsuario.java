package web2.repositories;

import org.springframework.data.repository.CrudRepository;
import web2.models.Usuario;

import java.util.List;

/**
 * Created by forte on 04/10/16.
 */
public interface RepoUsuario extends CrudRepository<Usuario,String> {
    List<Usuario> findByEmail(String email);
}
