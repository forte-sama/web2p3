package web2.repositories;

import org.springframework.data.repository.CrudRepository;
import web2.models.Grupo;
import web2.models.SubGrupo;

public interface RepoSubGroups extends CrudRepository<SubGrupo,Long> {
    
}
