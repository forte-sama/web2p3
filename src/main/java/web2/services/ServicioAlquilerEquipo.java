package web2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web2.models.AlquilerEquipo;
import web2.models.Equipo;
import web2.repositories.RepoAlquilerEquipo;

import javax.annotation.PostConstruct;

@Service
public class ServicioAlquilerEquipo {
    @Autowired
    private RepoAlquilerEquipo repoAlquiler;
    @Autowired
    private ServicioEquipos servicioEquipos;

    @PostConstruct
    public void init() { }

    public void guardar(AlquilerEquipo alquiler) {
        repoAlquiler.save(alquiler);

        Equipo equipoAlquilado = alquiler.getEquipo();
        equipoAlquilado.setCantidad(equipoAlquilado.getCantidad() - alquiler.getCantidad());
        servicioEquipos.guardar(equipoAlquilado);
    }
}
