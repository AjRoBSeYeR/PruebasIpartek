package com.ipartek.formacion.modelo.pojo;

import java.sql.Date;

public class Reparacion {
	private Long id;
	private Date  fecha;
	private Long trabajador;
	private Long vehiculo;
	private Float precio;
	private String observaciones;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Long getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(Long trabajador) {
		this.trabajador = trabajador;
	}
	public Long getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Long vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Reparacion(Long id, Date fecha, Long trabajador, Long vehiculo, Float precio, String observaciones) {
		this();
		setId(id);
		setFecha(fecha);
		setTrabajador(trabajador);
		setVehiculo(vehiculo);
		setPrecio(precio);
		setObservaciones(observaciones);
	}
	public Reparacion() {
		super();
	}
	@Override
	public String toString() {
		return "Reparacion [id=" + id + ", fecha=" + fecha + ", trabajador=" + trabajador + ", vehiculo=" + vehiculo
				+ ", precio=" + precio + ", observaciones=" + observaciones + "]";
	}
	
	
	
	

}
