package dev.ranieri.app;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.ranieri.entities.Associate;
import dev.ranieri.repositories.AssociateRepo;

@SpringBootTest
@Transactional // each test method is a transaction. It will automatically rollback
// any changes to the database made in a test
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RpasApplicationTests {
	
	@Autowired // tells spring to find a bean to fulfill this dependency
	AssociateRepo ar;
		
	@Test
	@Commit
	@Order(1)
	void addStevens() {
		Associate a = new Associate();
		a.setName("Stevens");
		a.setPoints(8000);
		ar.save(a);
	}
	
	@Test
	@Rollback
	@Order(2)
	void addKate() {
		Associate a = new Associate();
		a.setName("Kate");
		a.setPoints(7311);
		ar.save(a);
	}
	
	@Test
	@Commit
	@Order(3)
	void addSarah() {
		Associate a = new Associate();
		a.setName("Sarah");
		a.setPoints(9001);
		ar.save(a);
	}
	
//	@Test
//	@Commit
//	@Order(4)
//	void deleteKate() {
//		Associate kate = ar.findById(1).get();
//		System.out.println(kate);	
//		ar.delete(kate);
//	}
//	
	@Test
	@Commit
	@Order(4)
	void updateStevens() {
		Associate stevens = ar.findById(2).get();
		System.out.println(stevens);	
		stevens.setPoints(14);
		ar.save(stevens);
		
	}

	@Test
	@Order(5)
	void findByName() {
		List<Associate> stevenss = ar.findByName("Stevens");		
		System.out.println(stevenss);
	}
	
	@Test
	@Order(6)
	void findByPoints() {
		List<Associate> associates = ar.findByPointsGreaterThan(9000);		
		System.out.println(associates);
	}
	

}
