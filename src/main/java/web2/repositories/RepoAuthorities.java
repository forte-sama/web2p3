package web2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import web2.models.Authority;
import web2.models.User;

import java.util.List;

public interface RepoAuthorities extends CrudRepository<Authority,Long> {

    @Query("select a from Authority a,User u where u.username=?1 and a.username=u.username")
    public List<Authority> findByRolByUsername(String username);

    @Query("select distinct(a.authority) from Authority a")
    public List<String> findDistinct();
}
