package psc5.deustoimperiomoda.DataDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Envio")
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    long id;
    protected Cliente cliente;
    protected Pedido pedido;
    protected Estado estado;

    public Envio(Cliente cliente, Pedido pedido, Estado estado) {
        this.cliente = cliente;
        this.pedido = pedido;
        this.estado = estado;
    }

    public long getid() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
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
