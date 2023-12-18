package com.example.proyecto.controller;

import com.example.proyecto.dao.BodegaDaoImp;
import com.example.proyecto.entity.Bodega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bodega")
public class BodegaController {

    @Autowired
    private BodegaDaoImp bodegaDao;

    @GetMapping("/listado")
    public String mostrarListadoBodegas(Model model) {
        List<Bodega> bodegas = bodegaDao.findAll();
        model.addAttribute("bodegas", bodegas);
        return "listadoBodegas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarBodega(@PathVariable Long id, Model model) {
        Bodega bodega = bodegaDao.findOne(id);
        model.addAttribute("bodega", bodega);
        return "formularioEditarBodega";
    }

    @PostMapping("/guardar")
    public String guardarBodega(@ModelAttribute Bodega bodega) {
        bodegaDao.save(bodega);
        return "redirect:/bodega/listado";
    }
    @PostMapping("/editar/{id}")
    public ResponseEntity<String> editarBodega(@PathVariable("id") Long id, @RequestBody Bodega bodega) {
        if (id != null && id > 0) {
            Bodega existingBodega = bodegaDao.findOne(id);
            if (existingBodega != null) {
                existingBodega.setCodigo(bodega.getCodigo());
                existingBodega.setNombre(bodega.getNombre());
                existingBodega.setUbicacion(bodega.getUbicacion());
                bodegaDao.save(existingBodega);
                return new ResponseEntity<>("Bodega actualizada correctamente", HttpStatus.OK);
            }
            return new ResponseEntity<>("No se encontró la bodega", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("ID de bodega inválido", HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarBodega(@PathVariable Long id) {
        bodegaDao.delete(id);
        return "redirect:/bodega/listado";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearBodega(Model model) {
        model.addAttribute("bodega", new Bodega());
        return "formularioCrearBodega";
    }


}
