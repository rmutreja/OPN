package com.opn.in.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

//import com.opn.in.service.PlantServiceImpl;
import com.opn.in.service.IPlantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opn.in.entity.Plant;

@WebMvcTest
public class PlantControllerTest {

	@MockBean
	private IPlantService pservice;
	
	@Autowired
	private MockMvc mvc;
	
	private static ObjectMapper mapper=new ObjectMapper();
	@Test
	public void testSavePlant() throws Exception
	{
		Plant p1=Plant.builder().plantId(2).plantHeight(6).plantSpread("Medium").commonName("Ros")
				.bloomTime("Morning").medicinalOrCulinaryUse("Yes").difficultyLevel("Medium")
				.temperature("Moderate").typeOfPlant("Medicinall").plantDescription("Good")
				.plantsStock(40).plantCost(100d).build();
		
		String json=mapper.writeValueAsString(p1);
		System.out.println(json);
		
		mvc.perform(post("/plant/savePlant")
				    .contentType(MediaType.APPLICATION_JSON)
				    .characterEncoding("utf-8")
				    .content(json)
				    .accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isCreated())
					.andExpect(jsonPath("$.did",Matchers.equalTo(1)))
					.andExpect(jsonPath("$.dname",Matchers.equalTo("Raj")))
					.andExpect(jsonPath("$.specialization",Matchers.equalTo("Nose")))
					;
					
				
	}
	
}