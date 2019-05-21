package com.lucatic.agenda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lucatic.agenda.model.Telefono;

/**
* 
* @author grupo2
* 
* @Version 2.0
* 
* fecha:15/05/2019
* 
* Descripcion:Repositorio para la clase telefono.
* 
* 
*
*/


@Repository
public interface TelefonoRepository extends JpaRepository<Telefono, Integer>{

	
}