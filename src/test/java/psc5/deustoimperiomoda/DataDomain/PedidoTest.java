package psc5.deustoimperiomoda.DataDomain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PedidoTest {
    @Mock
    private Pedido pedido;

    @Before
    public void setUp() {
       pedido = new Pedido();
    }

    @Test
    public void testConstructor() {
        Usuario usuario = new Usuario();
        Date fecha = new Date();
        
        Pedido nuevoPedido = new Pedido(usuario, new ArrayList<>(), Estado.Preparacion);
        assertNotNull(nuevoPedido);
    }


    @Test
    public void testGetUsuario(){
        pedido.setUsuario(new Usuario());
        assertNotNull(pedido.getUsuario());
    }

    @Test
    public void testGetId(){
        pedido.setId(1);
        assertEquals(1, pedido.getId());
    }
    
    @Test
    public void testToString(){
        assertNotNull(pedido.toString());
    }
}
