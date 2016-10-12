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
        //crear nuevo alquiler para cada equipo
        for(Equipo equipo : alquiler.getEquipos()) {
            //crear nueva copia de alquiler con el equipo asignado
            AlquilerEquipo a = new AlquilerEquipo(alquiler,equipo);
            repoAlquiler.save(a);
            //reducir existencia
            equipo.setCantidad(equipo.getCantidad() - 1);
            servicioEquipos.guardar(equipo);
        }
    }

    public List<String> buscarEquiposNoExistencia(AlquilerEquipo alquiler) {
        List<String> res = new ArrayList<>();

        for(Equipo equipo : alquiler.getEquipos()) {
            if(equipo.getCantidad() <= 0) {
                res.add(equipo.getNombre());
            }
        }

        return res;
    }
}
