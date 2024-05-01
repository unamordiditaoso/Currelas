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
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class EnvioTest {
    @Mock
    private Envio envio;

    @Rule public ContiPerfRule rule = new ContiPerfRule();

    @Before
    public void setUp() {
       envio = new Envio();
    }

    @Test
    @PerfTest(invocations = 1000, threads = 20)
    @Required(max = 120, average = 30)
    public void testConstructor() {
        Usuario usuario = new Usuario();
        Pedido pedido = new Pedido();
        Estado estado = Estado.Preparacion;
        
        Envio nuevoEnvio = new Envio(usuario, pedido, estado);
        assertNotNull(nuevoEnvio);
    }


    @Test
    public void testGetUsuario(){
        envio.setCliente(new Usuario());
        assertNotNull(envio.getCliente());
    }

    @Test
    public void testGetPedido(){
        envio.setPedido(new Pedido());
        assertNotNull(envio.getPedido());
    }

    @Test
    public void testGetEstado(){
        envio.setEstado(Estado.Recibido);
        assertEquals(Estado.Recibido, envio.getEstado());
    }

    @Test
    public void testGetId(){
        envio.setId(1);
        assertEquals(1, envio.getId());
    }
    
    @Test
    public void testToString(){
        assertNotNull(envio.toString());
    }
}
