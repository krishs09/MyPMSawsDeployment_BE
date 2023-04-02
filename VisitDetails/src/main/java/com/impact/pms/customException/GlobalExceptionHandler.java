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

@ControllerAdvice
public class GlobalExceptionHandler {

	
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

	@ExceptionHandler(value=AppointmentNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorResponse> handleAppointemntNotFoundError() {
		
		
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Appointment Not Found");
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		 
	}
	
	@ExceptionHandler(value=NoTimeSlotsFoundException.class)
	public @ResponseBody ResponseEntity<ErrorResponse> handleTimeSlotNotFoundError() {
		
		
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Time slots Not Found");
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		 
	}
	
	@ExceptionHandler(value=PatientNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorResponse> handlePatientNotFoundError() {
		
		
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Patient Not Found");
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		 
	}
	
	

	
	
}
