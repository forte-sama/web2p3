package web2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web2.models.AlquilerEquipo;
import web2.models.Equipo;
import web2.repositories.RepoAlquilerEquipo;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

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

//        Equipo equipoAlquilado = alquiler.getEquipos();
//        equipoAlquilado.setCantidad(equipoAlquilado.getCantidad() - alquiler.getCantidad());
//        servicioEquipos.guardar(equipoAlquilado);
    }

    public List<String> buscarEquiposNoExistencia(AlquilerEquipo alquiler) {
        List<String> res = new ArrayList<>();



        return res;
    }
}
