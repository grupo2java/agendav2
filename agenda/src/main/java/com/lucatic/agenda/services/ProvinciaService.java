package com.lucatic.agenda.services;

import java.util.List;

import com.lucatic.agenda.model.Provincia;

public interface ProvinciaService {

	public List<Provincia> list();
	public Provincia get(int id);
	public void update(Provincia provincia);
	public void add(Provincia provincia);
	public void delete(int id);
}
