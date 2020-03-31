package com.enosh.couponSystem.response;


public class CouponSystemResponse<T> {

	private T entity;
	
	private boolean isEmpty;
	
	private String message;

	public CouponSystemResponse() {}
	
	public CouponSystemResponse(T entity, boolean isEmpty, String message) {
		this.entity = entity;
		this.isEmpty = isEmpty;
		this.message = message;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
