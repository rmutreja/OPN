package com.opn.in.service;

import java.util.List;
import com.opn.in.entity.Plant;

public interface IPlantService {
	
	public Plant addPlant(Plant plant);
	public Plant updatePlant(Plant plant);
	public Plant deletePlant(Plant plant);
	public Plant viewPlant(int plantId);
	public Plant viewPlant(String commonName);
	public List<Plant> viewAllPlants();
//	public List<Plant> viewAllPlants(String typeOfPlant);

}
