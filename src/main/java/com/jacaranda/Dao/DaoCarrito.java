package com.jacaranda.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.jacaranda.Model.Usuario;
import com.jacaranda.Model.UsuarioMaterial;

public class DaoCarrito {

	private Session session = null;
	
	public DaoCarrito() {
		ConnectorDB conectordb = new ConnectorDB();
		session = conectordb.getSession();
	}
	
	public Boolean addItem(UsuarioMaterial usuarioMaterial) {
		boolean added = false;
		session.getTransaction().begin();
		if (usuarioMaterial != null) {
			// Aqui va la transacci�n a realizar
			try {
				session.save(usuarioMaterial);
			} catch (Exception e) {
				session.getTransaction().rollback();
			} 
		}
		// --------------------------------
		session.getTransaction().commit();
		return added;
	}
	
	
	public List<UsuarioMaterial> getUserPurchases(Usuario user){
		
		Query<UsuarioMaterial> query = session.createQuery("SELECT it FROM com.jacaranda.Model.UsuarioMaterial it where Usuario_Id = '"+ user.getUsuario()+"'");
		List<UsuarioMaterial> resultado = query.getResultList();
		
		return resultado;

	}
	
	public List<UsuarioMaterial> getItemList(){
			
		Query<UsuarioMaterial> query = session.createQuery("SELECT it FROM com.jacaranda.Model.UsuarioMaterial it");
		List<UsuarioMaterial> resultado = query.getResultList();
		
		return resultado;
	}
	
}
