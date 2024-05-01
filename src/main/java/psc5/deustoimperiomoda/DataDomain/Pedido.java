package psc5.deustoimperiomoda.DataDomain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Table(name = "Pedido")
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int ID_ped;
    @ManyToOne
    protected Usuario usuario;
    protected Date fecha;
    protected Estado estado;

    public Pedido(Usuario usuario, Date fecha, List<Articulo> articulosComprados, Estado estado) {
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public Pedido() {
        this.usuario = new Usuario();
        this.fecha = new Date();
    }

    public long getId() {
        return ID_ped;
    }

    public void setId(Integer id) {
        this.ID_ped = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido [usuario=" + usuario + ", fecha=" + fecha
                + "]";
    }

}
