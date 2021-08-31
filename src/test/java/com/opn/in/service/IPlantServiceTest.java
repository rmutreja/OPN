package com.opn.in.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

//import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import static org.mockito.Mockito.when;

//import org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.*;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.opn.in.entity.Plant;
import com.opn.in.exception.PlantException;
import com.opn.in.repository.IPlantRepository;
//import com.opn.in.service.IPlantService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class IPlantServiceTest {
	
		@Autowired
	    IPlantService pservice;
		
		@MockBean
		IPlantRepository prepo;
	    
//		public Plant addPlant(Plant plant);
//		public Plant updatePlant(Plant plant);
//		public Plant deletePlant(Plant plant);
//		public Plant viewPlant(int plantId);
//		public Plant viewPlant(String commonName);
//		public List<Plant> viewAllPlants();
//		public List<Plant> viewAllPlants(String typeOfPlant);
		
		@Test
	    public void addPlantUnitTest() throws PlantException
	    {
	       
			Plant p1=Plant.builder().plantId(2).plantHeight(6).plantSpread("Medium").commonName("Ros")
					.bloomTime("Morning").medicinalOrCulinaryUse("Yes").difficultyLevel("Medium")
					.temperature("Moderate").typeOfPlant("Medicinall").plantDescription("Good")
					.plantsStock(40).plantCost(100d).build();
	    	
			when(prepo.save(p1)).thenReturn(p1);
			Plant p2=pservice.addPlant(p1);
			
			//assertEquals(2,p2.getPlantId());
			assertEquals(p1,p2);
			assertNotNull(p2);
	    	
 
	    }
	    
	    @Test
	    public void updatePlantUnitTest()
	    {
//	        Plant Plant = new Plant();
//	        Plant.setPlantId(1);
//	        Plant.setPlantName("Mohit");
//	        Plant.setPlantGender("Male");
//	        Plant.setMobileNumber("9234455448");
//	        Plant.setEmail("mohit188@gmail.com");
	        
	    	Plant p1=Plant.builder().plantHeight(6).plantSpread("Medium").commonName("Ros")
					.bloomTime("Morning").medicinalOrCulinaryUse("Yes").difficultyLevel("Medium")
					.temperature("Moderate").typeOfPlant("Medicinall").plantDescription("Good")
					.plantsStock(40).plantCost(100d).build();
	   	 	
	    	when(prepo.save(p1)).thenReturn(p1);
	    	
			//assertEquals(1,pservice.addPlant(p1).getPlantId());
			assertEquals(p1,pservice.addPlant(p1));
			assertNotNull(pservice.addPlant(p1));
	    	
	   	 	Plant savedPlant = pservice.addPlant(p1);
			log.info("Added Plant : {}",savedPlant);
	    	assertNotNull(savedPlant);
	    	
	    	Plant updatedPlant = pservice.updatePlant(p1);
			log.info("Updated Plant : {}",updatedPlant);
	        assertNotNull(updatedPlant);
	    }
	    
	    @Test
	    public void getAllPlantUnitTest()
	    {
	    	List<Plant> pp=prepo.findAll();
	    	when(pp).thenReturn(pp);
	    	
			//assertEquals(pp,pservice.viewAllPlants());
			
	    	assertEquals(pp,pservice.viewAllPlants());
			assertNotNull(pservice.viewAllPlants());
	    	
//	   	 	Plant savedPlant = pservice.addPlant(p1);
//			log.info("Added Plant : {}",savedPlant);
//	    	assertNotNull(savedPlant);
//	    	
//	    	List<Plant> p1=pservice.viewAllPlants();
//	        assertNotNull(p1, "All Plants By ID Found!!");
	    }
//	    
//	    @Test
//	    public void getAllPlantByTypeUnitTest()
//	    {
//	    	List<Plant> p1=prepo.findAllByType("Medicinall");
//	    	when(p1).thenReturn(p1);
//	    	
//			//assertEquals(pp,pservice.viewAllPlants("Medicinal"));
//			
//	    	List<Plant> p2=pservice.viewAllPlants("Medicinall");
//	    	assertEquals(p1,p2);
//			assertNotNull(p2);
//	    	
////	    	List<Plant> p1=pservice.viewAllPlants("Medicinall");
////	        assertNotNull(p1, "All Plants By Name Found!!");
//	    }
	    
	    @Test
	    public void getPlantByIdUnitTest()
	    {
	    	Plant p1=prepo.getById(2);
	    	when(p1).thenReturn(p1);
	    	Plant p3=pservice.viewPlant(2);
			
	    	//assertEquals(2,p3.getPlantId());
			assertEquals(p1,p3);
			//assertNotNull(p3);
	    	
//	    	Plant p1=pservice.viewPlant(1);
//	    	Assertions.assertThat(p1).isNotNull();
//	        assertNotNull(p1, "Plant By ID Found!!");
	        //assertTrue(pservice.viewPlant(1).isPresent());

	    }
	    
	    @Test
	    public void getPlantByNameUnitTest()
	    {
	    	Plant p1=prepo.findByCommonName("Ros");
	    	when(p1).thenReturn(p1);
	    	Plant p2=pservice.viewPlant("Ros");
			
	    	//assertEquals("Ros",p2.getTypeOfPlant());
			assertEquals(p1,p2);
			//assertNotNull(p2);
	    	
//	    	Plant p1=pservice.viewPlant("Rose");
//	    	Assertions.assertThat(p1).isNotNull();
//	        assertNotNull(p1, "Plant By Name Found!!");
	        //assertTrue(pservice.viewPlant(1).isPresent());

	    }
	    
	    @Test
	    public void deletePlantUnitTest()
	    {
//	    	Plant p1=Plant.builder().plantHeight(6).plantSpread("Medium").commonName("Ros")
//					.bloomTime("Morning").medicinalOrCulinaryUse("Yes").difficultyLevel("Medium")
//					.temperature("Moderate").typeOfPlant("Medicinall").plantDescription("Good")
//					.plantsStock(40).plantCost(100d).build();
	    	Plant p1=prepo.getById(2);
	    	
	    	//when(prepo.delete(p1)).thenReturn(p1);
			Plant p2=pservice.addPlant(p1);
			
			//assertEquals(2,p2.getPlantId());
			assertEquals(p1,p2);
			assertNotNull(p2);
	    	
	    	Plant deletedPlant=pservice.deletePlant(p1);
			log.info("Updated Plant : {}",deletedPlant);
	    	//Assertions.assertThat(deletedPlant).isNotNull();
	    }

}



