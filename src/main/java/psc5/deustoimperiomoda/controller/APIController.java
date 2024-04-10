package psc5.deustoimperiomoda.controller;

import org.springframework.web.bind.annotation.RestController;

import psc5.deustoimperiomoda.service.ArticuloService;
import psc5.deustoimperiomoda.service.UsuarioService;
import psc5.deustoimperiomoda.DataDomain.Articulo;
import psc5.deustoimperiomoda.DataDomain.Usuario;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class APIController {
    
    private ArticuloService articuloService;
    private UsuarioService usuarioService;

    public APIController(ArticuloService articuloService, UsuarioService usuarioService) {
        this.articuloService = articuloService;
        this.usuarioService = usuarioService;
    }

    @RequestMapping("/articulo/all")
    public List<Articulo> test() {
        return articuloService.getAllArticulos();
    }
    @RequestMapping("/usuario/all")
    public List<Usuario> test2() {
        return usuarioService.getAllUsuarios();
    }
}
