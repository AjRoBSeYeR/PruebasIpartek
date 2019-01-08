package com.ipartek.formacion.modelo.pojo;

public class Agente {
	private Long id;
	private String nombre;
	private String placa;
	
	
	public Agente(Long id, String nombre, String placa) {
		this();
		setId( id);
		setNombre(nombre);
		setPlaca(placa);
	}


	public Agente() {
		super();
		this.id=-1l;
		this.nombre="";
		this.placa="";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	@Override
	public String toString() {
		return "Agente [id=" + id + ", nombre=" + nombre + ", placa=" + placa + "]";
	}

}
