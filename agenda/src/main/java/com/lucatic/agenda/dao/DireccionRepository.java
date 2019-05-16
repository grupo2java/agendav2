package com.lucatic.agenda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lucatic.agenda.model.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion,Integer>,DireccionRepositoryCustom{

}
