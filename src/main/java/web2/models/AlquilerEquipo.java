package web2.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

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
    @ManyToOne(fetch = FetchType.EAGER)
    Equipo equipo;
    Boolean devuelto;
    Double montoPagado;
    @Transient
    Set<Equipo> equipos;

    public AlquilerEquipo() { devuelto = false; }

    public AlquilerEquipo(AlquilerEquipo a,Equipo e) {
        this.fechaRealizacion = a.getFechaRealizacion();
        this.fechaEntrega     = a.getFechaEntrega();
        this.devuelto         = false;
        this.cliente          = a.getCliente();
        this.equipo           = e;
    }

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
    public Set<Equipo> getEquipos() {
        return equipos;
    }
    public void setEquipos(Set<Equipo> equipos) {
        this.equipos = equipos;
    }
    public Equipo getEquipo() {
        return equipo;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    public Boolean getDevuelto() {
        return devuelto;
    }
    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }
    public Double getMontoPagado() {
        return montoPagado;
    }
    public void setMontoPagado(Double montoPagado) {
        this.montoPagado = montoPagado;
    }
    public Double getMontoHastaLaFecha() {
        //obtener string de fechas
        //parsear fechas para construir dates
        LocalDate inicio = LocalDate.parse(this.fechaRealizacion, DateTimeFormatter.ofPattern("dd MMMM, yyyy"));
        LocalDate fin = LocalDate.parse(this.fechaEntrega, DateTimeFormatter.ofPattern("dd MMMM, yyyy"));
        LocalDate target = LocalDate.now();

        long cant_dias = Math.max(1,ChronoUnit.DAYS.between(inicio,fin));
        return cant_dias * this.equipo.getPrecio();
    }

}
