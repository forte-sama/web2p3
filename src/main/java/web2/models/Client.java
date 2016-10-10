package web2.models;

import com.sun.tracing.dtrace.ProviderAttributes;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by forte on 09/10/16.
 */
@Table(name = "Clients")
@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(unique = true)
    String cedula;
    String nombre;
    String apellido;
    String direccion;
    Byte[] foto;

    public Client() { }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Byte[] getFoto() {
        return foto;
    }
    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }

}
