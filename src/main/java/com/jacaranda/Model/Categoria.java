package com.jacaranda.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name="categorias")
public class Categoria {
	@Id
	private Integer codigo;
	private String nombre;
	private String descripcion;
	@OneToMany(mappedBy = "cod_categoria", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Material> materiales = new ArrayList<>();
	
	public Categoria() {
		
	}
	
	public Categoria(Integer codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	
	
	
	
	
	
	
	
	
	//Metodos autogenerados
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	
	public List<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, descripcion, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	public void addMaterial(Material material) {
		materiales.add(material);
		material.setCategoria(this);
	}
	public void deleteMaterial(Material material) {
		materiales.remove(material);
		material.setCategoria(null);
	}
	
	
}
