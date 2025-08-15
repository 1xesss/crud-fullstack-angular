package com.prueba1.crudfullstack.crud_fullstack_angular.controller;

import com.prueba1.crudfullstack.crud_fullstack_angular.entity.Tarea;
import com.prueba1.crudfullstack.crud_fullstack_angular.service.TareaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
@CrossOrigin( origins = "http://localhost:4200")
public class TareaController {


    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping("/crear")
    public Tarea crear(@Valid @RequestBody Tarea tarea) {
        tareaService.crearTarea(tarea);
        return tarea;
    }

    @GetMapping("/listar-todo")
    public List<Tarea> findAll(){
        return tareaService.listarTodasTareas();
    }

    @GetMapping("/{id}")
    public Tarea findById(@PathVariable Long id){
        return tareaService.listarTarea(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Long id){
        tareaService.eliminarTarea(id);
    }

    @PutMapping("/editar")
    public Tarea edit(@RequestBody Tarea tarea){
        Tarea tareaDb = tareaService.listarTarea(tarea.getId());
        tareaDb.setTituloTarea(tarea.getTituloTarea());
        tareaDb.setFechaLimite(tarea.getFechaLimite());
        return tareaService.editarTarea(tareaDb);
    }
}
