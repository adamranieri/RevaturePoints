package dev.ranieri.services;

import java.util.List;
import java.util.Set;

import dev.ranieri.entities.Associate;

public interface AssociateService {
	
	public Associate createAssociate(Associate associate);
	
	public Associate getAssociateById(int id);
	
	public Set<Associate> getAllAssociates();
	
	public Associate updateAssociate(Associate associate);

	public boolean deleteAssociate(Associate associate);
	
	public List<Associate> findByName(String name);

}
