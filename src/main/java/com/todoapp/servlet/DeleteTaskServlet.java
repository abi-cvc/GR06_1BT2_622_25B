package com.todoapp.servlet;

import com.todoapp.dao.TaskDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteTask")
public class DeleteTaskServlet extends HttpServlet {

    private TaskDAO taskDAO = new TaskDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        taskDAO.delete(id);

        response.sendRedirect(request.getContextPath() + "/tasks");
    }
}