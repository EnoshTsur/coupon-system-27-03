package com.enosh.couponSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "type", nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
	private CategoryType type;
	
	public Category() {}

	public Category(Long id, CategoryType type) {
		super();
		this.id = id;
		this.type = type;
	}

	public Category(CategoryType type) {
		super();
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoryType getType() {
		return type;
	}

	public void setType(CategoryType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", type=" + type + "]";
	}
	
	
	// no args 
	
	// all args
	
	// all args no id
	
	// getters & setters
	
	// to string

}
