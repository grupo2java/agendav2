package com.lucatic.agenda.dao;

import java.util.List;

import com.lucatic.agenda.model.Direccion;

public interface DireccionRepositoryCustom {
	List<Direccion> getFirstDireccion(String direccion);

}
