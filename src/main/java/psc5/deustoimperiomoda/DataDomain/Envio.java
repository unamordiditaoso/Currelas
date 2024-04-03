package psc5.deustoimperiomoda.DataDomain;

public class Envio {
    private static int numeroEnvio = 0;
    private int numeroEnvioActual;
    protected Cliente cliente;
    protected Pedido pedido;
    protected Estado estado;

    public Envio(int numeroEnvioActual, Cliente cliente, Pedido pedido, Estado estado) {
        numeroEnvio++;
        this.numeroEnvioActual = numeroEnvio;
        this.cliente = cliente;
        this.pedido = pedido;
        this.estado = estado;
    }

    public static int getNumeroEnvio() {
        return numeroEnvio;
    }

    public static void setNumeroEnvio(int numeroEnvio) {
        Envio.numeroEnvio = numeroEnvio;
    }

    public int getNumeroEnvioActual() {
        return numeroEnvioActual;
    }

    public void setNumeroEnvioActual(int numeroEnvioActual) {
        this.numeroEnvioActual = numeroEnvioActual;
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
        return "Envio [numeroEnvioActual=" + numeroEnvioActual + ", cliente=" + cliente + ", pedido=" + pedido
                + ", estado=" + estado + "]";
    }

    
}
