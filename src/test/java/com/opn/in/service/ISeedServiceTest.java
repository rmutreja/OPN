package com.opn.in.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.rmi.AccessException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.opn.in.entity.Seed;
import com.opn.in.repository.ISeedRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class ISeedServiceTest {
	@Autowired
	ISeedService sservice;
	@MockBean
	ISeedRepository srepo;
	@Test
	public void addSeedUnitTest()throws AccessException{
		Seed s1=Seed.builder().seedid(1).bloomTime("night").commonName("sdf").difficultyLevel("difficult").seedsCost(60d)
				.seedsDescription("Short").seedsPerPacket(12).seedsStock(75).temperature("high").typeOfseeds("small").watering("Less").build();
		
		when(srepo.save(s1)).thenReturn(s1);
		assertEquals(1,sservice.addSeed(s1).getSeedid());
//		equals(((ISeedService) s1.ssservice).addSeed(s1));
		assertNotNull(sservice.addSeed(s1));
		Seed savedSeed=sservice.addSeed(s1);
		log.info("Added Seed:{}",savedSeed);
		assertNotNull(savedSeed);
		
	}
	@Test
	public void updateSeedUnitTest()throws AccessException{
		Seed s1=Seed.builder().seedid(1).bloomTime("night").commonName("sdf").difficultyLevel("difficult").seedsCost(60d)
				.seedsDescription("long").seedsPerPacket(12).seedsStock(75).temperature("high").typeOfseeds("small").watering("Less").build();
		
		when(srepo.save(s1)).thenReturn(s1);
		assertEquals(1,sservice.addSeed(s1).getSeedid());
//		equals(((ISeedService) s1.ssservice).addSeed(s1));
		assertNotNull(sservice.addSeed(s1));
		Seed savedSeed=sservice.addSeed(s1);
		log.info("Added Seed:{}",savedSeed);
		assertNotNull(savedSeed);
		//Seed updatedSeed=srepo.save(s1);
		//System.out.println("Update Seed:"+updatedSeed);
		//log.info("Updated Seed : {}",updatedSeed);
		//Assertions.assertThat(updatedSeed).isNotNull();
}
}