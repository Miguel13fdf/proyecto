package com.example.proyecto.controller;

import com.example.proyecto.dao.IArticuloDao;
import com.example.proyecto.dao.IIngresoArticuloDao;
import com.example.proyecto.dao.IIngresoDetalleDao;
import com.example.proyecto.entity.Articulo;
import com.example.proyecto.entity.IngresoArticulo;
import com.example.proyecto.entity.IngresoDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ingresos-detalle")
public class IngresoDetalleController {

    private final IIngresoDetalleDao ingresoDetalleDao;
    private final IArticuloDao articuloDao;
    private final IIngresoArticuloDao ingresoArticuloDao;

    @Autowired
    public IngresoDetalleController(IIngresoDetalleDao ingresoDetalleDao, IArticuloDao articuloDao, IIngresoArticuloDao ingresoArticuloDao) {
        this.ingresoDetalleDao = ingresoDetalleDao;
        this.articuloDao = articuloDao;
        this.ingresoArticuloDao = ingresoArticuloDao;
    }

    @GetMapping("/listado")
    public String mostrarListadoIngresoDetalle(Model model) {
        List<IngresoDetalle> ingresosDetalle = ingresoDetalleDao.findAll();
        model.addAttribute("ingresosDetalle", ingresosDetalle);
        return "listadoIngresoDetalle";
    }

    @PostMapping("/guardar")
    public String guardarIngresoDetalle(@RequestParam("ingresoArticuloId") Long ingresoArticuloId,
                                        @RequestParam("articuloId") Long articuloId,
                                        @RequestParam("cantidadIngresada") int cantidadIngresada,
                                        @RequestParam("precioComprado") double precioComprado,
                                        @RequestParam("costoPromedio") double costoPromedio) {
        IngresoArticulo ingresoArticulo = ingresoArticuloDao.findOne(ingresoArticuloId);
        Articulo articulo = articuloDao.findOne(articuloId);

        IngresoDetalle ingresoDetalle = new IngresoDetalle();
        ingresoDetalle.setIngresoArticulo(ingresoArticulo);
        ingresoDetalle.setArticulo(articulo);
        ingresoDetalle.setCantidadIngresada(cantidadIngresada);
        ingresoDetalle.setPrecioComprado(precioComprado);
        ingresoDetalle.setCostoPromedio(costoPromedio);

        // Realizar cálculo del costo promedio aquí si es necesario

        ingresoDetalleDao.save(ingresoDetalle);
        return "redirect:/ingresos-detalle/listado";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarIngresoDetalle(@PathVariable Long id) {
        ingresoDetalleDao.delete(id);
        return "redirect:/ingresos-detalle/listado";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearIngresoDetalle(Model model) {
        model.addAttribute("ingresoDetalle", new IngresoDetalle());
        List<Articulo> articulos = articuloDao.findAll();
        List<IngresoArticulo> ingresosArticulo = ingresoArticuloDao.findAll();
        model.addAttribute("articulos", articulos);
        model.addAttribute("ingresosArticulo", ingresosArticulo);
        return "formularioIngresoDetalle";
    }

}
