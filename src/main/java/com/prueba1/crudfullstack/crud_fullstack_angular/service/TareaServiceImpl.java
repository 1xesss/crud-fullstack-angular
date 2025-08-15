package com.prueba1.crudfullstack.crud_fullstack_angular.service;

import com.prueba1.crudfullstack.crud_fullstack_angular.entity.Tarea;
import com.prueba1.crudfullstack.crud_fullstack_angular.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public List<Tarea> listarTodasTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea listarTarea(Long id) {
        return tareaRepository.findById(id).get();
    }

    @Override
    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }

    @Override
    public Tarea editarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }


}
