package com.ipartek.formacion.modelo.pojo;

public class Coche {
	private Long id;
	private String matricula;
	private String modelo;
	private Integer km;
	private String fechabaja;
	
	public Coche(Long id, String matricula, String modelo, Integer km, String fechabaja) {
		this();
		setId(id);
		setMatricula(matricula);
		setModelo(modelo);
		setKm(km);
		setFechabaja(fechabaja);
	}

	public String getFechabaja() {
		return fechabaja;
	}

	public void setFechabaja(String fechabaja) {
		this.fechabaja = fechabaja;
	}

	public Coche() {
		super();
		this.id=-1l;
		this.matricula="";
		this.modelo="";
		this.km=0;
		this.fechabaja=null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", matricula=" + matricula + ", modelo=" + modelo + ", km=" + km + ", fechabaja="
				+ fechabaja + "]";
	}

	
	
	

}
