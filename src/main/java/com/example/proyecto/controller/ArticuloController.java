package com.example.proyecto.controller;

import com.example.proyecto.dao.ArticuloDaoImp;
import com.example.proyecto.dao.BodegaDaoImp;
import com.example.proyecto.entity.Articulo;
import com.example.proyecto.entity.Bodega;
import org.springframework.beans.factory.annotation.Autowired;
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


    @PostMapping("/guardar")
    public String guardarArticulo(@ModelAttribute Articulo articulo, @RequestParam("bodegaId") Long bodegaId) {
        Bodega bodega = bodegaDao.findOne(bodegaId);
        articulo.setBodega(bodega);
        articuloDao.save(articulo);
        return "redirect:/articulo/listado";
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
