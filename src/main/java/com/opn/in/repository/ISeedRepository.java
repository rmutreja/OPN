package com.opn.in.repository;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.opn.in.entity.Seed;

@Repository
public interface ISeedRepository extends JpaRepository<Seed,Integer>{


	public Seed findByCommonName(String string);

//	List<Seed> findAllByType(String typeOfseeds);

}
