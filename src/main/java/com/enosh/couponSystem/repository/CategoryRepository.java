package com.enosh.couponSystem.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enosh.couponSystem.entities.Category;
import com.enosh.couponSystem.entities.CategoryType;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

	Optional<Category> findByType(CategoryType type);
}
