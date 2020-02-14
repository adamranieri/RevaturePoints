package dev.ranieri.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.ranieri.entities.Associate;
import dev.ranieri.repositories.AssociateRepo;

@Component
@Service
public class AssociateServiceImpl implements AssociateService {
	
	@Autowired // ensures that this dependency is fulfilled
	AssociateRepo ar;

	@Override
	public Associate createAssociate(Associate associate) {
		associate = this.ar.save(associate);
		return associate;
	}

	@Override
	public Associate getAssociateById(int id) {
		Associate a = this.ar.findById(id).get();
		return a;
	}

	@Override
	public Set<Associate> getAllAssociates() {
		Set<Associate> associates = new HashSet<Associate>((Collection<? extends Associate>) ar.findAll());
		return associates;
	}

	@Override
	public Associate updateAssociate(Associate associate) {
		associate = ar.save(associate);
		return associate;
	}

	@Override
	public boolean deleteAssociate(Associate associate) {
		ar.delete(associate);
		return true;
	}

	@Override
	public List<Associate> findByName(String name) {
		return ar.findByName(name);
	}

}
