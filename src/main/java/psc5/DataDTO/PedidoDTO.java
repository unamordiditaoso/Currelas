package psc5.DataDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PedidoDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    protected String dni;
    protected Date fecha;
    protected List<String> articulosComprados;

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
    public List<String> getArticulosComprados() {
        return articulosComprados;
    }
    public void setArticulosComprados(List<String> articulosComprados) {
        this.articulosComprados = articulosComprados;
    }

}
