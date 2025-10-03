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

📂 Estructura del Proyecto
todo-app/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/todoapp/
│       │       ├── model/Task.java          (Entidad JPA)
│       │       ├── dao/TaskDAO.java         (Acceso a datos)
│       │       ├── servlet/
│       │       │   ├── TaskServlet.java     (Controlador principal)
│       │       │   └── DeleteTaskServlet.java
│       │       └── util/JPAUtil.java        (Configuración JPA)
│       ├── resources/
│       │   └── META-INF/persistence.xml     (Configuración ORM)
│       └── webapp/
│           ├── WEB-INF/web.xml
│           ├── index.jsp                    (Página de inicio)
│           └── tasks.jsp                    (Lista de tareas)
└── pom.xml
🚀 Cómo Ejecutar
Requisitos Previos

Java JDK 11 o superior
Maven 3.6 o superior
Apache Tomcat 9 o superior

Pasos de Instalación

Clonar el repositorio:

bashgit clone https://github.com/tu-usuario/todo-app.git
cd todo-app

Compilar el proyecto:

bashmvn clean package

Desplegar en Tomcat:

Copiar el archivo target/todo-app-1.0-SNAPSHOT.war a la carpeta webapps de Tomcat
O usar el plugin de Maven:



bashmvn tomcat7:deploy

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

Cambiar a una base de datos persistente
Para usar MySQL u otra base de datos, modificar persistence.xml:
xml<!-- MySQL -->
<property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/tododb"/>
<property name="javax.persistence.jdbc.user" value="root"/>
<property name="javax.persistence.jdbc.password" value="password"/>
<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
Y agregar la dependencia en pom.xml:
xml<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
📸 Capturas de Pantalla
Página de Inicio
Página de bienvenida con botón para acceder a las tareas.
Lista de Tareas

Formulario para agregar nuevas tareas
Lista de tareas con opciones para completar y eliminar
Tareas completadas se muestran tachadas

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

📄 Licencia
Este proyecto es de código abierto y está disponible para fines educativos.
👨‍💻 Autor
