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
        // Configurar comportamiento predeterminado para los mocks
       pedido = new Pedido();
    }

 

    // Repite el mismo proceso para probar los otros getters y setters...

    @Test
    public void testConstructor() {
        Usuario usuario = new Usuario();
        Date fecha = new Date();
        
        // Crear un nuevo objeto Articulo utilizando el constructor
        Pedido nuevoPedido = new Pedido(usuario, fecha, new ArrayList<>());
    }


    @Test
    public void testGetUsuario(){
        pedido.setUsuario(new Usuario());
        assertNotNull(pedido.getUsuario());
    }

    @Test
    public void testGetFecha(){
        pedido.setFecha(new Date());
        assertNotNull(pedido.getFecha());
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
