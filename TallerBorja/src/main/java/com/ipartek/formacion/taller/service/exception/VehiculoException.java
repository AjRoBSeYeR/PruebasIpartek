package com.ipartek.formacion.taller.service.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
@SuppressWarnings({ "rawtypes" })
public class VehiculoException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_EXIST = "El vehiculo ya existe";
	
	public static final String EXCEPTION_CONSTRAINT = "No se puede eliminar  un Vehiculo con  asociaciones";
	
	public static final String EXCEPTION_VIOLATIONS = "No cumple las condiciones de Validación";
	
	public static final String EXCEPTION_GENERIC = "Error desconocido en la base de datos";

	
	
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
