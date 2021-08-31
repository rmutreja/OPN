package com.opn.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.opn.in.entity.Customer;
import com.opn.in.entity.Plant;
import com.opn.in.exception.PlantException;
import com.opn.in.exception.PlantNotFoundException;
import com.opn.in.service.IPlantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping(value = "/plant")
@Api(description="this is Plant Controller to perform operations")
@CrossOrigin(origins="*")
public class PlantController {
	
	private static final Logger logger = LoggerFactory.getLogger(PlantController.class);	
	
	//HAS-A Relationship
	@Autowired
	private IPlantService pservice;
	
	/*{
		"plantHeight":6,
		"plantSpread":"Medium",
		"commonName":"Rose",
		"bloomTime":"Morning",
		"medicinalOrCulinaryUse":"Yes",
		"difficultyLevel":"Medium",
		"temparature":"Moderate",
		"typeOfPlant":"Medicinal",
		"plantDescription":"Good",
		"plantsStock":40,
		"plantCost":100
	}
	 * http://localhost:8080/plant/addPlant
	 * This url is responsible for adding a plant
	 * HTTP Method POST is required
	 */
    @ApiOperation(value="This is addPlant method() to add plant object to table")
	@PostMapping(value = "/addPlant")
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) throws PlantException{
		try{
//			Plant add=pservice.addPlant(plant);
		
		return new ResponseEntity<Plant>(pservice.addPlant(plant),HttpStatus.CREATED);
	
	}catch(Exception e) {
		
		logger.error("Record NOT Added  : " + plant);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
	
	}	
	
	/*
	 * http://localhost:8080/plant/updatePlant
	 * This url is responsible for updating a plant
	 * HTTP Method POST is required
	 */
    @ApiOperation(value="This is updatePlant method() to update plant object to table")
	@PutMapping(value = "/updatePlant")
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant) throws PlantNotFoundException{
		try{
//			Plant update=pservice.updatePlant(plant);
		
		return new ResponseEntity<Plant>(pservice.updatePlant(plant),HttpStatus.OK);
		}catch(Exception e) {
			
			logger.error("Record NOT Updated  : " + plant);
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	/*
	 * http://localhost:8080/plant/deletePlant
	 * This url is responsible for deleting a plant
	 * HTTP Method DELETE is required
	 */
	@ApiOperation(value="This is deletePlant method() to delete plant object to table")
	@DeleteMapping(value = "/deletePlant/{plantId}")
	public ResponseEntity<Plant> deletePlant(@PathVariable Integer plantId) throws PlantNotFoundException{
		try{
			
		Plant p1=pservice.viewPlant(plantId);
			
		return new ResponseEntity<Plant>(pservice.deletePlant(p1),HttpStatus.OK);
	}catch(Exception e) {
		
		logger.error("Record NOT Deleted with ID : " + plantId);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
	}
	
	/*
	 * http://localhost:8080/plant/viewPlantById
	 * This url is responsible for viewing a plant of given ID
	 * HTTP Method GET is required
	 */
    @ApiOperation(value="This is viewPlant method() to  view plant object from table")
	@GetMapping(value = "/viewPlantById/{plantId}")
	public ResponseEntity<Plant> viewPlant(@PathVariable Integer plantId) throws PlantNotFoundException{
    	try{
//    	Plant view=pservice.viewPlant(plantId);
		return new ResponseEntity<Plant>(pservice.viewPlant(plantId),HttpStatus.OK);
    }catch(Exception e) {
		
		logger.error("Record NOT Found with ID  : " + plantId);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
	}
	
	/*
	 * http://localhost:8080/plant/viewPlantByCommonName
	 * This url is responsible for viewing a plant of given common name
	 * HTTP Method GET is required
	 */
    @ApiOperation(value="This is viewPlantbyCommanName method() to view plant by name in the table")
	@GetMapping(value = "/viewPlantByCommonName")
	public ResponseEntity<Plant> viewPlant(@RequestBody String commonName) throws PlantNotFoundException{
    	try{
//    	Plant view=pservice.viewPlant(commonName);
		return new ResponseEntity<Plant>(pservice.viewPlant(commonName),HttpStatus.OK);
    }catch(Exception e) {
		
		logger.error("Record NOT Found with common name  : " + commonName);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
	}
	
	/*
	 * http://localhost:8080/plant/viewAllPlants
	 * This url is responsible for viewing all plants
	 * HTTP Method GET is required
	 */
    @ApiOperation(value="This is viewAllPlant method() to view plant object from table")
	@GetMapping(value = "/viewAllPlants")
	public ResponseEntity<List<Plant>> viewAllPlants() throws PlantNotFoundException{
    	try{
//    	List<Plant> all=pservice.viewAllPlants();
		return new ResponseEntity<List<Plant>>(pservice.viewAllPlants(),HttpStatus.OK);
    }catch(Exception e) {
		
		logger.error("Record NOT Found");
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
	}
	
	/*
	 * http://localhost:8080/plant/viewALLPlantsByTypeOfPlant
	 * This url is responsible for viewing all plants of given Type of plants
	 * HTTP Method GET is required
	 */
//      @ApiOperation(value="This is viewAllPlant method() to view plant object from table")
//	@GetMapping(value = "/viewALLPlantsByTypeOfPlant")
//	public ResponseEntity<List<Plant>> viewAllPlants(@RequestBody String typeOfPlant) throws PlantNotFoundException{
//		List<Plant> all=pservice.viewAllPlants(typeOfPlant);
//		return new ResponseEntity<List<Plant>>(viewall,HttpStatus.CREATED);
//	}

}