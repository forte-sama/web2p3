package web2.repositories;

import org.springframework.data.repository.CrudRepository;
import web2.models.Client;

import java.util.List;

/**
 * Created by forte on 09/10/16.
 */
public interface RepoClients extends CrudRepository<Client,Long> {
    List<Client> findByCedula(String username);
}
