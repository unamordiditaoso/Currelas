package psc5.DataDTO;
import java.util.ArrayList;
import java.util.List;

import psc5.deustoimperiomoda.DataDomain.Usuario;
import psc5.deustoimperiomoda.DataDomain.TipoUsuario;


public class UsuarioAssembler {
    private static UsuarioAssembler instance;

    private UsuarioAssembler() { }

    public static UsuarioAssembler getInstance() {
        if(instance == null) {
            instance = new UsuarioAssembler();
        }
        return instance;
    }

    public UsuarioDTO usuarioToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setContrasena(usuario.getContrasena());
        dto.setDni(usuario.getDni());
        dto.setNombre(usuario.getNombre());
        dto.setContrasena(usuario.getCorreo());
        if(usuario.getTipoUsuario() == TipoUsuario.Cliente) {
            dto.setTipoUsuario("Cliente");
        }else if(usuario.getTipoUsuario() == TipoUsuario.Administrador) {
            dto.setTipoUsuario("Administrador");
        }

        return dto; 
    }

    public List<UsuarioDTO> usuarioToDTO(List<Usuario> usuarios) {
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            usuarioDTOs.add(this.usuarioToDTO(usuario));
        }

        return usuarioDTOs;

    }

}
