package psc5.deustoimperiomoda.DataDomain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    long id;
    protected String dni;
    protected Date fecha;
    protected List<Articulo> articulosComprados;

    public Pedido(String dni, Date fecha, List<Articulo> articulosComprados) {
        this.dni = dni;
        this.fecha = fecha;
        this.articulosComprados = new ArrayList<Articulo>();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
        return "Pedido [dni=" + dni + ", fecha=" + fecha
                + ", articulosComprados=" + articulosComprados + "]";
    }

}
