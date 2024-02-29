package com.example.ClubNauticoSpring2.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class NoPatronException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String nombreRecurso;
	private String nombreCampo;
	private String idCampo;
	
	public NoPatronException(String nombreRecurso, String nombreCampo, String idCampo) {
		super(String.format("%s con %s '%s' no es patrón", nombreRecurso, nombreCampo, idCampo));
		this.nombreRecurso = nombreRecurso;
		this.nombreCampo = nombreCampo;
		this.idCampo = idCampo;
	}
}
