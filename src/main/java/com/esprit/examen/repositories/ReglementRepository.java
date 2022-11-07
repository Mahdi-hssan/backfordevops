package com.esprit.examen.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.examen.entities.Reglement;

@Repository
public interface ReglementRepository extends CrudRepository<Reglement, Long>{

}
