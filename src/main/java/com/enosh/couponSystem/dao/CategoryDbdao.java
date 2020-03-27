package com.enosh.couponSystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enosh.couponSystem.entities.Category;
import com.enosh.couponSystem.entities.CategoryType;
import com.enosh.couponSystem.repository.CategoryRepository;

@Component
public class CategoryDbdao {

	private CategoryRepository categoryRepository;

	@Autowired
	public CategoryDbdao(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Optional<Category> findByType(CategoryType type) {
		return categoryRepository.findByType(type);
	}
	
	public Category createOrGetByType(Category category) {
		Optional<Category> maybe = findByType(category.getType());
		if (maybe.isPresent()) {
			return maybe.get();
		}
		return categoryRepository.save(category);
	}
	
	public Category functinalCreateOrGetByType(Category category) {
		return findByType(category.getType())
				.orElseGet(() -> categoryRepository.save(category));
	}
	
}
