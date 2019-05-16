package com.lucatic.agenda.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lucatic.agenda.model.Provincia;

@Repository
@Transactional(readOnly=true)
public class ProvinciaRepositoryImpl implements ProvinciaRepositoryCustom{

	@Override
	public List<Provincia> getProvincia(String provincia) {
		// TODO Auto-generated method stub
		return null;
	}

}
