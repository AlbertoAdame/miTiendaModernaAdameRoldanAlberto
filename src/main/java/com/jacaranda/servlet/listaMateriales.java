package com.jacaranda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.Dao.DaoCategoria;
import com.jacaranda.Dao.DaoMaterial;
import com.jacaranda.Dao.DaoUser;
import com.jacaranda.Model.Categoria;
import com.jacaranda.Model.Material;
import com.jacaranda.Model.Usuario;

/**
 * Servlet implementation class listaMateriales
 */
@WebServlet("/listaMateriales")
public class listaMateriales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listaMateriales() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			DaoUser daoUser = new DaoUser();
			
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("usuario");
			String login = (String) session.getAttribute("login");
				
			Usuario user = daoUser.getUsuario(userName);
			
			if(userName != null && login !=null) {
				
				DaoCategoria daoCategoria = new DaoCategoria();
				List<Categoria> categorias = daoCategoria.getCategorias();
				
				try(PrintWriter out = response.getWriter()) {
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>");
					
					out.println("<link rel=\"stylesheet\" href=\"./css/style.css\">\r\n");
					
					out.println("</head>");
					out.println("<body>");
					
					out.println("<div class=\"header-container\">");
					
						out.println("<div class='foto'>");
							out.println("<img src='assets/fotoPrincipal.png'></img>");
							
							if(user.getAdmin()==1) {
								out.println("<button onclick=\"location.href='RegisterMaterial.jsp'\">Add stuff</button>");
							}
							out.println("<button onclick=\"location.href='VerCompras.jsp'\">Check your stuff</button>");
						out.println("</div>");
						
						out.println("<div class='titulo'>");
							out.println("<img src='assets/fotoMedio.png' class='titulo'></img>");
						out.println("</div>");
						
						out.println("<div class='login'>");
							out.println("<button> <img src='assets/fotoPerfil.png'></img>User: "+ user.getNombre() +"</button>");
							out.println("<button onclick=\"location.href='Index.jsp'\">Log out</button>");
							out.println("<button onclick=\"location.href='CarritoCompra.jsp'\">Shopping cart</button>");
						out.println("</div>");
					
					out.println("</div>");
					
					out.println("<hr>");
						
					
					
					out.println("<div class='container-wrap'>");
						out.println("<h1>Our materials</h1>");

						out.println("<table align='center'>");
						
						
						out.println("<th><h3>CODE</h3></th>");
						out.println("<th><h3>NAME</h3></th>");
						out.println("<th><h3>DESCRIPTION</h3></th>");
						out.println("<th><h3>PRICE</h3></th>");
						out.println("<th><h3>CATEGORY</h3></th>");
						out.println("<th><h3>STOCK</h3></th>");
						out.println("<th><h3>AMOUNT</h3></th>");
						out.println("<th><h3>ADD TO CART</h3></th>");
						//Listado de materiales con su codigo de categoria
						for(Categoria categoria: categorias) {
							for(Material material: categoria.getMateriales()) {
								
								out.println("<form method='GET' action='addToCarrito.jsp'>");
								out.println("<tr><td>"+ material.getCodigo()+ "<input type='hidden' name='id' id='id' value='"+ material.getCodigo()+"'>" +"</td>");
								out.println("<td>"+ material.getNombre() +"</td>");
								out.println("<td>"+ material.getDescripcion() +"</td>");
								out.println("<td>"+ material.getPrecio() +"</td>");
								out.println("<td>"+ material.getCategoria().getNombre() + " - " + material.getCategoria().getCodigo() +"</td>");
								out.println("<td>"+ material.getStock() +"</td>");
								out.println("<td><input name='cantidad' id='cantidad' type='number' min='0' value=1 placeholder='Amount'></td>");
								out.println("<td><input type='submit' value='Add'></td></tr>");
								out.println("</form>");
								
							}
						}
						
						
						
						out.println("</table>");
					
						out.println("</div>");
					
					out.println("</body>");
					out.println("</html>");
				} 
				catch (Exception e) {
					System.out.println("[ERROR al enviar formulario]");
					response.sendRedirect("./errorPages/Error.jsp");
				}
				}else {
					response.sendRedirect("./errorPages/ErrorLogin.jsp");
				}
				
			}
		catch (Exception e) {
			System.out.println("[ERROR al enviar formulario]");
			response.sendRedirect("./errorPages/Error.jsp");
		}
		
		//Final del codigo
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("./errorPages/Error.jsp");
		
	}

}
