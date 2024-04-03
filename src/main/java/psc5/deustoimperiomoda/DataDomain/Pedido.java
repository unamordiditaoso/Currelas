package psc5.deustoimperiomoda.DataDomain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private static int numeroPedido = 0;
    private int numeroPedidoActual;
    protected String dni;
    protected Date fecha;
    protected List<Articulo> articulosComprados;

    public Pedido(String dni, Date fecha, List<Articulo> articulosComprados) {
        numeroPedido++;
        this.numeroPedidoActual = numeroPedido;
        this.dni = dni;
        this.fecha = fecha;
        this.articulosComprados = new ArrayList<Articulo>();
    }

    public static int getNumeroPedido() {
        return numeroPedido;
    }

    public static void setNumeroPedido(int numeroPedido) {
        Pedido.numeroPedido = numeroPedido;
    }

    public int getNumeroPedidoActual() {
        return numeroPedidoActual;
    }

    public void setNumeroPedidoActual(int numeroPedidoActual) {
        this.numeroPedidoActual = numeroPedidoActual;
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
        return "Pedido [numeroPedidoActual=" + numeroPedidoActual + ", dni=" + dni + ", fecha=" + fecha
                + ", articulosComprados=" + articulosComprados + "]";
    }

}
