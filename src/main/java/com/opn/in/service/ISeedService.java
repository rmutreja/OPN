package com.opn.in.service;

import com.opn.in.entity.Seed;
import java.util.List;

public interface ISeedService {
	public Seed addSeed(Seed seed);

	Seed updateSeed(Seed seed);

	Seed deleteSeed(Seed seed);

	Seed viewSeed(int seedid);

	Seed viewSeedByCommonName(String commonName);

	public List<Seed> viewAllSeeds();

//	public List<Seed> viewAllSeeds(String typeOfseeds);


}
