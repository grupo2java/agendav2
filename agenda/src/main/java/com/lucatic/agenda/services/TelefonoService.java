package com.lucatic.agenda.services;

import java.util.List;


import com.lucatic.agenda.model.Telefono;

public interface TelefonoService {
	
	public List<Telefono> list();
	public void update(Telefono tel);
	public void add(Telefono tel);
	public void delete(int id);

}
