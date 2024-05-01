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

import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.DataDomain.Categoria;
import psc5.deustoimperiomoda.dao.ArticuloRepository;

@RunWith(MockitoJUnitRunner.class)
public class ArticuloServiceTest {

    @Mock
    private ArticuloService articuloService;
    @Mock
    private ArticuloRepository articuloRepository;
    @Mock
    private Articulo articulo;
    @Mock
    private Articulo articulo1;
    
    @Before
    public void setUp() {
        articulo = new Articulo(Categoria.Ropa, "Descripcion", "Nombre", 100, "L");
        articulo.setId(1);
        articulo1 = new Articulo(Categoria.RopaDeportiva, "Descripcion", "Nombre", 100, "L");
        articulo.setId(2);
        this.articuloService = new ArticuloService(this.articuloRepository);
    }

    @Test
    public void testGetArticulo() {
        when(articuloRepository.findById(1)).thenReturn(articulo);
        Articulo articulo1 = articuloService.getArticulo(1);
        assertNotNull(articulo1);
    }

    @Test
    public void testGetByCategoria() {
        when(articuloService.getAllArticulos()).thenReturn(Arrays.asList(articulo, articulo1));
        List<Articulo> articulos = articuloService.getByCategoria(Categoria.Ropa);
        when(articuloService.getAllArticulos()).thenReturn(Arrays.asList(articulo, articulo1));
        articuloService.getByCategoria(Categoria.Accesorios);
        assertEquals(Categoria.Ropa, articulos.get(0).getCategoria());
    }

    @Test
    public void testGetAllArticulos() {
        when(articuloService.getAllArticulos()).thenReturn(Arrays.asList(articulo));
        List<Articulo> articulos = articuloService.getAllArticulos();
        assertNotNull(articulos);
    }

    @Test
    public void testAddArticulo() {
        Articulo articulo = new Articulo();
        when(articuloService.addArticulo(any(Articulo.class))).thenReturn(articulo);
        Articulo articulo2 = articuloService.addArticulo(articulo);
        assertNotNull(articulo2);
    }

    @Test
    public void testUpdateArticulo() {
        when(articuloRepository.findById(1)).thenReturn(articulo);
        Articulo articuloViejo = new Articulo();
        articuloViejo.setId(1);
        articuloViejo.setNombre("Camiseta");
        articuloService.updateArticulo(articuloViejo, 1);
        articuloService.updateArticulo(articuloViejo, 2);
        assertEquals("Camiseta", articuloViejo.getNombre());
    }

    @Test
    public void testDeleteArticulo() {
        when(articuloRepository.findById(1)).thenReturn(articulo);
        articuloService.deleteArticulo(1);
        when(articuloRepository.findById(1)).thenReturn(null);
        articuloService.deleteArticulo(1);
        assertNull(articuloService.getArticulo(1));
    }
}