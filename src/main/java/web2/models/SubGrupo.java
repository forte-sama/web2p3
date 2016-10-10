package web2.models;


import javax.persistence.*;
import java.io.Serializable;

@Table(name = "sub_grupos")
@Entity
public class SubGrupo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nombre;
    @ManyToOne(fetch = FetchType.EAGER)
    Grupo padre;

    public SubGrupo() { }

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
    public Grupo getPadre() {
        return padre;
    }
    public void setPadre(Grupo padre) {
        this.padre = padre;
    }

}
