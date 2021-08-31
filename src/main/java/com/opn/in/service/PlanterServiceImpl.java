package com.opn.in.service;

import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opn.in.entity.Planter;
import com.opn.in.repository.IPlanterRepository;
import java.util.List;

@Service
public class PlanterServiceImpl implements IPlanterService {
	private static final org.slf4j.Logger logger=LoggerFactory.getLogger(IPlanterService.class);
	
	@Autowired
    private IPlanterRepository prepo;
	
	@Override
	public Planter addPlanter(Planter planter) {
		Planter add=prepo.save(planter);
		logger.info("Trying to add Planter in service layer"+add);
		return add;
		
	}


	@Override
	public Planter updatePlanter(Planter planter) {
		Planter update=prepo.save(planter);
		logger.info("Trying to update Planter in Service layer"+update);
		return update; 
	}


	@Override
	public Planter deletePlanter(Planter planter) {
		Planter delete=planter;
		prepo.delete(planter);
		logger.info("Trying to delete Seed in service layer"+delete);
		return delete;
	}

	
	@Override
	public Planter viewPlanter(int planterId) {
		
		 Planter view=prepo.getById(planterId);
		    logger.info("Trying to fetch Seed in service layer");
		    return view;
	}

	
	@Override
	public Planter viewPlanter(String planterShape) {
		List<Planter> p1=prepo.findAll();
		List<Planter> p2=(p1).stream().filter(seed -> seed.getPlanterShape().equals(planterShape))
				.collect(Collectors.toList());
			
			return p2.get(0);
			
	}


	@Override
	public List<Planter> viewAllPlanters() {
		List<Planter> planters=prepo.findAll();
		return planters;
	}

}
