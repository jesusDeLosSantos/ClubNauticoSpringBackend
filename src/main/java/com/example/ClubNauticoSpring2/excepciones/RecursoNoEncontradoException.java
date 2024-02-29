package com.example.ClubNauticoSpring2.excepciones;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private String nombreRecurso;
	private String nombreCampo;
	private String idCampo;

	public RecursoNoEncontradoException(String nombreRecurso, String nombreCampo, String idCampo) {
		super(String.format("%s con %s '%s' no encontrado.", nombreRecurso, nombreCampo, idCampo));
		this.nombreRecurso = nombreRecurso;
		this.nombreCampo = nombreCampo;
		this.idCampo = idCampo;
	}
}
