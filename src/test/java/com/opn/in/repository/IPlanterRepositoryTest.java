package com.opn.in.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.opn.in.entity.Plant;
import com.opn.in.entity.Planter;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@Slf4j
//@Log4j2
public class IPlanterRepositoryTest {
	
	@Autowired
	private IPlanterRepository prepo;
	
	@Test
	public void testAddPlanter() {
		Planter p1=Planter.builder().planterheight(20).planterCapacity(20).drinageHoles(3)
				.planterColor(2).planterShape("Square").planterCost(50).planterStock(100).build();
		Planter addedPlanter=prepo.save(p1);
		//Plant addedPlant=prepo.save(p2);
		System.out.println("Planter Added : "+addedPlanter);
		log.info("Added Planter : {}",addedPlanter);
		Assertions.assertThat(addedPlanter).isNotNull();
		
	}
}	