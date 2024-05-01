package psc5.deustoimperiomoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psc5.deustoimperiomoda.DataDomain.Envio;
import psc5.deustoimperiomoda.DataDomain.Estado;
import psc5.deustoimperiomoda.DataDomain.Pedido;
import psc5.deustoimperiomoda.DataDomain.Usuario;

@Repository
public interface EnvioRepository extends JpaRepository<Envio,Integer> {
    Envio findById(int id);
    Envio findByCliente(Usuario cliente);
    Envio findByPedido(Pedido pedido);
    Envio findByEstado(Estado estado);
}
