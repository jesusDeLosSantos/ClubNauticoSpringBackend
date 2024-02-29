package com.example.ClubNauticoSpring2.excepciones;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.ClubNauticoSpring2.dto.ErrorDetalles;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ControladorExcepciones extends ResponseEntityExceptionHandler{

	@ExceptionHandler(RecursoNoEncontradoException.class)
	public ResponseEntity<ErrorDetalles> cResourceNotFoundException(RecursoNoEncontradoException exception, WebRequest wr){
		ErrorDetalles detalles = new ErrorDetalles(new Date(), exception.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(detalles, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoPatronException.class)
	public ResponseEntity<ErrorDetalles> cNotPatronException(NoPatronException exception, WebRequest wr){
		ErrorDetalles detalles = new ErrorDetalles(new Date(), exception.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(detalles, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Map<String, String> errores = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String nombreCampo = ((FieldError)error).getField();
			String mensaje = error.getDefaultMessage();
			errores.put(nombreCampo, mensaje);
		});
		return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
	}
}
