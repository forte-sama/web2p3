package web2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import web2.models.Authority;

import java.util.List;

public interface RepoAuthorities extends CrudRepository<Authority,Long> {

    @Query("select a.authority from Authority a,User u where u.username=?1 and a.username=u.username")
    public List<String> findByRolByUsername(String username);
}
