package com.prueba1.crudfullstack.crud_fullstack_angular.service;

import com.prueba1.crudfullstack.crud_fullstack_angular.entity.Tarea;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TareaService {
 Tarea crearTarea(Tarea tarea);
 List<Tarea> listarTodasTareas();
 Tarea listarTarea(Long id);
 void eliminarTarea(Long id);
 Tarea editarTarea(Tarea tarea);
}
