package com.lucatic.agenda.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lucatic.agenda.dao.DireccionRepository;
import com.lucatic.agenda.model.Direccion;


@Service
@Transactional
public class DireccionServiceImpl implements DireccionService{

	@Autowired
	private DireccionRepository direccionDAO;
	
	
	@Override
	public List <Direccion> list() {
		// TODO Auto-generated method stub
		return direccionDAO.findAll();
	}

	@Override
	public void update(Direccion direc) {
		// TODO Auto-generated method stub
		direccionDAO.save(direc);
		
	}

	@Override
	public void add(Direccion direc) {
		// TODO Auto-generated method stub
		direccionDAO.save(direc);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		direccionDAO.deleteById(id);
		
	}

}