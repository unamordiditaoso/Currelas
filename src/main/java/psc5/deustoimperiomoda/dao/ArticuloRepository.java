package psc5.deustoimperiomoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psc5.deustoimperiomoda.DataDomain.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer>{
    Articulo findById(int id);
    Articulo findByNombre(String nombre);
    Articulo findByPrecio(double precio);
}
