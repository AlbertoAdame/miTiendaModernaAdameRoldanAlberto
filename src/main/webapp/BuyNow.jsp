<%@page import="com.jacaranda.Dao.DaoMaterial"%>
<%@page import="com.jacaranda.Model.Material"%>
<%@page import="com.jacaranda.Dao.DaoCarrito"%>
<%@page import="com.jacaranda.Model.CarritoDeLaCompra"%>
<%@page import="com.jacaranda.Model.UsuarioMaterial"%>
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
	DaoCarrito daoCarrito = new DaoCarrito();
	DaoMaterial daoMaterial = new DaoMaterial();

	//De aqui sacamos los item para base de datos
	CarritoDeLaCompra carrito = (CarritoDeLaCompra) session.getAttribute("carrito");

	if (carrito.getListaDeItemDelCarrito().size()!=0){
		for(UsuarioMaterial itemCarrito : carrito.getListaDeItemDelCarrito()){
			Material material = itemCarrito.getMaterial();
			
			Integer finalAmount = itemCarrito.getMaterial().getStock()-itemCarrito.getCantidad();
			if(finalAmount<0){
				itemCarrito.setCantidad(itemCarrito.getMaterial().getStock());
				material.setStock(0);
			}else{
				material.setStock(material.getStock()-itemCarrito.getCantidad());	
			}
			
			daoCarrito.addItem(itemCarrito);
			daoMaterial.updateMaterial(material);
			
		}
		carrito.vaciarListaDeItemDelCarrito();
		session.removeAttribute("carrito");
	}
	
	response.sendRedirect("listaMateriales");
	

}catch(Exception e){
	response.sendRedirect("./errorPages/ErrorCartEmpty.jsp");
}
%>

</body>
</html>