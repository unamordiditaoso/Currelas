package psc5.deustoimperiomoda.service;

import org.junit.jupiter.api.Test;

import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.dao.UsuarioRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class ArticuloServiceTest {

    ArticuloService articuloService = mock(ArticuloService.class);

    @Test
    void testLoadDatos() {
        // Arrange
        doNothing().when(articuloService).loadDatos();

        // Act
        articuloService.loadDatos();

        // Assert
        verify(articuloService, times(1)).loadDatos();
    }

    @Test
    public void testGetArticulo() {
        // Arrange
        Articulo expected = new Articulo();
        when(articuloService.getArticulo(anyInt())).thenReturn(expected);

        // Act
        Articulo actual = articuloService.getArticulo(1);

        // Assert
        assertEquals(expected, actual);
    }

    /*@Test
    void testGetByCategoria() {
        // Arrange
        List<Articulo> expected = new ArrayList<>();
        when(articuloService.getByCategoria(anyString())).thenReturn(expected);

        // Act
        List<Articulo> actual = articuloService.getByCategoria("categoria");

        // Assert
        assertEquals(expected, actual);
    }*/

    @Test
    public void testAddArticulo() {
        // Arrange
        Articulo articulo = new Articulo();
        when(articuloService.addArticulo(articulo)).thenReturn(articulo);

        // Act
        Articulo actual = articuloService.addArticulo(articulo);

        // Assert
        assertEquals(articulo, actual);
    }

    @Test
    public void testUpdateArticulo() {
        // Arrange
        Articulo articulo = new Articulo();
        when(articuloService.updateArticulo(articulo, null)).thenReturn(articulo);

        // Act
        Articulo actual = articuloService.updateArticulo(articulo, null);

        // Assert
        assertEquals(articulo, actual);
    }

    @Test
    public void testDeleteArticulo() {
        // Arrange
        doNothing().when(articuloService).deleteArticulo(anyInt());

        // Act
        articuloService.deleteArticulo(1);

        // Assert
        verify(articuloService, times(1)).deleteArticulo(1);
    }
}