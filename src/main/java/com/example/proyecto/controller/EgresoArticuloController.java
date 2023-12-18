package com.example.proyecto.controller;

import com.example.proyecto.dao.IBodegaDao;
import com.example.proyecto.dao.IEgresoArticuloDao;
import com.example.proyecto.entity.Bodega;
import com.example.proyecto.entity.EgresoArticulo;
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
@RequestMapping("/egresos-articulo")
public class EgresoArticuloController {

    @Autowired
    private IEgresoArticuloDao egresoArticuloDao;

    @Autowired
    private IBodegaDao bodegaDao;

    @GetMapping("/listado")
    public String mostrarListadoEgresoArticulos(Model model) {
        List<EgresoArticulo> egresosArticulo = egresoArticuloDao.findAll();
        model.addAttribute("egresosArticulo", egresosArticulo);
        return "listadoEgresoArticulo";
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<String> editarEgresoArticulo(@PathVariable Long id, @RequestBody EgresoArticulo egresoArticulo) {
        System.out.println("ID recibido para edición: " + id);

        EgresoArticulo egresoArticuloExistente = egresoArticuloDao.findOne(id);
        System.out.println("EgresoArticuloExistente: " + egresoArticuloExistente);

        if (egresoArticuloExistente != null) {
            System.out.println("Datos recibidos para actualización:");
            System.out.println("Fecha Egreso: " + egresoArticulo.getFechaEgresoArticulo());
            System.out.println("Bodega: " + egresoArticulo.getBodega());

            egresoArticuloExistente.setFechaEgresoArticulo(egresoArticulo.getFechaEgresoArticulo());
            egresoArticuloExistente.setBodega(egresoArticulo.getBodega());

            egresoArticuloDao.save(egresoArticuloExistente);

            System.out.println("Egreso de Artículo actualizado correctamente");
            return ResponseEntity.ok("Egreso de Artículo actualizado correctamente");
        } else {
            System.out.println("No se encontró el egreso de artículo");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el egreso de artículo");
        }
    }

    @PostMapping("/guardar")
    public String guardarEgresoArticulo(@RequestParam("fechaEgresoArticulo") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaEgresoArticulo,
                                        @RequestParam("bodegaId") Long bodegaId) {

        EgresoArticulo egresoArticulo = new EgresoArticulo();
        egresoArticulo.setFechaEgresoArticulo(fechaEgresoArticulo);

        Bodega bodega = bodegaDao.findOne(bodegaId);
        egresoArticulo.setBodega(bodega);

        egresoArticuloDao.save(egresoArticulo);
        return "redirect:/egresos-articulo/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEgresoArticulo(@PathVariable Long id) {
        egresoArticuloDao.delete(id);
        return "redirect:/egresos-articulo/listado";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearEgresoArticulo(Model model) {
        model.addAttribute("egresoArticulo", new EgresoArticulo());
        List<Bodega> bodegas = bodegaDao.findAll();
        model.addAttribute("bodegas", bodegas);
        model.addAttribute("bodega", new Bodega());
        return "formularioEgresoArticulo";
    }
}
