package com.opn.in.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.opn.in.entity.Plant;
import com.opn.in.repository.IPlantRepository;

@Service
public class PlantServiceImpl implements IPlantService{
	
	private static final Logger logger = LoggerFactory.getLogger(PlantServiceImpl.class);
	
	@Autowired
	private IPlantRepository prepo;
	
	@Override
	public Plant addPlant(Plant plant) {
		Plant add=prepo.save(plant);
		logger.info("Trying to add Plant in service layer "+ add);
		return add;
	}
	
	@Override
	public Plant updatePlant(Plant plant) {
		Plant update=prepo.save(plant);
		logger.info("Trying to update Plant in service layer "+ update);
		return update;
	}
	
	@Override
	public Plant deletePlant(Plant plant) {
		Plant delete=plant;
		prepo.delete(plant);
		logger.info("Trying to delete Plant in service layer "+ delete);
		return delete;
	}
	
	@Override
	public Plant viewPlant(int plantId) {
		Plant view=prepo.getById(plantId);
		logger.info("Trying to fetch Plant in service layer ");
		return view;
	}
	
	@Override
	public Plant viewPlant(String commonName) {
		Plant view=prepo.findByCommonName(commonName);
		logger.info("Trying to fetch Plant by Name in service layer ");
		return view;
	}
	
	@Override
	public List<Plant> viewAllPlants(){
		List<Plant> viewall=prepo.findAll();
		logger.info("Trying to fetch All Plants in service layer ");
		return viewall;
	}
	
//	@Override
//	public List<Plant> viewAllPlants(String typeOfPlant){
//		List<Plant> viewall=prepo.findAllByType(typeOfPlant);
//		logger.info("Trying to fetch All Plants by type in service layer ");
//		return viewall;
//	}
	
	

}
