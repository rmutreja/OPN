package com.opn.in.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opn.in.entity.Seed;
import com.opn.in.repository.ISeedRepository;
import java.util.List;

@Service
public class SeedServiceImpl implements ISeedService {
	
	private static final org.slf4j.Logger logger=LoggerFactory.getLogger(SeedServiceImpl.class);
	
	@Autowired
    private ISeedRepository srepo;
	
	@Override
	public Seed addSeed(Seed seed) {
		Seed add=srepo.save(seed);
		logger.info("Trying to add Seed in service layer"+add);
		return add;
	}
	
	
	@Override
	public Seed updateSeed(Seed seed) {
		Seed update=srepo.save(seed);
		logger.info("Trying to update Seed in Service layer"+update);
		return update; 
	}
		
	
	@Override
	public Seed deleteSeed(Seed seed) {
		Seed delete=seed;
		srepo.delete(seed);
		logger.info("Trying to delete Seed in service layer"+delete);
		return delete;
	}
    
	@Override
    public Seed viewSeed(int seedid) 
    {
    Seed view=srepo.getById(seedid);
    logger.info("Trying to fetch Seed in service layer");
    return view;
    }
	
	@Override
	public List<Seed> viewAllSeeds(){
		List<Seed> viewall=srepo.findAll();
		logger.info("Trying to fetch All Seeds in service layer");
		return viewall;
	}
	
	@Override
	public Seed viewSeedByCommonName(String commonName) {
		Seed ss=srepo.findByCommonName(commonName);
		return ss;
	
	}
	
//	@Override
//	public List<Seed> viewAllSeeds(String typeOfseeds){
//    List<Seed> viewAllSeed=srepo.findAll();
//	logger.info("Trying to fetch All Seeds in Service layer");
//	return viewAllSeed;
//
//	}

}
