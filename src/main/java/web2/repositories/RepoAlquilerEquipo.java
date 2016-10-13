package web2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import web2.models.AlquilerEquipo;

import java.util.List;

/**
 * Created by forte on 10/10/16.
 */
public interface RepoAlquilerEquipo extends CrudRepository<AlquilerEquipo,Long> {

    @Query("select ae from AlquilerEquipo ae where ae.devuelto=false order by ae.id asc")
    public List<AlquilerEquipo> findEquiposPendientes();
}
