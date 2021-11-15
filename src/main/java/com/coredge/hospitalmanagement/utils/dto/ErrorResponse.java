package com.coredge.hospitalmanagement.utils.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {

	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String path;

	private ErrorResponse() {
		timestamp = LocalDateTime.now();
	}

	public ErrorResponse(HttpStatus status) {
		this();
		this.status = status;
	}

	public ErrorResponse(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = "Unexpected error";
		this.path = ex.getLocalizedMessage();
	}

	public ErrorResponse(HttpStatus status, Throwable ex ,String path) {
		this();
		this.status = status;
		this.message =  ex.getLocalizedMessage();
		this.path = path;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getpath() {
		return path;
	}

	public void setpath(String path) {
		this.path = path;
	}

}
