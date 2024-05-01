package psc5.deustoimperiomoda.DataDomain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ArticuloTest {
    @Mock
    private Articulo articulo;

    @Before
    public void setUp() {
       articulo = new Articulo();
    }

    @Test
    public void testConstructor() {
        Categoria categoria = Categoria.Ropa;
        String descripcion = "Descripción";
        String nombre = "Nombre";
        double precio = 100;
        String tamano = "S";
        
        Articulo nuevoArticulo = new Articulo(categoria, descripcion, nombre, precio, tamano);
        assertNotNull(nuevoArticulo);
    }


    @Test
    public void testGetCategoria(){
        articulo.setCategoria(Categoria.Ropa);
        assertEquals(Categoria.Ropa, articulo.getCategoria());
    }

    @Test
    public void testGetNombre(){
        articulo.setNombre("Nombre");
        assertEquals("Nombre", articulo.getNombre());
    }

    @Test
    public void testGetDescripcion(){
        articulo.setDescripcion("Descripcion");
        assertEquals("Descripcion", articulo.getDescripcion());
    }

    @Test
    public void testGetPrecio(){
        articulo.setPrecio(100.0);
        assertEquals(100.0, articulo.getPrecio(), 0);
    }

    @Test
    public void testGetTamano(){
        articulo.setTamano("S");
        assertEquals("S", articulo.getTamano());
    }

    @Test
    public void testGetId(){
        articulo.setId(1);
        assertEquals(1, articulo.getId());
    }
    
    @Test
    public void testToString(){
        assertNotNull(articulo.toString());
    }
}