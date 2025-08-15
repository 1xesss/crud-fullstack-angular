package com.prueba1.crudfullstack.crud_fullstack_angular.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El titulo de la tarea debe de ser obligatorio")
    private String tituloTarea;
    @FutureOrPresent(message = "La fecha límite no puede ser anterior a la actual")
    private LocalDate fechaLimite;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTituloTarea(String tituloTarea) {
        this.tituloTarea = tituloTarea;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Long getId() {
        return id;
    }

    public String getTituloTarea() {
        return tituloTarea;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }
}
