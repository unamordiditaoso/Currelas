package psc5.deustoimperiomoda.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.DataDomain.Categoria;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer>{
    Optional<Articulo> findById(Integer id);
    Optional<Articulo> findByNombre(String nombre);
    Optional<Articulo> findByPrecio(double precio);
    Optional<Articulo> findByCategoria(Categoria categoria);
}
