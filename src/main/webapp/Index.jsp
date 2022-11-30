<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
	session.invalidate();
	%>
	
<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
        <link rel="stylesheet" href="css/css.css">
    </head>
    <body>
        <div class="container-wrap">
            <div class="formulario">
                <caption> 
                    <h1>
                        Construcciones Luke
                    </h1>
                </caption>
                   <fieldset>
                		<form action="login" method="post">
	                        <label>Usuario</label><br>
	                        <input required type="text" name="usuario" id="usuario" placeholder="Introduzca usuario">
	                        <br>
	                        <br>
	                        <label>Contraseña</label><br>
	                        <input required type="password" name="password" id="password" placeholder="Introduzca una contraseña">
	                        <br>
	                        <br>
	                        <%
	                        String errorMsg = request.getParameter("id");
	                        if (errorMsg!=null){
	                        %>
	                         <span>Password or User incorrect</span>
	                        <%	
	                        }
	                        %>
	                        <input type="submit" >
                		</form>
                        <a href="Register.jsp">
                        	<button>Registrarse</button>
                       	</a>
                   </fieldset>
            </div>
        </div>
    </body>
</html>
