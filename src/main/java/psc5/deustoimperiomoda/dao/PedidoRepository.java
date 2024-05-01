package psc5.deustoimperiomoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psc5.deustoimperiomoda.DataDomain.Pedido;
import psc5.deustoimperiomoda.DataDomain.Usuario;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    Pedido findById(int id);
    Pedido findByUsuario(Usuario usuario);
}
