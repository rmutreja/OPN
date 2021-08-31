package com.opn.in.service;

import com.opn.in.entity.Planter;
import java.util.List;

public interface IPlanterService {

	Planter addPlanter(Planter planter);

	Planter updatePlanter(Planter planter);

	Planter deletePlanter(Planter planter);

	Planter viewPlanter(int planterId);

	Planter viewPlanter(String planterShape);

	List<Planter> viewAllPlanters();

	
}
