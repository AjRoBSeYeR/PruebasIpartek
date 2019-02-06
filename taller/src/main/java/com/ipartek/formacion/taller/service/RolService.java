package com.ipartek.formacion.taller.service;

import java.util.ArrayList;

import com.ipartek.formacion.taller.modelo.pojo.Rol;
import com.ipartek.formacion.taller.service.exception.RolException;

public interface RolService {
	
	
	/**
	 * listado rol ordenado por id descendente
	 * @return ArrayList<rol>, vacio si no hay datos
	 */
	ArrayList<Rol> listar();
	
	/**
	 * obtener detalle rol
	 * @param idrol identificador de rol
	 * @return rol si encuentra, sino <b>null</b>
	 */
	
	Rol detalle(int idrol);
	/**
	 * elimina registro de conbustibles por identificador
	 * @param idrol identificador rol
	 * @return true si elimina, false si no lo encuentra
	 * @throws rolException  si tiene vehiculos asociados o no existe identificador
	 * @see rolException
	 */
	boolean eliminar (int idrol) throws RolException;
	/**
	 * crear registro de rol
	 * @param rol datos de rol
	 * @return true si lo crea, false si no lo hace (no vacio, min 1 max 45)
	 * @throws rolException si ya existe
	 */
	
	boolean crear (Rol rol) throws RolException;
	/**
	 * modifica datos de rol
	 * @param idrol identificador de rol
	 * @return true si se hizo la modificacion, false si no se hizo (no vacio, min 1 max 45)
	 * @throws rolException si no existe
	 */
	
	boolean modificar (Rol rol) throws RolException;
	

	
	
	

}
