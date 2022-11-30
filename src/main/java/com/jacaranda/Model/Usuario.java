package com.jacaranda.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name="Usuarios")
public class Usuario {

	@Id
	private String usuario;
	private String password;
	private Integer admin;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String genero;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UsuarioMaterial> compradores = new ArrayList<>();
	
	public Usuario() {
		
	}
	
	public Usuario(String usuario, String password, Integer admin, String nombre, LocalDate fechaNacimiento, String genero) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.admin = admin;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}
	
	
	
	
	

	
	
	
	//Metodos autogenerados
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", password=" + password + ", admin=" + admin + ", nombre=" + nombre
				+ ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + "]";
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	@Override
	public int hashCode() {
		return Objects.hash(admin, fechaNacimiento, genero, nombre, password, usuario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(admin, other.admin) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(genero, other.genero) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password) && Objects.equals(usuario, other.usuario);
	}
	
	
	
}
