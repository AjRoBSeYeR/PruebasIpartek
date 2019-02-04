package com.ipartek.formacion.taller.modelo.pojo;

public class Vehiculo {

	private int id;
	private String numeroBastidor;
	private String matricula;

	public Vehiculo() {
		super();
		this.id = -1;
		this.numeroBastidor = "";
		this.matricula = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroBastidor() {
		return numeroBastidor;
	}

	public void setNumeroBastidor(String numeroBastidor) {
		this.numeroBastidor = numeroBastidor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Vehiculo(int id, String numeroBastidor, String matricula) {
		this();
		this.setId(id);
		this.setNumeroBastidor(numeroBastidor);
		this.setMatricula(matricula);
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", numeroBastidor=" + numeroBastidor + ", matricula=" + matricula + "]";
	}

}
