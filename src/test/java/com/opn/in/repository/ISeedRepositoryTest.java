package com.opn.in.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import com.google.common.base.Optional;
import com.opn.in.entity.Seed;

import antlr.collections.List;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class ISeedRepositoryTest {

@Autowired
private ISeedRepository srepo;

@Test
public void testAddSeed() {
//	try{
		Seed s1=Seed.builder().bloomTime("morning").commonName("xyz").difficultyLevel("easy")
	
			.seedsCost(50d).seedsDescription("medical").seedsPerPacket(10).seedsStock(95)
			.temperature("high").typeOfseeds("omnivorour").watering("moderate").build();
	Seed addedSeed=srepo.save(s1);
	System.out.println("Seed Added:"+addedSeed);
	log.info("Added Seed : {}",addedSeed);
	Assertions.assertThat(addedSeed).isNotNull();
//	}catch(Exception e) {}
}
@Test
public void testUpdateSeed() {
	Seed s1=Seed.builder().bloomTime("morning").commonName("xyz").difficultyLevel("easy")
			.seedsCost(50d).seedsDescription("medical").seedsPerPacket(10).seedsStock(95)
			.temperature("high").typeOfseeds("omnivorour").watering("moderate").build();
	Seed UpdatedSeed=srepo.save(s1);
	System.out.println("Seed Added:"+UpdatedSeed);
	log.info("Added Seed : {}",UpdatedSeed);
	Assertions.assertThat(UpdatedSeed).isNotNull();
}
@Test
public void testDeleteSeed() {
	//Seed s1=Seed.builder().bloomTime("morning").commonName("xyz").difficultyLevel("easy").seedsCost(50d).seedsDescription("medical").seedsPerPacket(10).seedsStock(95).temperature("high").typeOfseeds("omnivorour").watering("moderate").build();
	Seed seed=new Seed();
	java.util.Optional<Seed> deletedSeed=srepo.findById(2);
	System.out.println("Seed Deleted:"+deletedSeed);
	srepo.deleteById(2);
	seed=deletedSeed.get();
	Integer i=seed.getSeedid();
	Assertions.assertThat(i).isNotNull();
}
@Test
public void testViewSeed() {
	Seed s=srepo.findById(3).get();
	System.out.println("Seed by given Id:"+s);
	Assertions.assertThat(s).isNotNull();
	
}

@Test
public void testViewAllSeed() {
	List allseeds= (List) srepo.findAll();
	System.out.println("All Seeds:"+allseeds);
	Assertions.assertThat(allseeds).isNotNull();
}
@Test
public void testViewAllSeeds() {
	List allSeedsbytype=(List) srepo.findAll();
	System.out.println("Seed by given type:"+allSeedsbytype);
	Assertions.assertThat(allSeedsbytype).isNotNull();
}
}