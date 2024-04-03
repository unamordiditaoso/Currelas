package psc5.deustoimperiomoda.DataDomain;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    protected String contrasena;
    protected String dni;
    protected String nombre;
    protected String correo;
    protected List<Pedido> pedidos;

    public Cliente(String contrasena, String dni, String nombre, String correo, List<Pedido> pedidos) {
        this.contrasena = contrasena;
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.pedidos = new ArrayList<Pedido>();
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Cliente [contrasena=" + contrasena + ", dni=" + dni + ", nombre=" + nombre + ", correo=" + correo
                + ", pedidos=" + pedidos + "]";
    }

}
