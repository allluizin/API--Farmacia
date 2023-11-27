package com.remedios.luiz.repositories;

import com.remedios.luiz.entities.FarmaciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmaciaRepository extends JpaRepository<FarmaciaEntity, Long> {

}
