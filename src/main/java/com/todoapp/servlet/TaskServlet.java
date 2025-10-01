package com.todoapp.servlet;

import com.todoapp.dao.TaskDAO;
import com.todoapp.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// Servlet principal para gestionar las operaciones sobre las tareas
@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {

    private TaskDAO taskDAO = new TaskDAO();

    // Método para mostrar la lista de todas las tareas
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtiene todas las tareas de la base de datos
        List<Task> tasks = taskDAO.findAll();
        request.setAttribute("tasks", tasks);
        // Redirige a la vista JSP para mostrar las tareas
        request.getRequestDispatcher("/tasks.jsp").forward(request, response);
    }

    // Método para procesar las acciones de agregar y cambiar estado de tareas
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtiene el tipo de acción a realizar
        String action = request.getParameter("action");

        // Acción para agregar una nueva tarea
        if ("add".equals(action)) {
            String title = request.getParameter("title");
            String description = request.getParameter("description");

            Task task = new Task(title, description);
            taskDAO.save(task); // Guarda la nueva tarea
        }
        // Acción para cambiar el estado de completitud de una tarea
        else if ("toggle".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            Task task = taskDAO.findById(id);

            if (task != null) {
                task.setCompleted(!task.isCompleted()); // Invierte el estado actual
                taskDAO.update(task); // Actualiza la tarea en la base de datos
            }
        }

        // Redirige a la página principal de tareas
        response.sendRedirect(request.getContextPath() + "/tasks");
    }
}