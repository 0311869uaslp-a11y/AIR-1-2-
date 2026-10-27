<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Agregar Tarea</title></head>
<body>
  <h2>Nueva Tarea</h2>
  <form action="addTodo" method="post">
    <input type="text" name="titulo" placeholder="Escribe tu tarea" />
    <input type="submit" value="Guardar" />
  </form>
  <hr>
  <a href="TodoList.jsp">Ver lista de tareas</a>
</body>
</html>
