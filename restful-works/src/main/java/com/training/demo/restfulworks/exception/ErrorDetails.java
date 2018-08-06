package com.training.demo.restfulworks.exception;

import java.util.Date;

//this calss will be use for formatiting the exception message
public class ErrorDetails {
	private Date timeStamp;
	private String message;
	private String details;

	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(Date timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
