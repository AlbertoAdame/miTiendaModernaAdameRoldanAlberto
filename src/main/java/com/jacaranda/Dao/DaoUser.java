package com.jacaranda.Dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.jacaranda.Exceptions.DaoUserException;
import com.jacaranda.Model.Usuario;



public class DaoUser {

	private Session session = null;
	
	public DaoUser() {
		ConnectorDB conectordb = new ConnectorDB();
		session = conectordb.getSession();
	}
	
	public boolean userIsValid(String userName, String password) {
	    boolean valid = false;
		if (userName != null && password != null) {
			Usuario user = (Usuario) session.get(Usuario.class, userName);
			if (user != null && password.equals(user.getPassword())) {
				valid = true;
			} 
		}
		return valid;
	}
	
	public Usuario getUsuario(String userName) {
		Usuario user = null;
		if (userName != null) {
			user = (Usuario) session.get(Usuario.class, userName);
		}
		return user;
		
	}
	
	public Boolean usuarioExists(String userName) throws DaoUserException {
		Boolean exists = false;
		if (userName != null) {
			Usuario user = (Usuario) session.get(Usuario.class, userName);
			if (user != null) {
				throw new DaoUserException("[ERROR - User - User does exist in database]");
			} 
		}
		return exists;
	}
	
	public boolean addUsuario(Usuario usuario) {
			boolean added = false;
			session.getTransaction().begin();
			if (usuario != null) {
				// Aqui va la transacci�n a realizar
				try {
					session.save(usuario);
				} catch (Exception e) {
					session.getTransaction().rollback();
				} 
			}
			// --------------------------------
			session.getTransaction().commit();
			return added;
	}
	

	
}
