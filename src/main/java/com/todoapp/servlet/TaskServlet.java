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

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {

    private TaskDAO taskDAO = new TaskDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Task> tasks = taskDAO.findAll();
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("/tasks.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String title = request.getParameter("title");
            String description = request.getParameter("description");

            Task task = new Task(title, description);
            taskDAO.save(task);
        }
        else if ("toggle".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            Task task = taskDAO.findById(id);

            if (task != null) {
                task.setCompleted(!task.isCompleted());
                taskDAO.update(task);
            }
        }

        response.sendRedirect(request.getContextPath() + "/tasks");
    }
}