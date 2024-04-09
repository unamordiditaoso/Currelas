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
    @GeneratedValue(strategy = GenerationType.TABLE)
    long ID_ped;
    @ManyToOne
    protected Usuario usuario;
    protected Date fecha;

    public Pedido(Usuario usuario, Date fecha, List<Articulo> articulosComprados) {
        this.usuario = usuario;
        this.fecha = fecha;
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

    @Override
    public String toString() {
        return "Pedido [usuario=" + usuario + ", fecha=" + fecha
                + "]";
    }

}
