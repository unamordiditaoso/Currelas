package psc5.DataDTO;

import java.util.ArrayList;
import java.util.List;

import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.DataDomain.Categoria;

public class ArticuloAssembler {
    private static ArticuloAssembler instance;

    private ArticuloAssembler() { }

    public static ArticuloAssembler getInstance() {
        if(instance == null) {
            instance = new ArticuloAssembler();
        }
        return instance;
    }

    public ArticuloDTO articuloToDto(Articulo articulo) {
        ArticuloDTO dto = new ArticuloDTO();
        if(articulo.getCategoria() == Categoria.RopaDeportiva) {
            dto.setCategoria("RopaDeportiva");
        }else if(articulo.getCategoria() == Categoria.CalzadoDeportivo) {
            dto.setCategoria("Calzado");
        }else if(articulo.getCategoria() == Categoria.Calzado) {
            dto.setCategoria("Calzado");
        }else if(articulo.getCategoria() == Categoria.Ropa) {
            dto.setCategoria("Ropa");
        }else if(articulo.getCategoria() == Categoria.Accesorios) {
            dto.setCategoria("Accesorios");
        }else if(articulo.getCategoria() == Categoria.RopaInterior) {
            dto.setCategoria("RopaInterior");
        }
        dto.setDescripcion(articulo.getDescripcion());
        dto.setNombre(articulo.getNombre());
        dto.setPrecio(articulo.getPrecio());
        dto.setTamano(articulo.getTamano());
        return dto;
    }

    public List<ArticuloDTO> articuloToDto(List<Articulo> articulos) {
        List<ArticuloDTO> dtos = new ArrayList<>();

        for (Articulo articulo : articulos) {
            dtos.add(this.articuloToDto(articulo));
        }

        return dtos;

    }
}
