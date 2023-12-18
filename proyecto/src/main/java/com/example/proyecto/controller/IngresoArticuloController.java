package com.example.proyecto.controller;

import com.example.proyecto.dao.IBodegaDao;
import com.example.proyecto.dao.IIngresoArticuloDao;
import com.example.proyecto.entity.Bodega;
import com.example.proyecto.entity.IngresoArticulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/ingresos-articulo")
public class IngresoArticuloController {

    @Autowired
    private IIngresoArticuloDao ingresoArticuloDao;

    @Autowired
    private IBodegaDao bodegaDao;

    @GetMapping("/listado")
    public String mostrarListadoIngresoArticulos(Model model) {
        List<IngresoArticulo> ingresosArticulo = ingresoArticuloDao.findAll();
        model.addAttribute("ingresosArticulo", ingresosArticulo);
        return "listadoIngresoArticulo";
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<String> editarIngresoArticulo(@PathVariable Long id, @RequestBody IngresoArticulo ingresoArticulo) {
        System.out.println("ID recibido para edición: " + id);

        IngresoArticulo ingresoArticuloExistente = ingresoArticuloDao.findOne(id);
        System.out.println("IngresoArticuloExistente: " + ingresoArticuloExistente);

        if (ingresoArticuloExistente != null) {
            System.out.println("Datos recibidos para actualización:");
            System.out.println("Fecha Ingreso: " + ingresoArticulo.getFechaIngresoArticulo());
            System.out.println("Bodega: " + ingresoArticulo.getBodega());

            ingresoArticuloExistente.setFechaIngresoArticulo(ingresoArticulo.getFechaIngresoArticulo());
            ingresoArticuloExistente.setBodega(ingresoArticulo.getBodega());

            ingresoArticuloDao.save(ingresoArticuloExistente);

            System.out.println("Ingreso de Artículo actualizado correctamente");
            return ResponseEntity.ok("Ingreso de Artículo actualizado correctamente");
        } else {
            System.out.println("No se encontró el ingreso de artículo");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el ingreso de artículo");
        }
    }


    @PostMapping("/guardar")
    public String guardarIngresoArticulo(@RequestParam("fechaIngresoArticulo") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIngresoArticulo,
                                         @RequestParam("bodegaId") Long bodegaId) {

        IngresoArticulo ingresoArticulo = new IngresoArticulo();
        ingresoArticulo.setFechaIngresoArticulo(fechaIngresoArticulo);

        Bodega bodega = bodegaDao.findOne(bodegaId);
        ingresoArticulo.setBodega(bodega);

        ingresoArticuloDao.save(ingresoArticulo);
        return "redirect:/ingresos-articulo/listado";
    }




    @GetMapping("/eliminar/{id}")
    public String eliminarIngresoArticulo(@PathVariable Long id) {
        ingresoArticuloDao.delete(id);
        return "redirect:/ingresos-articulo/listado";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearIngresoArticulo(Model model) {
        model.addAttribute("ingresoArticulo", new IngresoArticulo());
        List<Bodega> bodegas = bodegaDao.findAll();
        model.addAttribute("bodegas", bodegas);
        model.addAttribute("bodega", new Bodega());
        return "formularioIngresoArticulo";
    }


}

