package com.lucatic.agenda.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * @author grupo2
 * 
 * @version 2.0
 * 
 * @date 16/05/2019
 * 
 * @description el modelo de la clase provincia que representa la tabla provincia de la base de datos 
 * 
 * 
 * The persistent class for the provincia database table.
 * 
 */
@Entity
@NamedQuery(name="Provincia.findAll", query="SELECT p FROM Provincia p")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idprovincia;
	private String provincia;

	public Provincia(String provincia) {
		super();
		this.provincia = provincia;
	}



	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="provincia")
	private List<Direccion> direccions;

	public Provincia() {
	}

	public int getIdprovincia() {
		return this.idprovincia;
	}

	public void setIdprovincia(int idprovincia) {
		this.idprovincia = idprovincia;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setProvincia(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setProvincia(null);

		return direccion;
	}

}