package com.jacaranda.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.jacaranda.Model.Categoria;

public class DaoCategoria {

	private Session session = null;
	
	public DaoCategoria() {
		ConnectorDB conectordb = new ConnectorDB();
		session = conectordb.getSession();
	}
	
	public List<Categoria> getCategorias() {
		Query<Categoria> query = session.createQuery("SELECT c FROM com.jacaranda.Model.Categoria c");
		return query.getResultList();
	}
	
	public Integer getCodigoCategoria(String categoriaName) {
		
		Query<Categoria> query = session.createQuery("SELECT c FROM com.jacaranda.Model.Categoria c");
		List<Categoria> categorias = query.getResultList();
		Integer codigo = null;
		for(Categoria categoria : categorias) {
			if(categoria.getNombre().equals(categoriaName)) {
				return categoria.getCodigo();
			}
		}
				
		return codigo;
	}
	
	public Categoria getCategoria(Integer categoriaId) {
		
		Categoria categoria = (Categoria) session.get(Categoria.class, categoriaId);
		
		return categoria;
	}
}
