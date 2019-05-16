package com.lucatic.agenda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucatic.agenda.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia,Integer>, ProvinciaRepositoryCustom{

}
