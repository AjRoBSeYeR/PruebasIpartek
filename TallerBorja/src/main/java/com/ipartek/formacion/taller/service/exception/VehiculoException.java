package com.ipartek.formacion.taller.service.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
@SuppressWarnings({ "rawtypes" })
public class VehiculoException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_EXIST = "El vehiculo ya existe";
	
	public static final String EXCEPTION_CONSTRAINT = "Alguno de los datos proporcionados ya se encuentra registrado";
	
	public static final String EXCEPTION_VIOLATIONS = "No cumple las condiciones de Validación";
	
	public static final String EXCEPTION_GENERIC = "Error desconocido en la base de datos";

	public static final String EXCEPTION_FK_CONSTRAINT = "No existe niguna referencia hacia el modelo, propietario o combustible que se intenta registrar";
	
	
	private Set<ConstraintViolation> violations;
	
	public VehiculoException(String message) {
		super(message);				
		this.violations = null;
	}


	
	public VehiculoException(String message, Set<ConstraintViolation> violations) {
		this(message);
		this.setViolations(violations);
	}


	public Set<ConstraintViolation> getViolations() {
		return violations;
	}


	public void setViolations(Set<ConstraintViolation> violations) {
		this.violations = violations;
	}
	
	
}
