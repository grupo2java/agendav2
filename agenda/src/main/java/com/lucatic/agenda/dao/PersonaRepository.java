package com.lucatic.agenda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucatic.agenda.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer>,PersonaRepositoryCustom {

}

//public interface UserRepository extends JpaRepository<User,Integer>,UserRepositoryCustom {


