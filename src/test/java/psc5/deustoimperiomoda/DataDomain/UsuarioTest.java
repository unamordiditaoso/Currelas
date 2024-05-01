package psc5.deustoimperiomoda.DataDomain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioTest {
    @Mock
    private Usuario usuario;

    @Before
    public void setUp() {
       usuario = new Usuario();
    }


    @Test
    public void testConstructor() {
        TipoUsuario tipoUsuario = TipoUsuario.Cliente;
        String contrasena = "Contrasena";
        String nombre = "Nombre";
        String dni = "DNI";
        String correo = "Correo";

        Usuario nuevoUsuario = new Usuario(contrasena, dni, nombre, correo, new ArrayList<>(), tipoUsuario);

        assertNotNull(nuevoUsuario);
    }


    @Test
    public void testGetContrasena(){
        usuario.setContrasena("Contrasena");
        assertEquals("Contrasena", usuario.getContrasena());
    }

    @Test
    public void testGetNombre(){
        usuario.setNombre("Nombre");
        assertEquals("Nombre", usuario.getNombre());
    }

    @Test
    public void testGetDNI(){
        usuario.setDni("DNI");
        assertEquals("DNI", usuario.getDni());
    }

    @Test
    public void testGetCorreo(){
        usuario.setCorreo("Correo");
        assertEquals("Correo", usuario.getCorreo());
    }

    @Test
    public void testGetTipoUsuario(){
        usuario.setTipoUsuario(TipoUsuario.Administrador);
        assertEquals(TipoUsuario.Administrador, usuario.getTipoUsuario());
    }

    @Test
    public void testGetPedidos(){
        usuario.setPedidos(new ArrayList<>());
        assertNotNull(usuario.getPedidos());
    }
    
    @Test
    public void testToString(){
        assertNotNull(usuario.toString());
    }
}