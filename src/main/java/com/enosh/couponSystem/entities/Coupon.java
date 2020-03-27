package com.enosh.couponSystem.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "coupon")
public class Coupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@ManyToMany(mappedBy = "coupons")
	private List<Customer> customers;
	
	@Column(name = "title", nullable = false, unique = true)
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;
	
	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;
	
	@Column(name = "amount", nullable = false)
	private int amount;
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@Column(name = "image")
	private String image;
	
	public Coupon() {}

	public Coupon(Long id, Company company, Category category, List<Customer> customers, String title,
			String description, LocalDate startDate, LocalDate endDate, int amount, double price, String image) {
		super();
		this.id = id;
		this.company = company;
		this.category = category;
		this.customers = customers;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
	}

	public Coupon(Long id, Company company, Category category, String title, String description, LocalDate startDate,
			LocalDate endDate, int amount, double price, String image) {
		super();
		this.id = id;
		this.company = company;
		this.category = category;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
	}

	public Coupon(Company company, Category category, List<Customer> customers, String title, String description,
			LocalDate startDate, LocalDate endDate, int amount, double price, String image) {
		super();
		this.company = company;
		this.category = category;
		this.customers = customers;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
	}

	public Coupon(Company company, Category category, String title, String description, LocalDate startDate,
			LocalDate endDate, int amount, double price, String image) {
		super();
		this.company = company;
		this.category = category;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", category=" + category + ", title=" + title + ", description=" + description
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", amount=" + amount + ", price=" + price
				+ ", image=" + image + "]";
	}
	
	
	// no args
	
	// all args
	
	// all args no customers
	
	// all args no id
	
	// all args no customers no id
	
	// getters & setters
	
	// to string

}
