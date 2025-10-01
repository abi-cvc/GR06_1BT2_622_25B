package com.todoapp.dao;

import com.todoapp.model.Task;
import com.todoapp.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TaskDAO {

    // Método para guardar una nueva tarea en la base de datos
    public void save(Task task) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(task); // Persiste la tarea en la base de datos
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback(); // Revierte la transacción en caso de error
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Método para obtener todas las tareas ordenadas por fecha de creación
    public List<Task> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Task> tasks = null;

        try {
            // Consulta JPQL para obtener todas las tareas ordenadas descendentemente
            tasks = em.createQuery("SELECT t FROM Task t ORDER BY t.createdAt DESC", Task.class)
                    .getResultList();
        } finally {
            em.close();
        }

        return tasks;
    }

    // Método para buscar una tarea específica por su identificador
    public Task findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Task task = null;

        try {
            task = em.find(Task.class, id); // Busca la tarea por su ID
        } finally {
            em.close();
        }

        return task;
    }

    // Método para actualizar los datos de una tarea existente
    public void update(Task task) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(task); // Actualiza la tarea en la base de datos
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Método para eliminar una tarea de la base de datos
    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Task task = em.find(Task.class, id); // Busca la tarea a eliminar
            if (task != null) {
                em.remove(task); // Elimina la tarea si existe
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}