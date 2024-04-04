package psc5.DataDTO;

import java.io.Serializable;

public class ArticuloDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    protected String categoria;
    protected String descripcion;
    protected String nombre;
    protected double precio;
    protected String tamano;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getTamano() {
        return tamano;
    }
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

}
