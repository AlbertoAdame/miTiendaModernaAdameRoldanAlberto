<%@page import="com.jacaranda.Model.UsuarioMaterial"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.jacaranda.Model.Material"%>
<%@page import="com.jacaranda.Dao.DaoMaterial"%>
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
</head>
<body>
<% 
	try{
		DaoUser daoUser = new DaoUser();
		DaoMaterial daoMaterial = new DaoMaterial();
		
		Integer cantidad = Integer.valueOf(request.getParameter("cantidad"));
		Integer idMaterial = Integer.valueOf(request.getParameter("id"));
		
		
		session = request.getSession();
		String userName = (String) session.getAttribute("usuario");
		String login = (String) session.getAttribute("login");
		CarritoDeLaCompra carrito = (CarritoDeLaCompra) session.getAttribute("carrito");
			
		Usuario user = daoUser.getUsuario(userName);
		/*----------------------------------------------------------*/
		
		if(carrito!=null){
			// Creamos el material a partir del id de la URL
			Material material = daoMaterial.getMaterial(idMaterial);
			
			if(idMaterial!=null && material.getStock()>0 && cantidad<=material.getStock()){	
				//Creamos el item y lo metemos en el carrito
				UsuarioMaterial itemCarrito = new UsuarioMaterial(user, material, LocalDateTime.now(),material.getPrecio(),cantidad);
				
			    Integer pos = carrito.getListaDeItemDelCarrito().indexOf(itemCarrito);
			    if(pos!=-1){
			    	UsuarioMaterial newItem = carrito.getListaDeItemDelCarrito().get(pos);
			    	newItem.setCantidad(cantidad + newItem.getCantidad());
			    	
			    	
			    }else{
			    	carrito.addListaDeItemDelCarrito(itemCarrito);
			    }
				
				
					
				response.sendRedirect("listaMateriales");
			}
			else{
				response.sendRedirect("./errorPages/ErrorStock.jsp");
			}
		}
		//Si carrito == null -> Creamos carrito
		else{
			
			// Creamos el carrito
			CarritoDeLaCompra newCarrito = new CarritoDeLaCompra();
			
			// Creamos el material a partir del id de la URL
			Material material = daoMaterial.getMaterial(idMaterial);
			
			if(idMaterial!=null && material.getStock()>0 && cantidad<=material.getStock()){
				
				session.setAttribute("carrito", newCarrito);
				
				carrito = (CarritoDeLaCompra) session.getAttribute("carrito");
				
				UsuarioMaterial itemCarrito = new UsuarioMaterial(user, material, LocalDateTime.now(),material.getPrecio(),cantidad);
				
				
				carrito.addListaDeItemDelCarrito(itemCarrito);
				
				
				
				response.sendRedirect("listaMateriales");
			}
			else{
				response.sendRedirect("./errorPages/ErrorStock.jsp");
			}
		}
		
		/*----------------------------------------------------------*/
		
	}catch(Exception e){
		response.sendRedirect("./errorPages/Error.jsp");
	}
%>
</body>
</html>