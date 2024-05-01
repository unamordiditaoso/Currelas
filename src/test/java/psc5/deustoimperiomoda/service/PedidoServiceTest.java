package psc5.deustoimperiomoda.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import psc5.deustoimperiomoda.DataDomain.Estado;
import psc5.deustoimperiomoda.DataDomain.Pedido;
import psc5.deustoimperiomoda.DataDomain.TipoUsuario;
import psc5.deustoimperiomoda.DataDomain.Usuario;
import psc5.deustoimperiomoda.dao.PedidoRepository;

@RunWith(MockitoJUnitRunner.class)
public class PedidoServiceTest {

    @Mock
    private PedidoService pedidoService;
    @Mock
    private PedidoRepository pedidoRepository;
    @Mock
    private ArticuloService articuloService;
    @Mock
    private Pedido pedido;
    @Mock
    private Pedido pedido1;
    @Mock
    private Usuario usuario;
    
    @Before
    public void setUp() {
        pedido = new Pedido(new Usuario(), Estado.Preparacion);
        pedido.setId(1);
        usuario = new Usuario("contr", "dni", "nombre", "correo", null, TipoUsuario.Administrador);
        pedido1 = new Pedido(usuario, Estado.Recibido);
        pedido1.setId(2);
        this.pedidoService = new PedidoService(this.pedidoRepository, this.articuloService);
    }

    @Test
    public void testGetArticulo() {
        when(pedidoRepository.findById(1)).thenReturn(pedido);
        Pedido ped = pedidoRepository.findById(1);
        assertNotNull(ped);
    }

    @Test
    public void testGetAllArticulos() {
        when(pedidoService.getAllPedidos()).thenReturn(Arrays.asList(pedido, pedido1));
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        assertNotNull(pedidos);
    }

    @Test
    public void testAddArticulo() {
        when(pedidoService.addPedido(any(Pedido.class))).thenReturn(pedido);
        Pedido ped = pedidoService.addPedido(pedido);
        assertNotNull(ped);
    }
}