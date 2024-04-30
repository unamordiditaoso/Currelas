package psc5.deustoimperiomoda.service;

import org.junit.jupiter.api.Test;

import psc5.deustoimperiomoda.DataDomain.Usuario;
import psc5.deustoimperiomoda.dao.UsuarioRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.Optional;

class UsuarioServiceTest {

    UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
    UsuarioService usuarioService;

    @Test
    void testUsuarioServiceConstructor() {
        // Arrange & Act
        usuarioService = new UsuarioService(usuarioRepository);

        // Assert
        assertNotNull(usuarioService);
    }

    @Test
    void testLoadDatos() {
        // Arrange
        usuarioService = new UsuarioService(usuarioRepository);
        doNothing().when(usuarioService).loadDatos();

        // Act
        usuarioService.loadDatos();

        // Assert
        verify(usuarioService, times(1)).loadDatos();
    }

    @Test
    void testGetUsuario() {
        // Arrange
        Usuario expected = new Usuario();
        when(usuarioRepository.findByDni(anyString())).thenReturn(Optional.of(expected));

        // Act
        Usuario actual = usuarioService.getUsuario("12345678A");

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testUpdateUsuario() {
        // Arrange
        Usuario usuario = new Usuario();
        when(usuarioRepository.findByDni(anyString())).thenReturn(Optional.of(usuario));
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        // Act
        Usuario actual = usuarioService.updateUsuario(usuario, "12345678A");

        // Assert
        assertEquals(usuario, actual);
    }

    @Test
    void testAddUsuario() {
        // Arrange
        Usuario usuario = new Usuario();
        when(usuarioRepository.findByDni(anyString())).thenReturn(Optional.empty());
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        // Act
        Usuario actual = usuarioService.addUsuario(usuario, "12345678A");

        // Assert
        assertEquals(usuario, actual);
    }

    @Test
    void testDeleteUsuario() {
        // Arrange
        doNothing().when(usuarioRepository).deleteById(anyString());

        // Act
        usuarioService.deleteUsuario("12345678A");

        // Assert
        verify(usuarioRepository, times(1)).deleteById("12345678A");
    }
}