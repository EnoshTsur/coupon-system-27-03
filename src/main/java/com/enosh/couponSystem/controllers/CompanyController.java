package com.enosh.couponSystem.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enosh.couponSystem.dao.CompanyDbdao;
import com.enosh.couponSystem.entities.Company;
import com.enosh.couponSystem.login.LoginDt;
import com.enosh.couponSystem.response.CouponSystemResponse;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	private CompanyDbdao dao;
	
	@Autowired
	public CompanyController(CompanyDbdao dao) {
		this.dao = dao;
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<CouponSystemResponse<Company>> findById(@PathVariable("id") Long id) {
		Optional<Company> maybe = dao.findById(id);
		return maybe.isPresent() ? 
				
				ResponseEntity.ok(new CouponSystemResponse<Company>(maybe.get(), false, "")) :
					
				ResponseEntity.ok(new CouponSystemResponse<Company>(null, true, "no company by the id " + id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<CouponSystemResponse<Company>> create(@RequestBody Company company) {
		try {
			Company afterSave = dao.save(company);
			return ResponseEntity.ok(
					new CouponSystemResponse<Company>(afterSave, false, "created succuessfully")
			);
			
		} catch (Exception e) {
			return ResponseEntity.ok(
					new CouponSystemResponse<Company>(null, true, e.getMessage())
			);
		}
	}
	
	@GetMapping("/findByEmailAndPasswordP/{email}/{password}")
	public ResponseEntity<CouponSystemResponse<Company>> findByEmailAndPasswordP(
			@PathVariable("email") String email,
			@PathVariable("password") String password){
		Optional<Company> byMailAndPass = dao.findByEmailAndPassword(email, password);
		return byMailAndPass.isPresent() ?
				ResponseEntity.ok(
						new CouponSystemResponse<Company>(byMailAndPass.get(), false, "")
				) :
					
				ResponseEntity.ok(
					new CouponSystemResponse<Company>(null, true, String.format(
							"No company by the email: %s and password: %s", email, password)
							)	
				);
	}
	
	
	// /findByEmailAndPasswordQ?email=hohoho&password=123214
	
	@GetMapping("/findByEmailAndPasswordQ")
	public ResponseEntity<CouponSystemResponse<Company>> findByEmailAndPasswordQ(
			@RequestParam("email") String email, 
			@RequestParam("password") String password) {
		Optional<Company> byMailAndPass = dao.findByEmailAndPassword(email, password);
		return byMailAndPass.map(company -> ResponseEntity.ok(
				new CouponSystemResponse<Company>(company, false, "")
				)).orElse(ResponseEntity.ok(
				new CouponSystemResponse<Company>(null, true, "No Company for you")		
				));
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CouponSystemResponse<Company>> deleteById(@PathVariable("id") Long id){
		try {
			Company afterDelete = dao.deleteById(id);
			return ResponseEntity.ok(
					new CouponSystemResponse<Company>(afterDelete, false, "deleted successfully")
			);
					
		} catch (Exception e) {
			return ResponseEntity.ok(
					new CouponSystemResponse<Company>(null, true, e.getMessage())
			);
		}
	}
	
	@GetMapping("/notcool")
	public String error() {
		String a = null;
		return a.toUpperCase();
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<CouponSystemResponse<Company>> login(@RequestBody LoginDt loginDt) {
		if (loginDt.getEmail() == null || loginDt.getPassword() == null) {
			return ResponseEntity.ok(
					new CouponSystemResponse<Company>(
							null, true, "Email and Password should not be null"
							)
			);
		}
		
		return dao.login(loginDt.getEmail(), loginDt.getPassword()) ?
				ResponseEntity.ok(
					new CouponSystemResponse<Company>(
					dao.findByEmailAndPassword(loginDt.getEmail(), loginDt.getPassword()).get(),
					false,
					"login successfully"
					)	
				):
				
				ResponseEntity.ok(
					new CouponSystemResponse<Company>(null, true, "wrong email or password")	
				);
	
	}
	

}
