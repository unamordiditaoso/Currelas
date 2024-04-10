package psc5.deustoimperiomoda.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import psc5.deustoimperiomoda.DataDomain.TipoUsuario;
import psc5.deustoimperiomoda.DataDomain.Usuario;
import psc5.deustoimperiomoda.dao.UsuarioRepository;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private String connectionString;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;

        connectionString = "jdbc:sqlite:DeustoImperioModa.db";
        loadDatos();
    }

    public void loadDatos(){
        String sql = "SELECT * FROM articulo";
		
		try (Connection con = DriverManager.getConnection(connectionString);
		    PreparedStatement pStmt = con.prepareStatement(sql)) {	
			
			ResultSet rs = pStmt.executeQuery();
           
			while(rs.next()) {
                
				Usuario usuario = new Usuario(rs.getString("contrasena"), rs.getString("dni"), rs.getString("nombre"), rs.getString("correo"), null, TipoUsuario.valueOf(rs.getString("tipo_usuario")));
                System.out.println(usuarioRepository);
                System.out.println(usuario.getDni() + " " + usuario.getNombre() + "\n\n\n");
				usuarioRepository.save(usuario);
			}
		} catch (SQLException e) {
		}
    }

    public Usuario getUsuario(String dni){
        Optional<Usuario> result = usuarioRepository.findByDni(dni);
        
        return result.isEmpty() ? null : result.get();
    }

    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public List<Usuario> getAllClientes(){
        List<Usuario> usuarios = getAllUsuarios();
        List<Usuario> result = new ArrayList<Usuario>();

        for (Usuario usuario : usuarios) {
            if (usuario.getTipoUsuario().equals(TipoUsuario.Cliente)) {
                result.add(usuario);
            }
        }

        return result.isEmpty() ? null : result;
    }

    public void addUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario updateArticulo(Usuario usuario, String dni){
        Optional<Usuario> result = usuarioRepository.findByDni(usuario.getDni());

        if (!result.isEmpty()) {
            Usuario updatedUsuario = result.get();

            updatedUsuario.setContrasena(usuario.getContrasena());
            updatedUsuario.setCorreo(usuario.getCorreo());
            updatedUsuario.setPedidos(usuario.getPedidos());
            updatedUsuario.setTipoUsuario(usuario.getTipoUsuario());

            usuarioRepository.save(updatedUsuario);

            if (!usuarioRepository.findByDni(dni).isEmpty()) {
                return result.isEmpty() ? null : result.get();
            }
        }

        return result.isEmpty() ? null : result.get();
    }

    public void deleteUsuario(String dni){
        Optional<Usuario> result = usuarioRepository.findByDni(dni);

        if (!result.isEmpty()) {
            usuarioRepository.delete(result.get());
        }
    }
}
