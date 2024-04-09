package psc5.deustoimperiomoda.DataDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Envio")
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int ID_env;
    protected Usuario cliente;
    @OneToOne
    protected Pedido pedido;
    protected Estado estado;

    public Envio(Usuario cliente, Pedido pedido, Estado estado) {
        this.cliente = cliente;
        this.pedido = pedido;
        this.estado = estado;
    }

    public long getid() {
        return ID_env;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Envio [cliente=" + cliente + ", pedido=" + pedido
                + ", estado=" + estado + "]";
    }

    
}
