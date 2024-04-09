package psc5.deustoimperiomoda.controller;

import org.springframework.web.bind.annotation.RestController;

import psc5.deustoimperiomoda.service.ArticuloService;
import psc5.deustoimperiomoda.DataDomain.Articulo;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class APIController {
    
    private ArticuloService articuloService;

    public APIController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @RequestMapping("/articulo/all")
    public List<Articulo> test() {
        return articuloService.getAllArticulos();
    }
    
}
