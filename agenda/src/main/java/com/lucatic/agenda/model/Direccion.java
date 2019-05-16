package com.lucatic.agenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="direccion")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int iddireccion;
	private String direccion;
	private String codpostal;
	private String localidad;
	
	public Direccion() {}
	
	public int getIddireccion() {
		return iddireccion;
	}

	public void setIddireccion(int iddireccion) {
		this.iddireccion = iddireccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodpostal() {
		return codpostal;
	}

	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return "Direccion [iddireccion=" + iddireccion + ", direccion=" + direccion + ", codpostal=" + codpostal
				+ ", localidad=" + localidad + "]";
	}
	
	

}
