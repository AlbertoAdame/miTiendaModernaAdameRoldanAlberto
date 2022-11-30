<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="com.jacaranda.Exceptions.DaoUserException"%>
<%@page import="com.jacaranda.Dao.DaoUser"%>
<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@page import="com.jacaranda.Model.Usuario"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 
	try{
		DaoUser daoUser = new DaoUser(); //
	
		String user = request.getParameter("usuario");
		daoUser.usuarioExists(user);
		
		String password = request.getParameter("password");
		String passEncrypt = DigestUtils.md5Hex(password);
		
		String nombre = request.getParameter("nombre");
		LocalDate fechaNacimiento = LocalDate.parse(String.valueOf((request.getParameter("fecha"))));
		String genero = request.getParameter("genero");
		Usuario usuario = null;
		long edad = ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now()); //Aqui calculamos la edad a partir de la fecha dad
		long mayor = 18;//Esta es la edad la cual debe superar el usuario
	
		
		if(user != null && passEncrypt != null && nombre != null && fechaNacimiento != null && genero != null && edad>=mayor){
			usuario = new Usuario(user,passEncrypt,0,nombre,fechaNacimiento,genero); 
			daoUser.addUsuario(usuario);
			response.sendRedirect("Index.jsp");
		}
		else{
			response.sendRedirect("./errorPages/ErrorUsuario.jsp");
		}
		
	}
	catch (DaoUserException e) {
		response.sendRedirect("Register.jsp?id=false");
	} 
	catch (Exception e) {
		response.sendRedirect("./errorPages/Error.jsp");
	}


%>