package psc5.deustoimperiomoda.DataDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "articulosComprados")
public class ArticulosComprados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Articulo")
    private Articulo articulo;

    @ManyToOne
    @JoinColumn(name = "Pedido")
    private Pedido pedido;

    private int cantidad;

    public ArticulosComprados() {
    }

    public ArticulosComprados(Articulo articulo, Pedido pedido, int cantidad) {
        this.articulo = articulo;
        this.pedido = pedido;
        this.cantidad = cantidad;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}


