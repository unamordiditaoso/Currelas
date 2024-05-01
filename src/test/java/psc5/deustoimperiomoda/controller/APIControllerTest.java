package psc5.deustoimperiomoda.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.DataDomain.TipoUsuario;
import psc5.deustoimperiomoda.DataDomain.Usuario;
import psc5.deustoimperiomoda.dao.ArticuloRepository;
import psc5.deustoimperiomoda.service.ArticuloService;
import psc5.deustoimperiomoda.service.UsuarioService;


@RunWith(MockitoJUnitRunner.class)
public class APIControllerTest {

    @Mock
    private ArticuloService articuloService;
    @Mock
    private UsuarioService usuarioService;
    
    @InjectMocks
    private APIController apiController;


    @BeforeEach
    public void setUp() {
        apiController = new APIController(articuloService, usuarioService);
    }

    @Test
    public void testGetArticulos() {
        apiController.getArticulos();
        verify(articuloService).getAllArticulos();
    }

    @Test
    public void testGetUsuarios() {
        apiController.getUsuarios();
        verify(usuarioService).getAllUsuarios();
    }

     
    @Test
    public void testValidarContrasena() {
        Usuario usuario = new Usuario();
        usuario.setContrasena("contrasena");

        when(usuarioService.getUsuario("dni")).thenReturn(usuario);

        String resultado = apiController.validarContrasena("dni", "contrasena");

        verify(usuarioService, times(3)).getUsuario("dni");

        assertEquals("Administrador", resultado);
    }

    @Test
    public void testGetClientes() {
        apiController.getClientes();
        verify(usuarioService).getAllClientes();
    }

    @Test
    public void testValidarCliente() {
        Usuario usuario = new Usuario();
        usuario.setDni("dni"); 
    
        when(usuarioService.getAllClientes()).thenReturn(Arrays.asList(usuario));
        when(usuarioService.getUsuario(anyString())).thenReturn(usuario);

        boolean resultado = apiController.validarCliente("dni");

        verify(usuarioService).getAllClientes();
        verify(usuarioService).getUsuario("dni");

        assertTrue(resultado);
    }

    @Test
    public void validarUsuarioTest() {
        when(usuarioService.getUsuario("123")).thenReturn(new Usuario());
        assertTrue(apiController.validarUsuario("123"));
        assertFalse(apiController.validarUsuario("456"));
    }

    @Test
    public void validarArticuloTest() {
        when(articuloService.getArticulo(1)).thenReturn(new Articulo());
        assertTrue(apiController.validarArticulo(1));
        assertFalse(apiController.validarArticulo(2));
    }

    @Test
    public void updateArticuloTest() {
        when(articuloService.getArticulo(1)).thenReturn(new Articulo());
        assertTrue(apiController.updateArticulo(1, "nombre", "desc", "Ropa", 100.0, "tam"));
        assertFalse(apiController.updateArticulo(2, "nombre", "desc", "Ropa", 100.0, "tam"));
    }

    /*@Test
    public void updateClienteTest() {
    }*/

    @Test
    public void testDeleteArticulo() {
        Integer id = 1;
        Articulo articulo = new Articulo();
        when(articuloService.getArticulo(id)).thenReturn(articulo);
        assertTrue(apiController.deleteArticulo(id));
    }

    /*@Test
    public void testDeleteCliente() {
        String dni = "12345678";
        Usuario usuario = new Usuario();
        when(usuarioService.getUsuario(dni)).thenReturn(usuario);
        Mockito.doNothing().when(usuarioService).deleteUsuario(dni);
        assertTrue(apiController.deleteCliente(dni));
    }

    @Test
    public void testCrearUsuario() {
        
    }*/


}