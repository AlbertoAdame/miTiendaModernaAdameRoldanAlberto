package com.jacaranda.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity (name="materiales")
public class Material {

	@Id
	private Integer codigo;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer stock;
	@ManyToOne
	@JoinColumn private Categoria cod_categoria;
	
	@OneToMany(mappedBy = "material", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UsuarioMaterial> materialesVendidos = new ArrayList<>();
	
	public Material() {
		
	}
	
	public Material(Integer codigo, String nombre, String descripcion, Double precio, Integer stock, Categoria cod_categoria) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.cod_categoria = cod_categoria;
	}
	
	public Material(Integer codigo, String nombre, String descripcion, Integer stock, Double precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
	}
	
	
	
	
	
	
	
	
	//Metodos autogenerados
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, cod_categoria, codigo, nombre, precio);
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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


	public void setDescripcion(String categoria) {
		this.descripcion = categoria;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public Categoria getCategoria() {
		return cod_categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.cod_categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Categoria getCod_categoria() {
		return cod_categoria;
	}

	public void setCod_categoria(Categoria cod_categoria) {
		this.cod_categoria = cod_categoria;
	}

	@Override
	public String toString() {
		return "Material [codigo=" + codigo + ", nombre=" + nombre + ", Stock=" + stock+ ", descripcion=" + descripcion + ", precio=" + precio
				+ ", cod_categoria=" + cod_categoria + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(cod_categoria, other.cod_categoria)
				&& Objects.equals(codigo, other.codigo) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio);
	}

	
}
