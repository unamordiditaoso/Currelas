package psc5.deustoimperiomoda.service;

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

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
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
