package psc5.deustoimperiomoda.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.DataDomain.Categoria;
import psc5.deustoimperiomoda.dao.ArticuloRepository;

@RunWith(MockitoJUnitRunner.class)
public class ArticuloServiceTest {

    @Mock
    private ArticuloService articuloService;
    @Mock
    private ArticuloRepository articuloRepository;

    @Before
    public void setUp() {
        // Configurar comportamiento predeterminado para los mocks
        articuloService = new ArticuloService(articuloRepository);
    }

    /*@Test
    public void testLoadDatosWithAssertNotNull() {
    Object data = articuloService.loadDatos();
    
    // Assert
    assertNotNull(data);
}*/

    @Test
    public void testGetArticuloWithAssertEquals() {
    Articulo articulo1 = new Articulo();
    when(articuloRepository.findById(any())).thenReturn(java.util.Optional.of(articulo1));
    Articulo articulo2 = articuloService.getArticulo(1);

    assertEquals(articulo1, articulo2);
}

    @Test
    public void testGetAllArticulos() {
        List<Articulo> articulos = articuloService.getAllArticulos();
        assertNotNull(articulos);
    }

    /*@Test
    public void testGetByCategoria() {
        Articulo articulo = new Articulo();
        articulo.setCategoria(Categoria.Calzado);
        List<Articulo> lista1 = List.of(articulo);
        List<Articulo> lista2 = articuloService.getByCategoria(Categoria.Calzado);
        // Assert
        assertEquals(lista1, lista2);
    }*/

    @Test
    public void testAddArticulo() {
    Articulo articulo = new Articulo();
    when(articuloService.addArticulo(any(Articulo.class))).thenReturn(articulo);
    Articulo articulo2 = articuloService.addArticulo(articulo);
    assertNotNull(articulo2);
    }

    @Test
    public void testUpdateArticulo() {
    Articulo articuloViejo = new Articulo();
    articuloViejo.setId(1);
    articuloViejo.setNombre("Camiseta");
    articuloService.updateArticulo(articuloViejo, 1);
    assertEquals("Camiseta", articuloViejo.getNombre());
    }

    @Test
    public void testDeleteArticulo() {
        Articulo articulo = new Articulo();
        articulo.setId(1);
        articuloService.deleteArticulo(1);
        assertNull(articuloService.getArticulo(1));
    }
}