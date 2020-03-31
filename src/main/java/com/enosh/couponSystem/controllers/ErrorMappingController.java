package com.enosh.couponSystem.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorMappingController implements ErrorController{

	@GetMapping("/error")
	public ResponseEntity handleError(HttpServletRequest request) {
		System.out.println(request);
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.contentType(MediaType.TEXT_PLAIN)
						.body("Where are you?");
			}
			
			if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return ResponseEntity
						.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.contentType(MediaType.TEXT_PLAIN)
						.body("Not cool :(");
			}
		}
		
		return ResponseEntity
				.ok("No errors");
	}
	
	@Override
	public String getErrorPath() {return "/error"; }

}
