package com.lucatic.agenda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lucatic.agenda.model.Direccion;

/**
 * 
 * @author grupo2
 * 
 * @Version 2.0
 * 
 * fecha:15/05/2019
 * 
 * Descripcion:Repositorio para la clase direccion.
 * 
 * 
 *
 */


@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer>{
	

}