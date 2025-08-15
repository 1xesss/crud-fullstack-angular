package com.prueba1.crudfullstack.crud_fullstack_angular.repository;

import com.prueba1.crudfullstack.crud_fullstack_angular.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

}
