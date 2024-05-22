package psc5.deustoimperiomoda.controller;

import org.springframework.web.bind.annotation.RestController;

import psc5.deustoimperiomoda.service.ArticuloService;
import psc5.deustoimperiomoda.service.PedidoService;
import psc5.deustoimperiomoda.service.UsuarioService;
import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.DataDomain.Categoria;
import psc5.deustoimperiomoda.DataDomain.Estado;
import psc5.deustoimperiomoda.DataDomain.Pedido;
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
    private PedidoService pedidoService;

    public APIController(ArticuloService articuloService, UsuarioService usuarioService, PedidoService pedidoService) {
        this.articuloService = articuloService;
        this.usuarioService = usuarioService;
        this.pedidoService = pedidoService;   
    }


    /** @brief Devuelve todos los artículos de la base de datos
     *  @return Lista de todos los artículos de la bd
     */
    @RequestMapping("articulo/all")
    public List<Articulo> getArticulos() {
        return articuloService.getAllArticulos();
    }
    
    /** @brief Devuelve todos los usuarios de la base de datos
     *  @return Lista de todos los usuarios de la bd
     */

    @RequestMapping("usuario/all")
    public List<Usuario> getUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    /** @brief Valida la contraseña con el dni de un usuario de la base de datos
     *  @retval "Cliente" Es devuelto si el usuario es correcto y es cliente
     *  @retval "Administrador" Es devuelto si el usuario es correcto y es administrador
     *  @retval "false" Es devuelto si el usuario es incorrecto
     */

    @RequestMapping("usuario/iniciarSesion")
    public String validarContrasena(@RequestParam (name = "dni") String dni,
                                    @RequestParam (name = "contr") String contrasena) {
        if (validarUsuario(dni)){
            Usuario usuario = usuarioService.getUsuario(dni);
            if (usuario.getContrasena().equals(contrasena)){
                if(validarCliente(dni)){
                    return "Cliente";
                }
                else {
                    return "Administrador";
                }
            }
            return "false";
        }
        return "false";
    }

    /** @brief Devuelve todos los usuarios que son cliente de la base de datos
     *  @return Lista de los usuarios que son cliente de la bd
     */

    @RequestMapping("cliente/all")
    public List<Usuario> getClientes() {
        return usuarioService.getAllClientes();
    }

    /** @brief Valida que el dni de la función es un dni de algún usuario tipo cliente de la base de datos
     *  @retval True El dni pertenece a un usuario tipo cliente
     *  @retval False El dni no pertenece a ningún usuario tipo cliente
     */

    @RequestMapping("cliente/validar")
    public boolean validarCliente(@RequestParam (name = "dni") String dni) {
        return usuarioService.getAllClientes().contains(usuarioService.getUsuario(dni));
    }

    /** @brief Valida que el dni de la función es un dni de algún usuario de la base de datos
     *  @retval True El dni pertenece a un usuario
     *  @retval False El dni no es de ningún usuario de la base de datos
     */

    @RequestMapping("usuario/validar")
    public boolean validarUsuario(@RequestParam (name = "dni") String dni) {
        return usuarioService.getUsuario(dni) != null;
    }

    /** @brief Valida que el id de la función es el id de algún artículo de la base de datos
     *  @retval True El id pertenece a un artículo
     *  @retval False El id no pertenece a ningún artículo en la base de datos
     */
    
    @RequestMapping("articulo/validar")
    public boolean validarArticulo(@RequestParam (name = "id") Integer id) {
        return articuloService.getArticulo(id) != null;
    }

    /** @brief Actualiza un artículo recibiendo todas las variables de un artículo
     *  @retval True El artículo se ha actualizado
     *  @retval False El artículo no se ha actualizado, ya que no existe ese id de artículo
     */

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

    /** @brief Actualiza un usuario tipo cliente recibiendo todas las variables de un usuario
     *  @retval True El usuario tipo cliente se ha actualizado
     *  @retval False El usuario tipo cliente no se ha actualizado, ya que no existe ese dni de ningún cliente
     */

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

    /** @brief Borra un artículo por su id
     *  @retval True El artículo se ha borrado
     *  @retval False El artículo no se ha borrado, ya que no existe ese id de artículo
     */

    @RequestMapping("articulo/borrar")
    public boolean deleteArticulo(@RequestParam (name = "id") Integer id) {
        if (validarArticulo(id)) {
            articuloService.deleteArticulo(id);
            return true;
        } else {
            return false;
        }
    }
    
    /** @brief Borra un usuario tipo cliente por su dni
     *  @retval True El usuario tipo cliente se ha borrado
     *  @retval False El usuario tipo cliente no se ha borrado, ya que no existe ese dni de ningún cliente
     */

    @RequestMapping("cliente/borrar")
    public boolean deleteCliente(@RequestParam (name = "dni") String dni) {
        if (validarCliente(dni)) {
            usuarioService.deleteUsuario(dni);
            return true;
        } else {
            return false;
        }
    }

    /** @brief Crea un artículo recibiendo todas las variables de un artículo
     *  @return El artículo ha sido añadido correctamente a la base de datos
     */

    @RequestMapping("articulo/crear")
    public boolean crearArticulo(@RequestParam (name = "nombre") String nombre, 
                                 @RequestParam (name = "desc")String descripcion, 
                                 @RequestParam (name = "categoria")String categoria , 
                                 @RequestParam (name = "precio") Double precio, 
                                 @RequestParam (name = "tam") String tamano) {
        articuloService.addArticulo(new Articulo(Categoria.valueOf(categoria), descripcion, nombre, precio, tamano));
        return true;
    }

    /** @brief Crea un usuario recibiendo todas las variables de un usuario
     *  @return El usuario ha sido añadido correctamente a la base de datos
     */

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

    /** @brief Devuelve todos los pedidos de la base de datos
     *  @return Lista de los pedidos de la bd
     */

    @RequestMapping("pedido/all")
    public List<Pedido> getPedidos() {
        return pedidoService.getAllPedidos();
    }

    /** @brief Crea un pedido recibiendo todas las variables de un pedido
     *  @return El pedido ha sido añadido correctamente a la base de datos
     */

    @RequestMapping("pedido/crear")
    public boolean crearPedido(@RequestParam (name = "dni") String dni) {

    Usuario u = usuarioService.getUsuario(dni);
    if (u != null) {
        Pedido pedido = new Pedido();
        pedido.setUsuario(u);
        pedido.setEstado(Estado.Preparacion);
        pedidoService.addPedido(pedido);
        return true;
    } else {
        return false;
    }
    }

    /** @brief Actualiza el estado de un pedido recibiendo todas las variables de un pedido
     *  @retval True El estado del pedido se ha actualizado
     *  @retval False El estado del pedido no se ha actualizado, ya que no existe ese pedido o el pedido no pertenece a ese usuario
     */
    
    @RequestMapping("pedido/update")
    public boolean updatePedidoEstado(@RequestParam(name = "dni") String dni, 
                                      @RequestParam(name = "estado") String nuevoEstado,
                                      @RequestParam(name = "id") Integer id) {
        Pedido pedido = pedidoService.getPedido(id);
        if (pedido != null && pedido.getUsuario().getDni().equals(dni)) {
            pedido.setEstado(Estado.valueOf(nuevoEstado));
            pedidoService.updatePedido(pedido, id);
            return true;
        } else {
            return false;
        }
    }         

    
}
