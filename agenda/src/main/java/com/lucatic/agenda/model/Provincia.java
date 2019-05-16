package com.lucatic.agenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="provincia")
public class Provincia {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idprovincia;
	private String provincia;
	
	public Provincia() {
		super();
	}

	public Provincia(int idprovincia, String provincia) {
		super();
		this.idprovincia = idprovincia;
		this.provincia = provincia;
	}

	

	public Provincia(String provincia) {
		super();
		this.provincia = provincia;
	}

	public int getIdprovincia() {
		return idprovincia;
	}

	public void setIdprovincia(int idprovincia) {
		this.idprovincia = idprovincia;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Provincia [idprovincia=" + idprovincia + ", provincia=" + provincia + "]";
	}
	
	
	
}
