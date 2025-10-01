<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mis Tareas</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 2rem;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background: white;
            border-radius: 20px;
            padding: 2rem;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
        }
        h1 {
            color: #667eea;
            margin-bottom: 2rem;
            text-align: center;
        }
        .form-container {
            background: #f8f9fa;
            padding: 1.5rem;
            border-radius: 10px;
            margin-bottom: 2rem;
        }
        .form-group {
            margin-bottom: 1rem;
        }
        label {
            display: block;
            margin-bottom: 0.5rem;
            color: #333;
            font-weight: 600;
        }
        input[type="text"], textarea {
            width: 100%;
            padding: 0.75rem;
            border: 2px solid #ddd;
            border-radius: 8px;
            font-size: 1rem;
            transition: border-color 0.3s;
        }
        input[type="text"]:focus, textarea:focus {
            outline: none;
            border-color: #667eea;
        }
        textarea {
            resize: vertical;
            min-height: 80px;
        }
        .btn {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 0.75rem 1.5rem;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 1rem;
            transition: transform 0.2s;
        }
        .btn:hover {
            transform: translateY(-2px);
        }
        .task-list {
            list-style: none;
        }
        .task-item {
            background: #f8f9fa;
            padding: 1rem;
            margin-bottom: 1rem;
            border-radius: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            transition: all 0.3s;
        }
        .task-item:hover {
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        }
        .task-item.completed {
            opacity: 0.6;
        }
        .task-content {
            flex: 1;
        }
        .task-title {
            font-weight: 600;
            color: #333;
            margin-bottom: 0.25rem;
        }
        .task-item.completed .task-title {
            text-decoration: line-through;
        }
        .task-description {
            color: #666;
            font-size: 0.9rem;
        }
        .task-actions {
            display: flex;
            gap: 0.5rem;
        }
        .btn-small {
            padding: 0.5rem 1rem;
            font-size: 0.9rem;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: all 0.2s;
        }
        .btn-toggle {
            background: #28a745;
            color: white;
        }
        .btn-toggle:hover {
            background: #218838;
        }
        .btn-delete {
            background: #dc3545;
            color: white;
        }
        .btn-delete:hover {
            background: #c82333;
        }
        .empty-state {
            text-align: center;
            padding: 3rem;
            color: #999;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>📝 Mis Tareas</h1>

    <div class="form-container">
        <form action="<%= request.getContextPath() %>/tasks" method="post">
            <input type="hidden" name="action" value="add">

            <div class="form-group">
                <label for="title">Título de la tarea:</label>
                <input type="text" id="title" name="title" required>
            </div>

            <div class="form-group">
                <label for="description">Descripción:</label>
                <textarea id="description" name="description"></textarea>
            </div>

            <button type="submit" class="btn">➕ Agregar Tarea</button>
        </form>
    </div>

    <c:choose>
        <c:when test="${empty tasks}">
            <div class="empty-state">
                <p>No hay tareas todavía. ¡Agrega tu primera tarea!</p>
            </div>
        </c:when>
        <c:otherwise>
            <ul class="task-list">
                <c:forEach var="task" items="${tasks}">
                    <li class="task-item ${task.completed ? 'completed' : ''}">
                        <div class="task-content">
                            <div class="task-title">${task.title}</div>
                            <div class="task-description">${task.description}</div>
                        </div>
                        <div class="task-actions">
                            <form action="<%= request.getContextPath() %>/tasks" method="post" style="display: inline;">
                                <input type="hidden" name="action" value="toggle">
                                <input type="hidden" name="id" value="${task.id}">
                                <button type="submit" class="btn-small btn-toggle">
                                        ${task.completed ? '↩️ Desmarcar' : '✅ Completar'}
                                </button>
                            </form>

                            <form action="<%= request.getContextPath() %>/deleteTask" method="post" style="display: inline;">
                                <input type="hidden" name="id" value="${task.id}">
                                <button type="submit" class="btn-small btn-delete"
                                        onclick="return confirm('¿Eliminar esta tarea?')">
                                    🗑️ Eliminar
                                </button>
                            </form>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>