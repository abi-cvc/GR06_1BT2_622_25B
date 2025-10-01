package com.todoapp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Clase utilitaria para gestionar la conexión con la base de datos mediante JPA
public class JPAUtil {

    // Fábrica de EntityManager creada a partir de la unidad de persistencia
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("TodoAppPU");

    // Método para obtener una nueva instancia de EntityManager
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para cerrar la fábrica de EntityManager
    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}