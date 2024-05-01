package psc5.deustoimperiomoda.DataDomain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ArticulosCompradosTest {
    @Mock
    private ArticulosComprados articulosComprados;

    @Before
    public void setUp() {
        // Configurar comportamiento predeterminado para los mocks
       articulosComprados = new ArticulosComprados();
    }

 

    // Repite el mismo proceso para probar los otros getters y setters...

    @Test
    public void testConstructor() {
        Articulo articulo = new Articulo();
        Pedido pedido = new Pedido();
        Integer cantidad = 2;
        
        // Crear un nuevo objeto Articulo utilizando el constructor
        ArticulosComprados nuevoArticulosComprados = new ArticulosComprados(articulo, pedido, cantidad);
        assertNotNull(nuevoArticulosComprados);
    }


    @Test
    public void testGetArticulo(){
        articulosComprados.setArticulo(new Articulo());
        assertNotNull(articulosComprados.getArticulo());
    }

    @Test
    public void testGetPedido(){
        articulosComprados.setPedido(new Pedido());
        assertNotNull(articulosComprados.getPedido());
    }

    @Test
    public void testGetCantidad(){
        articulosComprados.setCantidad(2);
        assertEquals(2, articulosComprados.getCantidad());
    }
    
    @Test
    public void testGetId(){
        articulosComprados.setId(1);
        assertEquals(1, articulosComprados.getId());
    }

    @Test
    public void testToString(){
        assertNotNull(articulosComprados.toString());
    }
}