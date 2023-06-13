package com.example.assignment.demo.exception;

import java.time.LocalDateTime;

public class MyErrorDetail {
	
	private LocalDateTime time;
	private String description;
	private String message;
	
	public MyErrorDetail(LocalDateTime time, String description, String message) {
		super();
		this.time = time;
		this.description = description;
		this.message = message;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MyErrorDetail [time=" + time + ", description=" + description + ", message=" + message + "]";
	}
}
