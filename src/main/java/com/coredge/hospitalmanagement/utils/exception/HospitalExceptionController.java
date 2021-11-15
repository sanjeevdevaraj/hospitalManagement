package com.coredge.hospitalmanagement.utils.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.coredge.hospitalmanagement.utils.dto.ErrorResponse;

@ControllerAdvice
public class HospitalExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public final ResponseEntity<Object> handleRecordNotFoundException(DataNotFoundException ex, WebRequest request,
			HttpServletRequest req) {
		return new ResponseEntity(new ErrorResponse(HttpStatus.NOT_FOUND, ex, req.getRequestURI()), HttpStatus.OK);

	}
}
