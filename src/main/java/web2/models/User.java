package web2.models;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "users")
@Entity
public class User implements Serializable {
    @Id
    private String cedula;
    private Byte[] foto;
    private String nombre;
    private String apellido;
    @Column(unique = true)
    private String username;
    private String password;
    private Boolean enabled;

    public User() { enabled = true; }

    @Override
    public String toString() {
        return cedula + " : " + username;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
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
    public Byte[] getFoto() {
        return foto;
    }
    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}

