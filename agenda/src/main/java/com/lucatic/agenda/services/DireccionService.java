package com.lucatic.agenda.services;
import java.util.List;
import com.lucatic.agenda.model.Direccion;


public interface DireccionService {

	public List<Direccion> list();
	public void update(Direccion direc);
	public void add(Direccion direc);
	public void delete(int id);
}
