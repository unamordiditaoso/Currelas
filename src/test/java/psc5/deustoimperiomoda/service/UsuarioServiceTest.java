package psc5.deustoimperiomoda.service;

import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.DataDomain.Usuario;
import psc5.deustoimperiomoda.dao.UsuarioRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioService usuarioService;
    @Mock
    private UsuarioRepository usuarioRepository;

    @Before
    public void testUsuarioServiceConstructor() {
        usuarioService = new UsuarioService(usuarioRepository);
    }

    /*@Test
    void testLoadDatos() {
    }*/

    @Test
    public void testGetUsuario() {
    Usuario usuario1 = new Usuario();
    when(usuarioRepository.findByDni(any())).thenReturn(java.util.Optional.of(usuario1));
    Usuario usuario2 = usuarioService.getUsuario("12345678A");

    assertEquals(usuario1, usuario2);
    }

    @Test
    public void testUpdateUsuario() {
        Usuario UsuarioViejo = new Usuario();
        UsuarioViejo.setDni("12345678A");
        UsuarioViejo.setNombre("Usuario1");
        usuarioService.updateUsuario(UsuarioViejo, "12345678A");
        assertEquals("Usuario1", UsuarioViejo.getNombre());
    }

    /*@Test
    public void testAddUsuario() {
        Usuario usuario = new Usuario();
        when(usuarioRepository.findByDni("123456789A")).thenReturn(Optional.empty());
        Usuario usuario2 = usuarioService.addUsuario(usuario, "123456789A");
        assertNotNull(usuario2);
    }*/

    @Test
    public void testDeleteUsuario() {
        Usuario usuario = new Usuario();
        usuario.setDni("12345678A");
        usuarioService.deleteUsuario( "12345678A");
        assertNull(usuarioService.getUsuario("12345678A"));
    }
}