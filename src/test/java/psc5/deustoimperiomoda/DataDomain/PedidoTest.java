package psc5.deustoimperiomoda.DataDomain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class PedidoTest {

    private Pedido pedido;

    @Rule public ContiPerfRule rule = new ContiPerfRule();

    @Before
    public void setUp() {
       pedido = new Pedido();
    }

    @Test
    @PerfTest(invocations = 1000, threads = 20)
    @Required(max = 120, average = 30)
    public void testConstructor() {
        Usuario usuario = new Usuario();
        
        Pedido nuevoPedido = new Pedido(usuario, Estado.Preparacion);
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
