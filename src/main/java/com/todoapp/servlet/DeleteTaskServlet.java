package com.todoapp.servlet;

import com.todoapp.dao.TaskDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Servlet para eliminar una tarea específica
@WebServlet("/deleteTask")
public class DeleteTaskServlet extends HttpServlet {

    private TaskDAO taskDAO = new TaskDAO();

    // Método para procesar la petición de eliminación de una tarea
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtiene el ID de la tarea desde los parámetros de la petición
        Long id = Long.parseLong(request.getParameter("id"));
        taskDAO.delete(id); // Elimina la tarea utilizando el DAO

        // Redirige a la página principal de tareas
        response.sendRedirect(request.getContextPath() + "/tasks");
    }
}