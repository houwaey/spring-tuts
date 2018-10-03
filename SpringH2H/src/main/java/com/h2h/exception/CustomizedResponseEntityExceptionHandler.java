package com.h2h.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.h2h.dto.ErrorObject;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ Error.class })
    public final ResponseEntity<Object> handleAllError(Error err, WebRequest request) {
        return new ResponseEntity<Object>(
        							new ErrorObject(HttpStatus.INTERNAL_SERVER_ERROR
        											, err.getMessage()
        											, err.getClass().getName()
        											, request.getDescription(true))
        							, HttpStatus.INTERNAL_SERVER_ERROR
        						);
    }
	
	@ExceptionHandler({ Exception.class })
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
        							new ErrorObject(HttpStatus.INTERNAL_SERVER_ERROR
        											, ex.getMessage()
        											, ex.getClass().getName()
        											, request.getDescription(true))
        							, HttpStatus.INTERNAL_SERVER_ERROR
        						);
    }
	
	@ExceptionHandler({ NotFoundException.class })
	public final ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {
		return new ResponseEntity<Object>(
					new ErrorObject(HttpStatus.NOT_FOUND
									, ex.getMessage()
									, ex.getClass().getName()
									, request.getDescription(true))
					, HttpStatus.NOT_FOUND
				);
	}
	
}
