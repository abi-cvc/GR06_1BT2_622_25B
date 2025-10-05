📝 Todo App - Aplicación Web Java
Aplicación web sencilla de gestión de tareas desarrollada con JSP, Servlets y ORM (JPA/Hibernate).
🛠 Tecnologías Utilizadas

Java 11
JSP (JavaServer Pages) - Para las vistas
Servlets - Para el controlador
JPA/Hibernate - Para el ORM (Object-Relational Mapping)
H2 Database - Base de datos en memoria
Maven - Gestión de dependencias
JSTL - Java Standard Tag Library

📋 Características

✅ Crear nuevas tareas
✅ Listar todas las tareas
✅ Marcar tareas como completadas/incompletas
✅ Eliminar tareas
✅ Persistencia con JPA/Hibernate
✅ Base de datos H2 en memoria

🚀 Cómo Ejecutar
Requisitos Previos

Java JDK 11 o superior
Maven 3.6 o superior
Apache Tomcat 9 o superior


Acceder a la aplicación:

http://localhost:8080/todo-app/
📚 Conceptos Demostrados
1. JSP (JavaServer Pages)

index.jsp - Página de bienvenida
tasks.jsp - Visualización dinámica de tareas con JSTL

2. Servlets

TaskServlet.java - Maneja operaciones CRUD (GET y POST)
DeleteTaskServlet.java - Maneja la eliminación de tareas
Uso de anotaciones @WebServlet
Patrón MVC (Model-View-Controller)

3. ORM (JPA/Hibernate)

Task.java - Entidad mapeada con anotaciones JPA
persistence.xml - Configuración de la unidad de persistencia
TaskDAO.java - Data Access Object para operaciones CRUD
JPAUtil.java - Gestión del EntityManager

🗄 Base de Datos
La aplicación utiliza H2 Database en modo memoria:

No requiere instalación adicional
Los datos se pierden al reiniciar la aplicación
Ideal para desarrollo y demostraciones

📸 Capturas de Pantalla
Página de Inicio
<img width="883" height="496" alt="image" src="https://github.com/user-attachments/assets/67c354d7-968d-4441-8198-425b816a88d7" />

Página de bienvenida con botón para acceder a las tareas.
<img width="883" height="496" alt="image" src="https://github.com/user-attachments/assets/48bf412d-d8b6-4c26-967b-1eafa85fa2bd" />

Lista de Tareas
<img width="921" height="517" alt="image" src="https://github.com/user-attachments/assets/96ab9383-a218-46ae-a168-886ebf6fb290" />


🔍 Flujo de la Aplicación

Usuario accede a / → index.jsp (página de bienvenida)
Usuario hace clic en "Ir a Mis Tareas" → Redirige a /tasks
GET /tasks → TaskServlet.doGet() → Obtiene tareas de BD → tasks.jsp
Usuario agrega tarea → POST /tasks?action=add → TaskServlet.doPost() → Guarda en BD
Usuario marca como completada → POST /tasks?action=toggle → Actualiza en BD
Usuario elimina tarea → POST /deleteTask → DeleteTaskServlet.doPost() → Elimina de BD

💡 Conceptos Clave Implementados
Patrón MVC

Model: Task.java (entidad)
View: index.jsp, tasks.jsp
Controller: TaskServlet.java, DeleteTaskServlet.java

Patrón DAO

Separación de lógica de negocio y acceso a datos
TaskDAO.java encapsula todas las operaciones de base de datos

ORM con JPA

Mapeo objeto-relacional automático
Anotaciones: @Entity, @Id, @GeneratedValue, @Column
JPQL para consultas orientadas a objetos

🎓 Propósito Educativo
Este proyecto demuestra:

✅ Integración de JSP y Servlets
✅ Implementación de ORM con JPA/Hibernate
✅ Operaciones CRUD completas
✅ Arquitectura MVC
✅ Patrón DAO
✅ Gestión de transacciones
✅ Uso de JSTL en JSP

📝 Notas

La base de datos H2 se crea automáticamente al iniciar la aplicación
hibernate.hbm2ddl.auto=update crea/actualiza las tablas automáticamente
Los logs SQL se muestran en consola (hibernate.show_sql=true)
