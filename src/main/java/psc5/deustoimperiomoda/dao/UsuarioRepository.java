package psc5.deustoimperiomoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psc5.deustoimperiomoda.DataDomain.Usuario;
import psc5.deustoimperiomoda.DataDomain.TipoUsuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    Usuario findByDni(String dni);
    Usuario findByTipoUsuario(TipoUsuario tipoUsuario);
}
