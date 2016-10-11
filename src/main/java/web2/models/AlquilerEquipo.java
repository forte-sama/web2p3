package web2.models;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by forte on 10/10/16.
 */
@Table(name = "AlquilerEquipos")
@Entity
public class AlquilerEquipo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String fechaRealizacion;
    @ManyToOne
    Client cliente;
    String fechaEntrega;
    @ManyToOne
    Equipo equipo;
    Integer cantidad;

    public AlquilerEquipo() { }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFechaRealizacion() {
        return fechaRealizacion;
    }
    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }
    public Client getCliente() {
        return cliente;
    }
    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }
    public String getFechaEntrega() {
        return fechaEntrega;
    }
    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    public Equipo getEquipo() {
        return equipo;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


}
