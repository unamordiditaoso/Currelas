package psc5.deustoimperiomoda.DataDomain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EnvioTest {
    @Mock
    private Envio envio;

    @Before
    public void setUp() {
        // Configurar comportamiento predeterminado para los mocks
       envio = new Envio();
    }

 

    // Repite el mismo proceso para probar los otros getters y setters...

    @Test
    public void testConstructor() {
        Usuario usuario = new Usuario();
        Pedido pedido = new Pedido();
        Estado estado = Estado.Preparacion;
        
        // Crear un nuevo objeto Articulo utilizando el constructor
        Envio nuevoEnvio = new Envio(usuario, pedido, estado);
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
