package web2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import web2.models.Authority;
import web2.models.Client;
import web2.models.User;
import web2.repositories.RepoClients;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by forte on 09/10/16.
 */
@Service
public class ServicioClientes {
    @Autowired
    private RepoClients repoClients;

    @PostConstruct
    public void init() {
        Client c1 = new Client();
        c1.setDireccion("calle 7");
        c1.setCedula("402");
        c1.setApellido("rodriguez");
        c1.setNombre("alberto");
        repoClients.save(c1);
        Client c2 = new Client();
        c2.setDireccion("calle 11");
        c2.setCedula("228");
        c2.setApellido("garcia");
        c2.setNombre("cesar");
        repoClients.save(c2);
    }

    public Iterable<Client> findAll() {
        return repoClients.findAll();
    }

    public Client findById(long id) {
        return repoClients.findOne(id);
    }


    public void guardar(Client cliente) {
        repoClients.save(cliente);
    }

    public void borrar(int id) {
        Client found = repoClients.findOne((long)id);

        if(found != null) {
            repoClients.delete(found);
        }
    }
}
