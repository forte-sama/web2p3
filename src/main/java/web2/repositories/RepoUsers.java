package web2.repositories;

import org.springframework.data.repository.CrudRepository;
import web2.models.User;

import java.util.List;

public interface RepoUsers extends CrudRepository<User,String> {
    List<User> findByUsername(String username);
}
