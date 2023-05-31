<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="nombre autor">
    <meta name="description " content="registro de producto ">
    <meta name="keywords" content="registro de producto, formulario de producto, crear producto">
    <title>JSP - login</title>
    <link rel="icon" type="image/x-icon" href="img/gatito.jpg">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/signin.css">

</head>
<body class="text-center">
<div class="container">

    <header>
    </header>
    <nav></nav>
    <section>

        <main class="form-signin w-100 m-auto">
            <form action="" method="post">

                <img class="mb-4" src="./img/gatito.jpg" alt="MY APP " width="100">



                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="name" name="name" placeholder=" Ingrese el nombre de su producto" required autofocus pattern="[A-Za-z ]{2,40}">
                    <label  for="name" >name: </label>
                </div>

                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="value" name="value" placeholder=" Ingrese el precio de su producto" required autofocus pattern="[A-Za-z ]{2,40}">
                    <label  for="value" >value: </label>

                </div>

                <div class="dropdown show">
                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Dropdown link
                    </a>

                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item" href="#">jeans</a>
                        <a class="dropdown-item" href="#">camisas</a>
                        <a class="dropdown-item" href="#">accesorios</a>
                        <a class="dropdown-item" href="#">tennis</a>
                    </div>
                </div>



                <button type="button" class="btn btn-outline-dark">Enviar</button>

                <button  type="button" class="btn btn-outline-dark"><a href="index.jsp"> Regresar</a></button>

                <p class="mt-3 mb-3 text-muted">Todos los derechos reservados MY APP <%=displayDate()%></p>

            </form>
        </main>
    </section>

</div>
<footer></footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3></script>
<%!
    public String displayDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");
Date date = Calendar.getInstance().getTime();
return dateFormat.format(date);
}
%>
</body>

</html>