package com.lucatic.agenda.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.time.LocalDate;


/**
 * @author grupo2
 * 
 * @version 2.0
 * 
 * @date 16/05/2019
 * 
 * @description modelo para la tabla persona de la base de datos , se le añaden listas de telefono y direcciones 
 * 
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idpersona;

	private String apellido1;

	private String apellido2;

	private String dni;
	
	private LocalDate fechanacimiento;

	private String nombre;

	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="persona")
	private List<Direccion> direcciones;

	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="persona")
	private List<Telefono> telefonos;

	public Persona() {
	}
	
	

	public Persona(int idpersona, String apellido1, String apellido2, String dni, LocalDate fechanacimiento, String nombre,
			List<Direccion> direcciones, List<Telefono> telefonos) {
		super();
		this.idpersona = idpersona;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechanacimiento = fechanacimiento;
		this.nombre = nombre;
		this.direcciones = direcciones;
		this.telefonos = telefonos;
	}



	public int getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(LocalDate fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Direccion> getDireccions() {
		return this.direcciones;
	}

	public void setDireccions(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setPersona(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setPersona(null);

		return direccion;
	}

	public List<Telefono> getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Telefono addTelefono(Telefono telefono) {
		getTelefonos().add(telefono);
		telefono.setPersona(this);

		return telefono;
	}

	public Telefono removeTelefono(Telefono telefono) {
		getTelefonos().remove(telefono);
		telefono.setPersona(null);

		return telefono;
	}

	@Override
	public String toString() {
		return "Persona [idpersona=" + idpersona + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni="
				+ dni + ", fechanacimiento=" + fechanacimiento + ", nombre=" + nombre + ", direcciones=" + direcciones
				+ ", telefonos=" + telefonos + "]";
	}

}