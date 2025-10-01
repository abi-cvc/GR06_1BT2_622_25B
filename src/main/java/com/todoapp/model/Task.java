package com.todoapp.model;

import javax.persistence.*;
import java.util.Date;

// Clase entidad que representa una tarea en la base de datos
@Entity
@Table(name = "tasks")
public class Task {

    // Identificador único de la tarea, generado automáticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Título de la tarea, campo obligatorio
    @Column(nullable = false)
    private String title;

    // Descripción de la tarea con límite de 500 caracteres
    @Column(length = 500)
    private String description;

    // Estado de completitud de la tarea
    @Column(nullable = false)
    private boolean completed;

    // Fecha y hora de creación de la tarea
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // Constructor sin parámetros que inicializa valores por defecto
    public Task() {
        this.completed = false;
        this.createdAt = new Date();
    }

    // Constructor con parámetros para crear una tarea con título y descripción
    public Task(String title, String description) {
        this();
        this.title = title;
        this.description = description;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}