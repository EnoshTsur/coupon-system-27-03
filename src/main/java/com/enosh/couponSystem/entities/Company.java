package com.enosh.couponSystem.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Coupon> coupons;
	
	public Company() {}

	public Company(Long id, String email, String password, String name, List<Coupon> coupons) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.coupons = coupons;
	}

	public Company(Long id, String email, String password, String name) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public Company(String email, String password, String name, List<Coupon> coupons) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.coupons = coupons;
	}

	public Company(String email, String name, String password) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", coupons="
				+ coupons + "]";
	}
	
	
	// no args
	
	// all args
	
	// all args no coupons
	
	// all args no id
	
	// all args no id no coupons
	
	// getters & setters
	
	// to string
	
	
	
}
