package com.enosh.couponSystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.enosh.couponSystem.dao.CategoryDbdao;
import com.enosh.couponSystem.entities.Category;
import com.enosh.couponSystem.entities.CategoryType;
import com.enosh.couponSystem.entities.Coupon;

@SpringBootTest
class CategoryTests {

	@Autowired
	private CategoryDbdao categoryDbdao;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void createOrGet() {
		
		Category category = categoryDbdao
				.functinalCreateOrGetByType(new Category(CategoryType.FOOD));
		
		System.out.println(category);
		
	}

}
