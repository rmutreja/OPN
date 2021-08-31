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
import com.opn.in.entity.Planter;
import com.opn.in.exception.PlanterException;
import com.opn.in.exception.PlanterNotFoundException;
import com.opn.in.service.IPlanterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;

@RestController
@RequestMapping(value = "/planter")
@Api(description="This is Planter Controller to perform operations")
@CrossOrigin(origins="*")
public class PlanterController {
	  
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	//HAS-A Relationship
    @Autowired
    private IPlanterService pservice;
    
    /*{
     	"planterCapacity": 250,
      	"planterColor": 5,
      	"planterCost": 20,
      	"planterId": 1,
      	"planterShape": "Round",
      	"planterStock": 60,
      	"planterheight": 5
      }	
     * http://localhost:8080/planter/addPlanter
     * This url is responsible for adding a planter
     * HTTP Method POST is required
     */
    @PostMapping(value = "/addPlanter")
    @ApiOperation(value="This is addPlanter() method to add Planter to the table")
    public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter) throws PlanterException{
        try {   
//    	Planter add=pservice.addPlanter(planter);
            return new ResponseEntity<Planter>(pservice.addPlanter(planter),HttpStatus.CREATED);
    }catch(Exception e) {
		
		logger.error("Record NOT Added  : " + planter);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
    }

    /*
     * http://localhost:8080/planter/updatePlanter
     * This url is responsible for updating a planter
     * HTTP Method PUT is required
     */
    @PutMapping(value = "/updatePlanter/{planterId}")
    @ApiOperation(value="This is updatePlanter() method to Update Planter to the table")
    public ResponseEntity<Planter> updatePlanter(@RequestBody int planterId) throws PlanterNotFoundException{
    	try { 
//    	Planter update=pservice.addPlanter(planter);
    		Planter pp=pservice.viewPlanter(planterId);
         return new ResponseEntity<Planter>(pservice.updatePlanter(pp),HttpStatus.OK);
    }catch(Exception e) {
		
		logger.error("Record NOT Updated with ID : " + planterId);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
    }

    /*
     * http://localhost:8080/planter/deletePlanter
     * This url is responsible for deleting a planter
     * HTTP Method DELETE is required
     */
    @DeleteMapping(value = "/deletePlanter/{planterId}")
    @ApiOperation(value="This is deletePlanter() method to delete Planter from the table")
    public ResponseEntity<Planter> deletePlanter(@PathVariable Integer planterId) throws PlanterNotFoundException{
    	try { 
//    	Planter delete=pservice.addPlanter(planter);
    		Planter pp=pservice.viewPlanter(planterId);
         return new ResponseEntity<Planter>(pservice.deletePlanter(pp),HttpStatus.OK);
    }catch(Exception e) {
		
		logger.error("Record NOT Deleted with ID : " + planterId);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
    }

    /*
     * http://localhost:8080/planter/viewPlantById
     * This url is responsible for viewing a plant of given ID
     * HTTP Method GET is required
     */
    @GetMapping(value = "/viewPlanterById/{planterId}")
    @ApiOperation(value="This is viewPlanterById() method to view Planter by Id from the table")
    public ResponseEntity<Planter> viewPlanter(@PathVariable int planterId) throws PlanterNotFoundException{
    	try { 
//    	Planter view=pservice.viewPlanter(planterId);
         return new ResponseEntity<Planter>(pservice.viewPlanter(planterId),HttpStatus.OK);
    }catch(Exception e) {
		
		logger.error("Record NOT Found with ID  : " + planterId);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
    }

    /*
     * http://localhost:8080/planter/viewPlanterByPlanterShape
     * This url is responsible for viewing a plant of given common name
     * HTTP Method GET is required
     */
    @GetMapping(value = "/viewPlantByPlanterShape/{planterShape}")
    @ApiOperation(value="This is viewPlanterByShape() method to view Planter by Shape from the table")
    public ResponseEntity<Planter> viewPlanter(@PathVariable String planterShape) throws PlanterNotFoundException{
    	try { 
//    	Planter view=pservice.viewPlanter(PlanterShape);
         return new ResponseEntity<Planter>(pservice.viewPlanter(planterShape),HttpStatus.OK);
    }catch(Exception e) {
		
		logger.error("Record NOT Found with planter shape  : " + planterShape);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
    }

    /*
     * http://localhost:8080/planter/viewAllPlanters
     * This url is responsible for viewing all planters
     * HTTP Method GET is required
     */
    @GetMapping(value = "/viewAllPlanters")
    @ApiOperation(value="This is viewAllPlanters() method to view All Planters from the table")
    public ResponseEntity<List<Planter>> viewAllPlanters() throws PlanterNotFoundException{
    	try { 
//    	List<Planter> all=pservice.viewAllPlanters();
         return new ResponseEntity<List<Planter>>(pservice.viewAllPlanters(),HttpStatus.OK);
    }catch(Exception e) {
		
		logger.error("Record NOT Found");
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
    }

   
}