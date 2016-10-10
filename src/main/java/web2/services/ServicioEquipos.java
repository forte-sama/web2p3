package web2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web2.models.Equipo;
import web2.models.Grupo;
import web2.models.SubGrupo;
import web2.repositories.RepoEquipos;
import web2.repositories.RepoGroups;
import web2.repositories.RepoSubGroups;

import javax.annotation.PostConstruct;

@Service
public class ServicioEquipos {
    @Autowired
    private RepoGroups repoGrupos;
    @Autowired
    private RepoSubGroups repoSubGrupos;
    @Autowired
    private RepoEquipos repoEquipos;

    @PostConstruct
    public void init() { }

    public Iterable<Equipo> findAll() {
        return repoEquipos.findAll();
    }

    public void crearGrupo(Grupo grupo) {
        repoGrupos.save(grupo);
    }

    public void crearSubGrupo(SubGrupo sgrupo) {
        repoSubGrupos.save(sgrupo);
    }

    public Iterable<SubGrupo> findAllSubGrupos() {
        return repoSubGrupos.findAll();
    }

    public Iterable<Grupo> findAllGrupos() {
        return repoGrupos.findAll();
    }

    public Equipo findById(Long id) {
        return repoEquipos.findOne(id);
    }

    public void guardar(Equipo equipo) {
        repoEquipos.save(equipo);
    }

    public void borrar(long id) {
        Equipo found = repoEquipos.findOne(id);

        if (found != null) {
            repoEquipos.delete(found);
        }
    }
}
