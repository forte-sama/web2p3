package web2.repositories;

import org.springframework.data.repository.CrudRepository;
import web2.models.Equipo;

/**
 * Created by forte on 10/10/16.
 */
public interface RepoEquipos extends CrudRepository<Equipo,Long> {
}
