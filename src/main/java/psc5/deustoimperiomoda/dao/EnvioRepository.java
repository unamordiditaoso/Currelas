package psc5.deustoimperiomoda.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psc5.deustoimperiomoda.DataDomain.Envio;
import psc5.deustoimperiomoda.DataDomain.Estado;
import psc5.deustoimperiomoda.DataDomain.Pedido;
import psc5.deustoimperiomoda.DataDomain.Usuario;

@Repository
public interface EnvioRepository extends JpaRepository<Envio,Integer> {
    Optional<Envio> findById(Integer id);
    Optional<Envio> findByUsuario(Usuario cliente);
    Optional<Envio> findByPedido(Pedido pedido);
    Optional<Envio> findByEstado(Estado estado);
}
