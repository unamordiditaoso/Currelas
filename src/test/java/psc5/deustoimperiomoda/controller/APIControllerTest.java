package psc5.deustoimperiomoda.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.DataDomain.TipoUsuario;
import psc5.deustoimperiomoda.DataDomain.Usuario;
import psc5.deustoimperiomoda.service.ArticuloService;
import psc5.deustoimperiomoda.service.UsuarioService;


@RunWith(MockitoJUnitRunner.class)
public class APIControllerTest {

    @Mock
    private ArticuloService articuloService;
    @Mock
    private UsuarioService usuarioService;
    @Mock
    private Usuario usuario;

    @InjectMocks
    private APIController apiController;


    @BeforeEach
    public void setUp() {
        apiController = new APIController(articuloService, usuarioService);
        usuario = new Usuario("contrasena", "dni", "nombre", "correo", new ArrayList<>(), TipoUsuario.Cliente);
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
        

        String resultado = apiController.validarContrasena(null, null);
        assertEquals("false", resultado);
        resultado = apiController.validarContrasena("dni", "a");
        assertEquals("false", resultado);
        resultado = apiController.validarContrasena("dni", "contrasena");
        assertEquals("Administrador", resultado);
        when(usuarioService.getAllClientes()).thenReturn(Arrays.asList(usuario));
        resultado = apiController.validarContrasena("dni", "contrasena");
        assertEquals("Cliente", resultado);

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

    @Test
    public void updateClienteTest() {
        when(usuarioService.getAllClientes()).thenReturn(Arrays.asList(usuario));
        when(usuarioService.getUsuario("dni")).thenReturn(usuario);
        assertTrue(apiController.updateCliente("dni", "contrasena", "nombre", "correo", new ArrayList<>()));
        assertFalse(apiController.updateCliente("notDNI", "contrasena", "nombre", "correo", new ArrayList<>())); 
    }

    @Test
    public void testDeleteArticulo() {
        Integer id = 1;
        Articulo articulo = new Articulo();
        when(articuloService.getArticulo(id)).thenReturn(articulo);
        assertTrue(apiController.deleteArticulo(id));
        apiController.deleteArticulo(2);
    }

    @Test
    public void testDeleteCliente() {
        when(usuarioService.getAllClientes()).thenReturn(Arrays.asList(usuario));
        when(usuarioService.getUsuario("dni")).thenReturn(usuario);
        assertTrue(apiController.deleteCliente("dni"));
        apiController.deleteCliente("notDNI");
    }

    @Test
    public void testCrearUsuario() {
        when(usuarioService.getUsuario("dni")).thenReturn(null);
        when(usuarioService.getUsuario("notDNI")).thenReturn(usuario);
        assertTrue(apiController.crearUsuario("dni", "cont", "nom", "cor", new ArrayList<>(), "Administrador"));
        assertFalse(apiController.crearUsuario("notDNI", "cont", "nom", "cor", new ArrayList<>(), "Administrador"));
    }

    @Test
    public void testCrearArticulo() {
        assertTrue(apiController.crearArticulo("nom", "desc", "Ropa", 100.0, "tam"));
    }

}