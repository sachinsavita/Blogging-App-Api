package com.blogapp.payloads;

import java.time.LocalDateTime;

public class ApiResponse {
	
	private LocalDateTime timestamp;
	private String message;
	private boolean success;
	
	
	
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	public ApiResponse(LocalDateTime timestamp, String message, boolean success) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.success = success;
	}


	public ApiResponse(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	
	
	public ApiResponse() {
	
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	} 
	
	
	
	

}
