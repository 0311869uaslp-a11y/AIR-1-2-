<!DOCTYPE html>
<html>
<head>
    <title>Gestion Annonce</title>
</head>
<body>
    <h2>Insertar anuncio</h2>
    <form action="annonce" method="post">
        <input type="hidden" name="action" value="insert"/>
        Título: <input type="text" name="title"/><br/>
        Descripción: <input type="text" name="description"/><br/>
        Dirección: <input type="text" name="adress"/><br/>
        Mail: <input type="text" name="mail"/><br/>
        <input type="submit" value="Insertar"/>
    </form>

    <h2>Actualizar anuncio</h2>
    <form action="annonce" method="post">
        <input type="hidden" name="action" value="update"/>
        ID: <input type="text" name="id"/><br/>
        Nuevo título: <input type="text" name="title"/><br/>
        Nueva descripción: <input type="text" name="description"/><br/>
        Nueva dirección: <input type="text" name="adress"/><br/>
        Nuevo mail: <input type="text" name="mail"/><br/>
        <input type="submit" value="Actualizar"/>
    </form>

    <h2>Eliminar anuncio</h2>
    <form action="annonce" method="post">
        <input type="hidden" name="action" value="delete"/>
        ID: <input type="text" name="id"/><br/>
        <input type="submit" value="Eliminar"/>
    </form>
</body>
</html>
