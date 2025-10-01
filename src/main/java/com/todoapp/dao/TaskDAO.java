package com.todoapp.dao;

import com.todoapp.model.Task;
import com.todoapp.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TaskDAO {

    public void save(Task task) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(task);
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

    public List<Task> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Task> tasks = null;

        try {
            tasks = em.createQuery("SELECT t FROM Task t ORDER BY t.createdAt DESC", Task.class)
                    .getResultList();
        } finally {
            em.close();
        }

        return tasks;
    }

    public Task findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Task task = null;

        try {
            task = em.find(Task.class, id);
        } finally {
            em.close();
        }

        return task;
    }

    public void update(Task task) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(task);
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

    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Task task = em.find(Task.class, id);
            if (task != null) {
                em.remove(task);
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