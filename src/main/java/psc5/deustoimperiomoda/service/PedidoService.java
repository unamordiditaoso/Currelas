package psc5.deustoimperiomoda.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.DataDomain.Categoria;
import psc5.deustoimperiomoda.DataDomain.Estado;
import psc5.deustoimperiomoda.DataDomain.Pedido;
import psc5.deustoimperiomoda.DataDomain.Usuario;
import psc5.deustoimperiomoda.dao.ArticuloRepository;
import psc5.deustoimperiomoda.dao.PedidoRepository;
import psc5.deustoimperiomoda.service.ArticuloService;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ArticuloService articuloService;
    private final String connectionString;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, ArticuloService articuloService) {
        this.pedidoRepository = pedidoRepository;
        this.articuloService = articuloService;
        this.connectionString = "jdbc:sqlite:DeustoImperioModa.db";
        loadDatos();
    }

    public void loadDatos(){
        String sql = "SELECT * FROM pedido";
        try (Connection con = DriverManager.getConnection(connectionString);
             PreparedStatement pStmt = con.prepareStatement(sql)) {
    
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                Usuario usuario = new Usuario(); // Necesitas obtener el usuario de alguna manera
                Estado estado = Estado.valueOf(rs.getString("estado")); // Asumiendo que "estado" es un enum
                // Obtén el ID del pedido
                int idPedido = rs.getInt("ID_ped");
                // Carga los artículos para este pedido
                List<Articulo> articulos = loadArticulosbyPedido(idPedido);
                Pedido pedido = new Pedido(usuario, articulos, estado);
            }
        } catch (SQLException e) {
            // Deberías manejar esta excepción de alguna manera
        }
    }

    
    private List<Articulo> loadArticulosbyPedido(int idPedido) throws SQLException {
        List<Articulo> articulos = new ArrayList<>();
    
        String sql = "SELECT articulo.* FROM articulo " +
                     "JOIN articulos_comprados ON articulo.id_art = articulos_comprados.articulo " +
                     "WHERE articulos_comprados.pedido = ?";
    
        try (Connection con = DriverManager.getConnection(connectionString);
             PreparedStatement pStmt = con.prepareStatement(sql)) {
    
            pStmt.setInt(1, idPedido);
    
            ResultSet rs = pStmt.executeQuery();
    
            while (rs.next()) {
                // Usa articuloService para obtener el Articulo
                Articulo articulo = articuloService.getArticulo(rs.getInt("id_art"));
                articulos.add(articulo);
            }
        }
    
        return articulos;
    }

    public Pedido getPedido(int id){
        Pedido result = pedidoRepository.findById(id);
        
        return result;
    }

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido addPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public Pedido updatePedido(Pedido pedido, int idPedido){
        Pedido updatedPedido = pedidoRepository.findById(idPedido);
    
        if (updatedPedido != null) {
            updatedPedido.setEstado(pedido.getEstado());
            pedidoRepository.save(updatedPedido);
    
            return updatedPedido;
        }
    
        return null;
    }
}