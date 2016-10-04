package web2.models;


import web2.models.enums.Rol;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {
    @Id
    String cedula;
    Byte[] foto;
    String nombre;
    String apellido;
    @Column(unique = true)
    String email;
    String password;
    Rol rol;

    public Usuario() { }

    @Override
    public String toString() {
        return cedula + " : " + email;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}

