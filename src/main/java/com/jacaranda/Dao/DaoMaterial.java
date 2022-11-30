package com.jacaranda.Dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.jacaranda.Exceptions.DaoMaterialException;
import com.jacaranda.Model.Material;




public class DaoMaterial {
	
	private Session session = null;
	
	public DaoMaterial() {
		ConnectorDB conectordb = new ConnectorDB();
		session = conectordb.getSession();
	}
	
	public List<Material> getMateriales() throws Exception {
		
		Query<Material> query = session.createQuery("SELECT it FROM com.jacaranda.Dao.Model.Material it");
		List<Material> resultado = query.getResultList();
		return resultado;
	}
	
	public Material getMaterial(Integer codeMaterial) {
		
		Material material = (Material) session.get(Material.class, codeMaterial);
		return material;
		
	}
	
	public Boolean materialExists(Integer codeMaterial) throws DaoMaterialException {
		Boolean exists = false;
		
		if (codeMaterial != null) {
			Material material = (Material) session.get(Material.class, codeMaterial);
			if (material != null) {
				throw new DaoMaterialException("[ERROR - Material - Material does exist in database]");
			} 
		}
		return exists;
	}
	
	public boolean addMaterial(Material material) {
		boolean added = false;
		try {
			session.getTransaction().begin();
			// Aqui va la transacci�n a realizar
			session.save(material);
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		// --------------------------------
		session.getTransaction().commit();
		return added;
	}
	
	public boolean updateMaterial(Material material) {
		boolean added = false;
		try {
			Material newMaterial = session.get(Material.class, material.getCodigo());
			newMaterial.setStock(material.getStock());
			session.getTransaction().begin();
		// Aqui va la transacci�n a realizar
			session.update(newMaterial);
		} 
		catch (Exception e) {
			session.getTransaction().rollback();
		}
		// --------------------------------
		session.getTransaction().commit();
		return added;
	}
}
