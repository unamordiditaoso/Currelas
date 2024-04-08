package psc5.deustoimperiomoda.DataDomain;

import java.util.ArrayList;
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
    long id;
    @ManyToOne
    protected Usuario usuario;
    protected Date fecha;
    protected List<Articulo> articulosComprados;

    public Pedido(Usuario usuario, Date fecha, List<Articulo> articulosComprados) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.articulosComprados = new ArrayList<Articulo>();
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

    public List<Articulo> getArticulosComprados() {
        return articulosComprados;
    }

    public void setArticulosComprados(List<Articulo> articulosComprados) {
        this.articulosComprados = articulosComprados;
    }

    @Override
    public String toString() {
        return "Pedido [usuario=" + usuario + ", fecha=" + fecha
                + ", articulosComprados=" + articulosComprados + "]";
    }

}
