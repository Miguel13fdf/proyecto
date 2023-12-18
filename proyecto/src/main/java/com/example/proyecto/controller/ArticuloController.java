package com.example.proyecto.controller;

import com.example.proyecto.dao.ArticuloDaoImp;
import com.example.proyecto.dao.BodegaDaoImp;
import com.example.proyecto.entity.Articulo;
import com.example.proyecto.entity.Bodega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/articulo")
public class ArticuloController {

    @Autowired
    private ArticuloDaoImp articuloDao;

    @Autowired
    private BodegaDaoImp bodegaDao;


    @GetMapping("/listado")
    public String mostrarListadoArticulos(Model model) {
        List<Articulo> articulos = articuloDao.findAll();
        model.addAttribute("articulos", articulos);
        return "listadoArticulos";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarArticulo(@PathVariable Long id, Model model) {
        Articulo articulo = articuloDao.findOne(id);
        model.addAttribute("articulo", articulo);
        List<Bodega> bodegas = bodegaDao.findAll();
        model.addAttribute("bodegas", bodegas);
        return "formularioEditarArticulo";
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<String> editarArticulo(@PathVariable("id") Long id, @RequestBody Articulo articulo) {
        if (id != null && id > 0) {
        	Articulo existingarticulo = articuloDao.findOne(id);
            if (existingarticulo != null) {
            	existingarticulo.setBodega(articulo.getBodega());
            	existingarticulo.setClasificacion(articulo.getClasificacion());
            	existingarticulo.setCodigoArticulo(articulo.getCodigoArticulo());
            	existingarticulo.setCostoPromedio(articulo.getCostoPromedio());
            	existingarticulo.setNombreArticulo(articulo.getNombreArticulo());
            	existingarticulo.setStockActual(articulo.getStockActual());
            	existingarticulo.setStockMaximo(articulo.getStockMaximo());
            	existingarticulo.setStockMinimo(articulo.getStockMinimo());
            	articuloDao.save(existingarticulo);
                return new ResponseEntity<>("Bodega actualizada correctamente", HttpStatus.OK);
            }
            return new ResponseEntity<>("No se encontró la bodega", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("ID de bodega inválido", HttpStatus.BAD_REQUEST);
    }
    
    
    @PostMapping("/guardar")
    public String guardarArticulo(@ModelAttribute Articulo articulo, @RequestParam("bodegaId") Long bodegaId) {
        try {
        	
        
    	Bodega bodega = bodegaDao.findOne(bodegaId);
        articulo.setBodega(bodega);
        articuloDao.save(articulo);
        return "redirect:/articulo/listado";
        }catch(Exception e) {
        	return "error";
        }
        
    }



    @GetMapping("/eliminar/{id}")
    public String eliminarArticulo(@PathVariable Long id) {
        articuloDao.delete(id);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearArticulo(Model model) {
        model.addAttribute("articulo", new Articulo());
        List<Bodega> bodegas = bodegaDao.findAll();
        model.addAttribute("bodegas", bodegas);
        model.addAttribute("bodega", new Bodega());
        return "formularioCrearArticulo";
    }
    

}
