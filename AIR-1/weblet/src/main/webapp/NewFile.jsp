<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Agregar Tarea</title></head>
<body>
  <h2>Nueva Tarea</h2>
  <form action="addTodo" method="post">
    <label>Título: </label>
    <input type="text" name="titulo" />
    <input type="submit" value="Guardar" />
  </form>
</body>
</html>
