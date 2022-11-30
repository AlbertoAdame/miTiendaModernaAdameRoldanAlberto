<%@page import="com.jacaranda.Model.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="com.jacaranda.Dao.DaoCategoria"%>
<%@page import="com.jacaranda.Dao.DaoUser"%>
<%@page import="com.jacaranda.Model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
        <link rel="stylesheet" href="css/cssRegister.css">
    </head>
    <body>
    	<% 
		try {
			DaoUser daoUser = new DaoUser();
			
			session = request.getSession();
			String userName = (String) session.getAttribute("usuario");
			String login = (String) session.getAttribute("login");
				
			Usuario user = daoUser.getUsuario(userName);
			
			if(userName != null && login !=null) {
				DaoCategoria daoCategoria = new DaoCategoria();
				List<Categoria> categorias = daoCategoria.getCategorias();
    	%>
	        <div class="container-wrap">
	
	            <div class="formulario">
	                <caption> 
	                    <h1>Register material</h1>
	                </caption>
	                   <fieldset>
	                		<form action="addMaterial.jsp" method="post">
		                        <label>Code</label><br>
		                        <input required type="number" maxlength="8" name="codigo" id="codigo" placeholder="Enter the code of the item">
		                        <br>
		                        <br>
		                        <label>Name</label><br>
		                        <input required type="text" maxlength="50" name="name" id="name" placeholder="Enter the name of the item">
		                        <br>
		                        <br>
	                            <label>Description</label><br>
		                        <input required type="text" maxlength="150" name="description" id="description" placeholder="Enter the description of the item">
		                        <br>
		                        <br>
	                            <label>Price</label><br>
		                        <input type="number" step="0.01" name="price" id="price" required>
		                        <br>
		                        <br>
		                        <label>Stock</label><br>
		                        <input type="number" name="stock" id="stock" required>
		                        <br>
		                        <br>
	                            <label>Category</label><br>
		                        <select id="category" name="category">
									<% 
									for(Categoria categoria: categorias) {
										out.println("<option>" + categoria.getNombre() + "</option>");
									}
									%>
	                            </select>
		                        <br>
		                        <br>
		                        <%
		                        String errorMsg = request.getParameter("id");
		                        if (errorMsg!=null){
		                        %>
		                        	<span>Id already exists</span>
		                        <%
		                        }
		                        %>
		                        <input type="submit" >
	                		</form>
	                		<a href="listaMateriales">
	                        	<button>Volver al inicio</button>
	                       	</a>
	                   </fieldset>
	            </div>
	
	        </div>
			<% 
			}
			else{
				response.sendRedirect("./errorPages/ErrorLogin.jsp");
			}
			}
			catch(Exception e){
				response.sendRedirect("./errorPages/Error.jsp");
			}
			%>

    </body>
</html>