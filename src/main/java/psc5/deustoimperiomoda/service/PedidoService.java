package psc5.deustoimperiomoda.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.DataDomain.Estado;
import psc5.deustoimperiomoda.DataDomain.Pedido;
import psc5.deustoimperiomoda.DataDomain.Usuario;
import psc5.deustoimperiomoda.dao.PedidoRepository;

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

    /** @brief Carga todos los pedidos de la base de datos y los guarda en el repositorio de pedidos
     */

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

    /** @brief Carga todos los artículos de la base de datos por pedido
     */

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

    /** @brief Coge el pedido por el id
     *  @return Devuelve el pedido si coincide con el id
     */

    public Pedido getPedido(int id){
        Pedido result = pedidoRepository.findById(id);
        
        return result;
    }

    /** @brief Coge todos los pedidos
     *  @return Lista de los todos los pedidos del repositorio
     */

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    /** @brief Añade un pedido al repositorio
     *  @retval True Pedido correctamente añadido
     *  @retval False Pedido no añadido
     */

    public Pedido addPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    /** @brief Actualiza un pedido del id enviado
     *  @return El pedido actualizado
     */


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