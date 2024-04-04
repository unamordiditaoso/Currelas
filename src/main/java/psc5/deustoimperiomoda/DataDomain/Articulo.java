package psc5.deustoimperiomoda.DataDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Articulo")
public class Articulo {
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    long id;
    protected Categoria categoria;
    protected String descripcion;
    protected String nombre;
    protected double precio;
    protected String tamano;

    public Articulo(Categoria categoria, String descripcion, String nombre, double precio,
            String tamano) {
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
        this.tamano = tamano;
    }

    public Articulo(Categoria categoria) {
        this.categoria = categoria;
        this.descripcion = "";
        this.nombre = "";
        this.precio = 0;
        this.tamano = "";
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getid() {
        return id;
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

    @Override
    public String toString() {
        return "Articulo [categoria=" + categoria + ", descripcion=" + descripcion
                + ", nombre=" + nombre + ", precio=" + precio + ", tamano=" + tamano + "]";
    }  
    
}
