package psc5.deustoimperiomoda.controller;

import org.springframework.web.bind.annotation.RestController;

import psc5.deustoimperiomoda.service.ArticuloService;
import psc5.deustoimperiomoda.service.UsuarioService;
import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.DataDomain.Categoria;
import psc5.deustoimperiomoda.DataDomain.TipoUsuario;
import psc5.deustoimperiomoda.DataDomain.Usuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class APIController {
    
    private ArticuloService articuloService;
    private UsuarioService usuarioService;

    public APIController(ArticuloService articuloService, UsuarioService usuarioService) {
        this.articuloService = articuloService;
        this.usuarioService = usuarioService;
    }

    @RequestMapping("articulo/all")
    public List<Articulo> getArticulos() {
        return articuloService.getAllArticulos();
    }

    @RequestMapping("usuario/all")
    public List<Usuario> getUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @RequestMapping("cliente/all")
    public List<Usuario> getClientes() {
        return usuarioService.getAllUsuarios();
    }

    @RequestMapping("cliente/validar")
    public boolean validarCliente(@RequestParam (name = "dni") String dni) {
        return usuarioService.getAllClientes().contains(usuarioService.getUsuario(dni));
    }

    @RequestMapping("usuario/validar")
    public boolean validarUsuario(@RequestParam (name = "dni") String dni) {
        return usuarioService.getUsuario(dni) != null;
    }

    @RequestMapping("articulo/validar")
    public boolean validarArticulo(@RequestParam (name = "id") Integer id) {
        return articuloService.getArticulo(id) != null;
    }

    @RequestMapping("articulo/update")
    public boolean updateArticulo(@RequestParam (name = "id") Integer id, 
                                  @RequestParam (name = "nombre") String nombre, 
                                  @RequestParam (name = "desc")String descripcion, 
                                  @RequestParam (name = "categoria")String categoria , 
                                  @RequestParam (name = "precio") Double precio, 
                                  @RequestParam (name = "tam") String tamano) {
        if (validarArticulo(id)) {
            articuloService.updateArticulo(new Articulo(Categoria.valueOf(categoria), descripcion, nombre, precio, tamano), id);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("cliente/update")
    public boolean updateCliente(@RequestParam (name = "dni") String dni, 
                                 @RequestParam (name = "contr") String contrasena, 
                                 @RequestParam (name = "nombre")String nombre, 
                                 @RequestParam (name = "correo") String correo , 
                                 @RequestParam (name = "pedidos") ArrayList<String> pedidos) {
        if (validarCliente(dni)) {
            usuarioService.updateUsuario(new Usuario(contrasena, dni, nombre, correo, null, TipoUsuario.Cliente), dni);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("articulo/borrar")
    public boolean deleteArticulo(@RequestParam (name = "id") Integer id) {
        if (validarArticulo(id)) {
            articuloService.deleteArticulo(id);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("cliente/borrar")
    public boolean deleteCliente(@RequestParam (name = "dni") String dni) {
        if (validarCliente(dni)) {
            usuarioService.deleteUsuario(dni);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("articulo/crear")
    public boolean crearArticulo(@RequestParam (name = "nombre") String nombre, 
                                 @RequestParam (name = "desc")String descripcion, 
                                 @RequestParam (name = "categoria")String categoria , 
                                 @RequestParam (name = "precio") Double precio, 
                                 @RequestParam (name = "tam") String tamano) {
        articuloService.addArticulo(new Articulo(Categoria.valueOf(categoria), descripcion, nombre, precio, tamano));
        return true;
    }

    @RequestMapping("usuario/crear")
    public boolean crearUsuario(@RequestParam (name = "dni") String dni, 
                                @RequestParam (name = "contr") String contrasena, 
                                @RequestParam (name = "nombre")String nombre, 
                                @RequestParam (name = "correo") String correo , 
                                @RequestParam (name = "pedidos") ArrayList<String> pedidos,
                                @RequestParam (name = "tipoU") String tipoUsuario) {
        if (!validarUsuario(dni)) {
            usuarioService.addUsuario(new Usuario(contrasena, dni, nombre, correo, null, TipoUsuario.valueOf(tipoUsuario)), dni);
            return true;
        } else {
            return false;
        }
    }
}
