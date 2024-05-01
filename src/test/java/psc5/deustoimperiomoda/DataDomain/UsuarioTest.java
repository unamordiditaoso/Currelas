package psc5.deustoimperiomoda.DataDomain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class UsuarioTest {
    @Mock
    private Usuario usuario;

    @Rule public ContiPerfRule rule = new ContiPerfRule();

    @Before
    public void setUp() {
       usuario = new Usuario();
    }


    @Test
    @PerfTest(invocations = 1000, threads = 20)
    @Required(max = 120, average = 30)
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