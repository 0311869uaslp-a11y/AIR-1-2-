<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!--para entrar es en form.jsp-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form HELLO WORLD</title>
</head>
<body>
    <h2>Enter your name :</h2>
    <form action="helloWorld" method="post"> <!--clase metodo helloworld, se referencia aqui el servlet-->
        <input type="text" name="name" placeholder="name" />
        <input type="submit" value="Envoyer" />
    </form>
</body>
</html>