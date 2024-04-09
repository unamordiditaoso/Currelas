package psc5.deustoimperiomoda.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.DataDomain.Categoria;
import psc5.deustoimperiomoda.dao.ArticuloRepository;

@Service
public class ArticuloService {
private ArticuloRepository articuloRepository;
private String connectionString;

    public ArticuloService(ArticuloRepository articuloRepository){
        this.articuloRepository = articuloRepository;
        connectionString = "jdbc:sqlite:DeustoImperioModa.db";
        loadDatos();
    }
    
    public void loadDatos(){
        String sql = "SELECT * FROM Articulo";
		
		try (Connection con = DriverManager.getConnection(connectionString);
		    PreparedStatement pStmt = con.prepareStatement(sql)) {	
			
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				Articulo articulo = new Articulo(Categoria.valueOf(rs.getString("categoria")), rs.getString("descripcion"), rs.getString("nombre"), rs.getDouble("precio"), rs.getString("tamano"));
				articuloRepository.save(articulo);
			}
		} catch (SQLException e) {
		}
    }

    public Articulo getArticulo(Integer id){
        Optional<Articulo> result = articuloRepository.findById(id);
        
        return result.isEmpty() ? null : result.get();
    }

    public List<Articulo> getAllArticulos(){
        return articuloRepository.findAll();
    }

    public List<Articulo> getByCategoria(Categoria categoria){
        
        List<Articulo> articulos = getAllArticulos();
        List<Articulo> result = new ArrayList<Articulo>();

        for (Articulo articulo : articulos) {
            if (articulo.getCategoria().equals(categoria)) {
                result.add(articulo);
            }
        }

        return result.isEmpty() ? null : result;
    }

    public void addArticulo(Articulo articulo){
        articuloRepository.save(articulo);
    }

    public Articulo updateArticulo(Articulo articulo, Integer id){
        Optional<Articulo> result = articuloRepository.findById(articulo.getid());

        if (!result.isEmpty()) {
            Articulo updatedArticulo = result.get();

            updatedArticulo.setDescripcion(articulo.getDescripcion());
            updatedArticulo.setCategoria(articulo.getCategoria());
            updatedArticulo.setNombre(articulo.getNombre());
            updatedArticulo.setPrecio(articulo.getPrecio());
            updatedArticulo.setTamano(articulo.getTamano());

            articuloRepository.save(updatedArticulo);

            if (!articuloRepository.findById(id).isEmpty()) {
                return result.isEmpty() ? null : result.get();
            }
        }

        return result.isEmpty() ? null : result.get();
    }

    public void deleteArticulo(Integer id){
        Optional<Articulo> result = articuloRepository.findById(id);

        if (!result.isEmpty()) {
            articuloRepository.delete(result.get());
        }
    }
}
