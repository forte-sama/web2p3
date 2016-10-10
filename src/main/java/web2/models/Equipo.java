package web2.models;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import web2.repositories.RepoSubGroups;

import javax.persistence.*;

/**
 * Created by forte on 10/10/16.
 */
@Table(name = "Equipos")
@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nombre;
    Integer cantidad;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sub_grupo_id")
    SubGrupo subGrupo;
    @Column(length = 5000000)
    Byte[] foto;

    public Equipo() { }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public SubGrupo getSubGrupo() {
        return subGrupo;
    }
    public void setSubGrupo(SubGrupo subGrupo) {
        this.subGrupo = subGrupo;
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
}
