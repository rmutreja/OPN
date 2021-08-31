package com.opn.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.opn.in.entity.Plant;
//import java.util.List;

@Repository
public interface IPlantRepository extends JpaRepository<Plant, Integer> {

	
	Plant findByCommonName(String commonName);
	
	//List<Plant> findAllByType(String typeOfPlant);
	

}
