package web2.models;

import org.springframework.beans.factory.annotation.Autowired;
import web2.repositories.RepoAuthorities;
import web2.services.ServicioUsuarios;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "users")
@Entity
public class User implements Serializable {
    @Id
    private String username;
    private String nombre;
    private String apellido;
    private String password;
    private Boolean enabled;
    @Transient
    private String permiso;

    public User() { enabled = true; }

    @Override
    public String toString() {
        return username + " : " + nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public String getPermiso() {
        return permiso;
    }
    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

}

