package web2.models;

import org.apache.tomcat.util.codec.binary.Base64;

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
    @Column(length = 5000000)
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
    private byte[] toPrimitives(Byte[] oBytes) {

        byte[] bytes = new byte[oBytes.length];
        for(int i = 0; i < oBytes.length; i++){
            bytes[i] = oBytes[i];
        }
        return bytes;

    }
    public String getFoto() {
        if(foto == null) return null;

        byte[] imgBytesAsBase64 = Base64.encodeBase64(toPrimitives(this.foto));
//        String imgAsBase64 = "data:image/png;base64," + imgDataAsBase64;
        return new String(imgBytesAsBase64);
    }
    public Byte[] getFotoCopy() {
        return foto;
    }
    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "'" + cedula + "': '" + nombre + "' '" + apellido + "'. '" + direccion + "'";
    }
}
