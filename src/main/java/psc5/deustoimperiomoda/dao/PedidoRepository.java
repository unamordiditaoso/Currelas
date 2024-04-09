package psc5.deustoimperiomoda.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import psc5.deustoimperiomoda.DataDomain.Pedido;
import psc5.deustoimperiomoda.DataDomain.Usuario;


public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    Optional<Pedido> findById(Integer id);
    Optional<Pedido> findByUsuario(Usuario usuario);
}
