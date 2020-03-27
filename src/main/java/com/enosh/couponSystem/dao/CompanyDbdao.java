package com.enosh.couponSystem.dao;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enosh.couponSystem.entities.Company;
import com.enosh.couponSystem.repository.CompanyRepository;

@Component
public class CompanyDbdao {
	
	private CompanyRepository companyRepository;

	@Autowired
	public CompanyDbdao(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	
	public Company save(Company company) throws Exception  {
		try {
			return companyRepository.save(company);
		} catch(Exception e) {
			throw new Exception("Company alreay exists");
		}
	}
	
	public Optional<Company> findById(Long id) {
		return companyRepository.findById(id);
	}
	
	public Optional<Company> findByEmailAndPassword(String email, String password) {
		return companyRepository.findByEmailAndPassword(email, password);
	}
	
	public Company deleteById(Long id) throws Exception {
		Optional<Company> byId = findById(id);
		if(!byId.isPresent()) {
			throw new Exception("Company does not exists");
		}
		Company company = byId.get();
		companyRepository.delete(company);
		return company;
	}

	
	public Company functionalDeleteById(Long id) throws Exception  {
		return findById(id).map(maybe -> {
			companyRepository.delete(maybe);
			return maybe;
		}).orElseThrow(() -> new Exception("Company does not exists"));
	}
	
	public boolean login(String email, String password) {
		return companyRepository.existsByEmailAndPassword(email, password);
		
	}
}
