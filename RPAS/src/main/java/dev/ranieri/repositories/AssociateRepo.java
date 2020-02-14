package dev.ranieri.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.ranieri.entities.Associate;

@Repository
public interface AssociateRepo  extends CrudRepository<Associate,Integer>{

	List<Associate> findByName(String name);
	List<Associate> findByPointsGreaterThan(int points);
	
}
