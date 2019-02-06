package com.ipartek.formacion.taller.service.exception;

public class RolException extends Exception {

	public RolException(String mensaje) {
		super(mensaje);
	}
	private static final long serialVersionUID = 1L;
	public static final String EXCEPTION_EXISTS = "El rol ya existe";
	public static final String EXCEPTION_COSTRAINT = "No se sepuede eliminar ya que este rol tiene personas asociadas";

}
