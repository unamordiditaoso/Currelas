package psc5.deustoimperiomoda.DataDomain;

public class Articulo {
    protected Categoria categoria;
    protected String descripcion;
    protected int idProducto;
    protected String nombre;
    protected double precio;
    protected String tamano;

    public Articulo(Categoria categoria, String descripcion, int idProducto, String nombre, double precio,
            String tamano) {
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.tamano = tamano;
    }

    public Articulo(Categoria categoria, int idProducto) {
        this.categoria = categoria;
        this.descripcion = "";
        this.idProducto = idProducto;
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

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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
        return "Articulo [categoria=" + categoria + ", descripcion=" + descripcion + ", idProducto=" + idProducto
                + ", nombre=" + nombre + ", precio=" + precio + ", tamano=" + tamano + "]";
    }  
    
}
