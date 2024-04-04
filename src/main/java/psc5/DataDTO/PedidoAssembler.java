package psc5.DataDTO;

import java.util.ArrayList;
import java.util.List;

import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.DataDomain.Pedido;

public class PedidoAssembler {
    private static PedidoAssembler instance;

    private PedidoAssembler() { }
    
    public static PedidoAssembler getInstance() {
        if(instance == null) {
            instance = new PedidoAssembler();
        }
        return instance;
    }

    public PedidoDTO pedidoToDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        List<String> articulos = new ArrayList<>();

        dto.setDni(pedido.getDni());
        dto.setFecha(pedido.getFecha());
        for (Articulo articulo : pedido.getArticulosComprados()) {
           articulos.add(articulo.toString());
        }
        dto.setArticulosComprados(articulos);
        return dto;
    }

    public List<PedidoDTO> pedidoToDTO(List<Pedido> pedidos) {
        List<PedidoDTO> pedidoDTOs = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            pedidoDTOs.add(this.pedidoToDTO(pedido));
        }

        return pedidoDTOs;
    }
}
