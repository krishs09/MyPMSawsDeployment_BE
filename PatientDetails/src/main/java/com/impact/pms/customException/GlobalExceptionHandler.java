package com.impact.pms.customException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.impact.pms.dto.ErrorResponse;
import com.impact.pms.model.UserPatient;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=PatientAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody ResponseEntity<ErrorResponse> handlePatientExistsError() {
		
		ErrorResponse error = new ErrorResponse(HttpStatus.CONFLICT.value(),"Patient Already Exists");
		
		 return new  ResponseEntity<ErrorResponse>(error, HttpStatus.CONFLICT); 
		
	}
	
	@ExceptionHandler(value=DemographicDetailsExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody ResponseEntity<ErrorResponse> handleDemographicExistsError() {
		
		ErrorResponse error = new ErrorResponse(HttpStatus.CONFLICT.value(),"Demograhic Details Already Exists");
		
		 return new  ResponseEntity<ErrorResponse>(error, HttpStatus.CONFLICT); 
		
	}
	
	@ExceptionHandler(value=Exception.class)
	public @ResponseBody ResponseEntity<ErrorResponse> handleInternalServerError(Exception ex, 
            HttpServletRequest request, HttpServletResponse response) {
		
		ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server error");
		 ex.printStackTrace();
		
		 if (ex instanceof NullPointerException) {
			 ErrorResponse error2 = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"NUll Pointer Exception");
	            return new ResponseEntity<ErrorResponse>(error2,HttpStatus.BAD_REQUEST);
	        }
		 	else if(ex instanceof HttpMessageNotReadableException) {
			
		 		ErrorResponse error3 = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"Bad Request");
		 		return new ResponseEntity<ErrorResponse>(error3,HttpStatus.BAD_REQUEST);
		 		
		 }else {
			    return new  ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR); 
		 }
	}
	
	@ExceptionHandler(value=DemographicDetailsNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseEntity<ErrorResponse> handleDemographicNotFoundError() {
		
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Demograhic Details Not Found");
		
		 return new  ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND); 
		
	}
	
	@ExceptionHandler(value=PatientNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseEntity<ErrorResponse> handlePatientNotFoundError() {
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Patient Not Found");
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	
}
