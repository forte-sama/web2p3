package web2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web2.repositories.RepoAlquilerEquipo;

import javax.annotation.PostConstruct;

@Service
public class ServicioAlquilerEquipo {
    @Autowired
    private RepoAlquilerEquipo repoAlquiler;

    @PostConstruct
    public void init() { }


}
