package com.lucatic.agenda.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idpersona;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	
	public Persona() {
		super();
	}
	public Persona(String nombre, String apellido1, String apellido2, String dni, LocalDateTime fechanacimiento) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechanacimiento = fechanacimiento;
	}
	//Para formatear la fecha
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime fechanacimiento;
	public int getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public LocalDateTime getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(LocalDateTime fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	@Override
	public String toString() {
		return "Persona [idpersona=" + idpersona + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", dni=" + dni + ", fechanacimiento=" + fechanacimiento + "]";
	}
	
	

}
