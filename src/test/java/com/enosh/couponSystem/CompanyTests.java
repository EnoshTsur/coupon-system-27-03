package com.enosh.couponSystem;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.enosh.couponSystem.dao.CompanyDbdao;
import com.enosh.couponSystem.entities.Company;

@SpringBootTest
// @ActiveProfiles(profiles = "dev")
class CompanyTests {

	@Autowired
	private CompanyDbdao companyDbdao;
	
	@Test
	void contextLoads() {
	}

	@Test
	void save() {
//		Company company = new Company("teva@roma.com", "teva", "1234");
//		Company company2 = new Company("aroma@roma.com", "aroma", "1234");
//		Company company3 = new Company("menora@roma.com", "menora", "1234");
//		Company company4 = new Company("leumi@roma.com", "leumi", "1234");
//			
//			Arrays.asList(company, company2, company3, company4).forEach(c -> {
//				
//				try {
//					
//					Company current = companyDbdao.save(c);
//					System.out.println(current);
//					
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//				
//			});
//		
	}
	
	@Test
	void findById() {
//		Optional<Company> company = companyDbdao.findById(7L);
//		
//		if (company.isPresent()) {
//			Company fromOptional = company.get();
//			System.out.println(fromOptional.getEmail());
//		}
		
//		companyDbdao.findById(7L).ifPresent(System.out::println);
	}
	
	
	@Test
	void deleteById() {
		
//		try {
//			
//			Company deleted = companyDbdao.deleteById(8L);
//			System.out.println(deleted);
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
	}
	
	
	@Test
	void findByEmailAndPassword() {
//		companyDbdao.findByEmailAndPassword("teva@roma.com", "1234")
//		.ifPresent(System.out::println);
	}
	
	@Test 
	void login() {
		System.out.println(
				companyDbdao.login("teva@roma.com", "1234")
		);
	}
	
	
}
