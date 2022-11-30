package com.jacaranda.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class UsuarioMaterialID implements Serializable{

	
	private String usuario;
	private Integer material;
	private LocalDateTime fecha;
	
	public UsuarioMaterialID() {
		
	}

	@Override
	public String toString() {
		return "UsuarioMaterialID [usuario=" + usuario + ", material=" + material + ", fecha=" + fecha + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, material, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioMaterialID other = (UsuarioMaterialID) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(material, other.material)
				&& Objects.equals(usuario, other.usuario);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getMaterial() {
		return material;
	}

	public void setMaterial(Integer material) {
		this.material = material;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	
}
