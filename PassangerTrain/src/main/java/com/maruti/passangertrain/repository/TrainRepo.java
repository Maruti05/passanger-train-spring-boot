package com.maruti.passangertrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maruti.passangertrain.entity.Train;

@Repository
public interface TrainRepo extends JpaRepository<Train, Long>{

}
