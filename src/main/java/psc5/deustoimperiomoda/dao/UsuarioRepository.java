package psc5.deustoimperiomoda.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import psc5.deustoimperiomoda.DataDomain.Usuario;
import psc5.deustoimperiomoda.DataDomain.TipoUsuario;



public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    Optional<Usuario> findByDni(String dni);
    Optional<Usuario> findByTipoUsuario(TipoUsuario tipoUsuario);
}
