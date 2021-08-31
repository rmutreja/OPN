package com.opn.in.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.opn.in.entity.Seed;
import com.opn.in.exception.SeedException;
import com.opn.in.exception.SeedNotFoundException;
import com.opn.in.service.ISeedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;

@RestController
@RequestMapping(value="/seed")
@Api(description="This is a Seed Controller to perform operations")
@CrossOrigin(origins="*")
public class SeedController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);	
	
	//HAS-A RELATIONSHIP
	@Autowired
	private ISeedService sservice;
	
	/*{
        "bloomTime": "Morning",
        "commonName": "Lily",
        "difficultyLevel": "Moderate",
        "seedid": 1,
        "seedsCost": 10,
        "seedsDescription": "small",
        "seedsPerPacket": 10,
        "seedsStock": 60,
        "temperature": "Medium",
        "typeOfseeds": "Single",
        "watering": "Low"
      }
	 * http://localhost:8080/seed/addseed
	 * This url is responsible for adding a seed
	 * HTTP Method POST is required
	 */
	@PostMapping(value="/addSeed")
    @ApiOperation(value="This is addSeed() method to add seed object to table")
	public ResponseEntity<Seed> addSeed(@RequestBody Seed seed) throws SeedException
	{
		try {
//		Seed add=sservice.addSeed(seed);
		return new ResponseEntity<Seed>(sservice.addSeed(seed),HttpStatus.CREATED);
		}catch(Exception e) {
		
		logger.error("Record NOT Added  : " + seed);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
	}
	
	/*http://localhost:8080/seed/updateSeed
	 * This url is responsible for updating a seed
	 * HTTP Method PUt is required
	 */
	@PutMapping(value="/updateSeed/{seedid}")
    @ApiOperation(value="This is updateSeed() method to update seed object to table")
	public ResponseEntity<Seed> updateSeed(@PathVariable int seedid) throws SeedNotFoundException{
		try {
			Seed ss=sservice.viewSeed(seedid);
//			Seed ss2=sservice.viewSeed(ss);
//		Seed update=sservice.updateSeed(seed);
		return new ResponseEntity<Seed>(sservice.updateSeed(ss),HttpStatus.OK);
		}catch(Exception e) {
		
		logger.error("Record NOT Updated with ID : " + seedid);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
	}
	
	/*
	 * http://localhost:8080/seed/deleteSeed
	 * This url is responsible for deleting a plant
	 * HTTP Method DELETE is required
	 */
	@DeleteMapping(value="/deleteSeed/{seedid}")
    @ApiOperation(value="This is deleteSeed() method to delete seed object to table")
	public ResponseEntity<Seed> deleteSeed(@PathVariable int seedid) throws SeedNotFoundException{
		try {
		Seed delete=sservice.viewSeed(seedid);
		return new ResponseEntity<Seed>(sservice.deleteSeed(delete),HttpStatus.OK);
		}catch(Exception e) {
		
		logger.error("Record NOT Deleted with ID : " + seedid);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
	}
	
	/*
	 * http://localhost:8080/seed/viewSeedById
	 * This url is responsible for viewing a seed of given ID
	 * HTTP Method GET is required
	 */
	@GetMapping(value="/viewSeedById/{seedid}")
    @ApiOperation(value="This is viewSeedById() method to view seed by Id from the table")
	public ResponseEntity<Seed> viewSeed(@PathVariable int seedid) throws SeedNotFoundException{
		try {
//		Seed view=sservice.viewSeed(seedid);
		return new ResponseEntity<Seed>(sservice.viewSeed(seedid),HttpStatus.OK);
		}catch(Exception e) {
			
			logger.error("Record NOT Found with ID  : " + seedid);
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
	}
	
	/*
	 * http://localhost:8080/seed/viewSeedbyCommonName
	 * This url is responsible for viewing a seed of given common name
	 * HTTP Method GET is required
	 */
	@GetMapping(value="/viewSeedbyCommonName/{commonName}")
    @ApiOperation(value="This is viewSeedbyCommonName() method to view seed by commo name from table")
	public ResponseEntity<Seed> viewSeed(@PathVariable String commonName) throws SeedNotFoundException{
		try {
//		Seed view=sservice.viewSeedByCommonName(commonName);
		return new ResponseEntity<Seed>(sservice.viewSeedByCommonName(commonName),HttpStatus.OK);
		}catch(Exception e) {
			
			logger.error("Record NOT Found with common name  : " + commonName);
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
	}
	
	
	/*
	 * http://localhost:8080/seed/viewALLSeeds
	 * This url is responsible for viewing a seed of given common name
	 * HTTP Method GET is required
	 */
	@GetMapping(value="/viewAllSeeds")
    @ApiOperation(value="This is viewAllSeeds() method to view all seeds from table")
	public ResponseEntity<List<Seed>> viewAllSeeds() throws SeedNotFoundException{
		try {
//		List<Seed> all=sservice.viewAllSeeds();
		return new ResponseEntity<List<Seed>>(sservice.viewAllSeeds(),HttpStatus.OK);
		}catch(Exception e) {
		
		logger.error("Record NOT Found");
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
	}
	
	/*
	 * http://localhost:8080/seed/viewALLSeedsByTypeOfSeed
	 * This url is responsible for viewing a seed of given common name
	 * HTTP Method GET is required
	 */
//	@GetMapping(value="/viewAllSeedsByTypeOfSeed")
//    @ApiOperation(value="This is viewAllSeedsByTypeOfSeed() method to view all seeds by type of Seed from table")
//	public ResponseEntity<List<Seed>> viewAllSeeds(@RequestBody String typeOfSeed){
//		List<Seed> all=sservice.viewAllSeeds(typeOfSeed);
//		return new ResponseEntity<List<Seed>>(sservice.viewAllSeeds(typeOfSeed),HttpStatus.OK);
//	
//	}
}