<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
        <link rel="stylesheet" href="css/cssRegister.css">
    </head>
    <body>

        <div class="container-wrap">

            <div class="formulario">
                <caption> 
                    <h1>
                        Registrar Usuario
                    </h1>
                </caption>
                   <fieldset>
                		<form action="addUsuario.jsp" method="post"><!-- Mi compa Vicen es el mejor -->
	                        <label>Usuario</label><br>
	                        <input required type="text" name="usuario" id="usuario" placeholder="Introduzca usuario">
	                        <br>
	                        <br>
	                        <label>Contraseña</label><br>
	                        <input required type="password" name="password" id="password" placeholder="Introduzca una contraseña">
	                        <br>
	                        <br>
                            <label>Nombre</label><br>
	                        <input required type="text" name="nombre" id="nombre" placeholder="Introduzca tu nombre">
	                        <br>
	                        <br>
                            <label>Fecha de nacimiento</label><br>
	                        <input type="date" name="fecha" id="fecha" required>
	                        <br>
	                        <br>
                            <label>Genero</label><br>
	                        <select id="genero" name="genero">
                                <option>Hombre</option>
                                <option>Mujer</option>
                                <option>Otro</option>
                            </select>
	                        <br>
	                        <br>
	                        	<%
		                        String errorMsg = request.getParameter("id");
		                        if (errorMsg!=null){
		                        %>
		                        	<span>Name does exists</span>
		                        <%
		                        }
		                        %>
	                        <input type="submit" >
                		</form>
                		<a href="Index.jsp">
                        	<button>Volver al inicio</button>
                       	</a>
                   </fieldset>
            </div>

        </div>

    </body>
</html>