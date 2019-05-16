package com.lucatic.agenda.dao;

import java.util.List;

import com.lucatic.agenda.model.Provincia;

public interface ProvinciaRepositoryCustom {

	List<Provincia> getProvincia(String provincia);
}
