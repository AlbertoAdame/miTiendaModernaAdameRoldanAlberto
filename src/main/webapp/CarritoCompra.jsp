<%@page import="com.jacaranda.Model.UsuarioMaterial"%>
<%@page import="com.jacaranda.Model.CarritoDeLaCompra"%>
<%@page import="com.jacaranda.Model.Usuario"%>
<%@page import="com.jacaranda.Dao.DaoUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<%
try{
	
	DaoUser daoUser = new DaoUser();
	
	session = request.getSession();
	String userName = (String) session.getAttribute("usuario");
	String login = (String) session.getAttribute("login");
	CarritoDeLaCompra carrito = (CarritoDeLaCompra) session.getAttribute("carrito");
		
	Usuario user = daoUser.getUsuario(userName);
	if(userName != null && login !=null) {
%>				
					<div class="header-container">
						<div class='foto'>
							<img src='assets/fotoPrincipal.png'></img>
							<button onclick="location.href='BuyNow.jsp'">BUY NOW!!</button>
							<button onclick="location.href='CarritoCompra.jsp?vaciar=true'">Clear shopping cart</button>
						</div>
						<div class='titulo'>
							<img src='assets/fotoMedio.png' class='titulo'></img>
						</div>
						
						<div class='login'>
							<button> <img src='assets/fotoPerfil.png'></img>User: <%=user.getNombre() %></button>
							<button onclick="location.href='Index.jsp'">Log out</button>
							<button onclick="location.href='listaMateriales'">Return to shop</button>
						</div>
					</div>
					<hr>
					<div class="container-wrap">
						<table align="center">
							<th><h3>Name</h3></th>
							<th><h3>Price</h3></th>
							<th><h3>Material name</h3></th>
							<th><h3>Description</h3></th>
							<th><h3>Amount</h3></th>
							<th><h3>Date</h3></th>
						
							<%
							Boolean vaciar = Boolean.valueOf(request.getParameter("vaciar"));
							
							if(vaciar == true){
								if(carrito!=null){
									carrito.vaciarListaDeItemDelCarrito();
									carrito = null;
								}
							}
							
							
							if(carrito != null && carrito.getListaDeItemDelCarrito().size() != 0){
								for(UsuarioMaterial itemCarrito : carrito.getListaDeItemDelCarrito()){
									out.println("<tr>");
									out.println("<td>"+ itemCarrito.getUsuario().getNombre() +"</td>");
									out.println("<td>"+ itemCarrito.getPrecio() +"</td>");
									out.println("<td>"+ itemCarrito.getMaterial().getNombre() +"</td>");
									out.println("<td>"+ itemCarrito.getMaterial().getDescripcion() +"</td>");
									out.println("<td>"+ itemCarrito.getCantidad()+"</td>");
									out.println("<td>"+ itemCarrito.getFecha().getDayOfMonth() + " - "
													  + itemCarrito.getFecha().getMonth() + "  /  "
													  + itemCarrito.getFecha().getHour() + ":"
													  + itemCarrito.getFecha().getMinute() +"</td>");
									out.println("</tr>");
								}
							}else{
								out.println("<h1 align='center'>You do not have any item on the shopping cart. Go to buy something!!</h1>");
							}
							%>
						</table>
					</div>
	
<%	
	}
	else{
		response.sendRedirect("./errorPages/ErrorUsuario.jsp");
	}
}
catch(Exception e){
	response.sendRedirect("./errorPages/Error.jsp");
}
%>



</body>
</html>