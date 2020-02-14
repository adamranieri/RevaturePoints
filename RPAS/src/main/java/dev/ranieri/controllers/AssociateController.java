package dev.ranieri.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.ranieri.aspects.Authorized;
import dev.ranieri.entities.Associate;
import dev.ranieri.services.AssociateService;

@Component
@Controller
public class AssociateController {
	
	// RESTful web services
	// its an architecture to creating a web service
	// 6 constraints
	
	// Uniform Naming Conventions
	
	@Autowired
	AssociateService as;
	
	// READ in RESTful servcies  the http verb is used to differentiate 
	// what crud operation you are performing
	@ResponseBody
	@RequestMapping(value = "/associates", method = RequestMethod.GET)
	public Set<Associate> getAllAssociates(){
		return as.getAllAssociates();// automatically turns objects to json
	}
	
	@ResponseBody
	@RequestMapping(value = "/associates/{id}", method = RequestMethod.GET)
	public Associate getAssociate(@PathVariable int id) {
		return as.getAssociateById(id);
	}
	
	//CREATE
	@ResponseBody
	@Authorized
	@RequestMapping(value = "/associates", method = RequestMethod.POST)
	public Associate createAssociate(@RequestBody Associate associate) {
		return as.createAssociate(associate);
	}

	//Delete
	@ResponseBody
	@Authorized
	@RequestMapping(value = "/associates/{id}", method = RequestMethod.DELETE)
	public Boolean deleteAssociate(@PathVariable int id) {
		return as.deleteAssociate(as.getAssociateById(id));
	}
	
	@ResponseBody
	@Authorized
	@RequestMapping(value = "/associates", method = RequestMethod.PUT)
	public Associate updateAssociate(@RequestBody Associate associate) {
		return as.updateAssociate(associate);
	}
	
	@ResponseBody
	@RequestMapping(value = "/associates/query", method = RequestMethod.GET)
	public List<Associate> getAllAssoictesByName(@RequestParam String name){
		return as.findByName(name);
	}
	
	
}
