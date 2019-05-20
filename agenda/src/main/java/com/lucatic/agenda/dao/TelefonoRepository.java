package com.lucatic.agenda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lucatic.agenda.model.Telefono;

@Repository
public interface TelefonoRepository extends JpaRepository<Telefono, Integer>{

	
}