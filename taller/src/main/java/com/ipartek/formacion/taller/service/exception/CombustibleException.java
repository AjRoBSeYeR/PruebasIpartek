package com.ipartek.formacion.taller.service.exception;

public class CombustibleException extends Exception {

	public CombustibleException(String mensaje) {
		super(mensaje);
	}
	private static final long serialVersionUID = 1L;
	public static final String EXCEPTION_EXISTS = "El combustible ya existe";
	public static final String EXCEPTION_COSTRAINT = "No se sepuede eliminar ya que este combustible tiene vehiculos asociados";

}
