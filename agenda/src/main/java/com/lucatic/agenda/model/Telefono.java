package com.lucatic.agenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author grupo2Lucatic
 * 
 * @version 1.0
 * 
 * 
 *
 */


@Entity
@Table(name="telefono")
public class Telefono {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idtelefono;
	private String telefono;
	
	public Telefono() {}

	public int getIdtelefono() {
		return idtelefono;
	}

	public void setIdtelefono(int idtelefono) {
		this.idtelefono = idtelefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Telefono [idtelefono=" + idtelefono + ", telefono=" + telefono + "]";
	}
	
}
