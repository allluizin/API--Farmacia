package com.remedios.luiz.repositories;

import com.remedios.luiz.entities.RemedioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RemedioRepository extends JpaRepository<RemedioEntity, Long>{
	
}