package com.lucatic.agenda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lucatic.agenda.model.Persona;
import com.lucatic.agenda.model.Telefono;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer>,PersonaRepositoryCustom {
	
	

}

//public interface UserRepository extends JpaRepository<User,Integer>,UserRepositoryCustom {


