package com.opn.in.repository;

//import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.opn.in.entity.Plant;

import java.util.List;
import java.util.Optional;

//import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@Slf4j
//@Log4j2
public class IPlantRepositoryTest {
	
	@Autowired
	private IPlantRepository prepo;
	
	@Test
	public void testAddPlant() {
		Plant p1=Plant.builder().plantHeight(20).plantSpread("Medium").commonName("Ros")
				.bloomTime("Morning").medicinalOrCulinaryUse("Yes").difficultyLevel("Medium")
				.temperature("Moderate").typeOfPlant("Medicinall").plantDescription("Good")
				.plantsStock(40).plantCost(100d).build();
		Plant addedPlant=prepo.save(p1);
		//Plant addedPlant=prepo.save(p2);
		System.out.println("Plant Added : "+addedPlant);
		log.info("Added Plant : {}",addedPlant);
		Assertions.assertThat(addedPlant).isNotNull();
		
	}
	
	@Test	
	public void testUpdatePlant(){
		Plant p1=prepo.findById(5).get();
		p1.setPlantHeight(10);
		Plant updatedPlant=prepo.save(p1);
		//Plant updatedPlant=prepo.save(p2);
		System.out.println("Plant Updated : "+updatedPlant);
		log.info("Updated Plant : {}",updatedPlant);
		Assertions.assertThat(updatedPlant).isNotNull();
		Assertions.assertThat(updatedPlant.getPlantHeight()).isEqualTo(10);
		
	}
	
	@Test
	public void testDeletePlant(){
		//Plant p1=Plant.builder().plantHeight(6).plantSpread("Medium").commonName("Rose")
		//		.bloomTime("Morning").medicinalOrCulinaryUse("Yes").difficultyLevel("Medium")
		//		.temperature("Moderate").typeOfPlant("Medicinal").plantDescription("Good")
		//		.plantsStock(40).plantCost(100d).build();
		Plant plant=new Plant();
		Optional<Plant> deletedPlant=prepo.findById(6);
		System.out.println("Plant Deleted : "+deletedPlant);
		prepo.deleteById(6);
		
		
		plant=deletedPlant.get();
		Integer i= plant.getPlantId();
		Assertions.assertThat(i).isNotNull();
				
	}
	
	@Test
	public void testViewPlant(){
		Plant p=prepo.findById(3).get();
		System.out.println("Plant by Given ID : "+p);
		Assertions.assertThat(p).isNotNull();
		
	}
	
	@Test
	public void testViewPlantByCommonName() {
		Plant p=prepo.findByCommonName("Ros");
		System.out.println("Plant by Given Common Name : "+p);
		Assertions.assertThat(p).isNotNull();
		
	}
	
	@Test
	public void testViewAllPlants() {
		List<Plant> allplants=(List<Plant>)prepo.findAll();
		System.out.println("All Plant : "+allplants);
		Assertions.assertThat(allplants).isNotNull();
				
	}
	
//	@Test
//	public void testViewAllPlantss() {
//		List<Plant> allplantsbytype=(List<Plant>)prepo.findAllByType("Medicinall");
//		System.out.println("All Plants of Same Type : "+allplantsbytype);
//		Assertions.assertThat(allplantsbytype).isNotNull();
//		
//	}

}
